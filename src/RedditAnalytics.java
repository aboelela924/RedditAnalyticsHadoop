import com.google.gson.Gson;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class RedditAnalytics {

    public static class MapperImpl extends Mapper<LongWritable, Text, Text, IntWritable> {

        public void map(LongWritable key, Text value, Mapper.Context context) throws IOException, InterruptedException {
            Gson gson = new Gson();
            Comment comment = gson.fromJson(value.toString(), Comment.class);
            comment.cleanComment();
            IntWritable one = new IntWritable(1);
            String[] words  = comment.getBody().split("\\s+");
            for(String word : words){
                Text subredditAndWord = new Text(comment.getSubreddit()+"-"+word);
                Text userNameAndWord = new Text(comment.getName()+"-"+word);
                context.write(subredditAndWord, one);
                context.write(userNameAndWord, one);
            }
        }
    }

    public static class ReducerImpl extends Reducer<Text, IntWritable, Text, IntWritable> {
        public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
            int counter  = 0;

            while(values.iterator().hasNext()){
                counter++;
            }

            IntWritable intWritableCounter = new IntWritable(counter);
            context.write(key,intWritableCounter);
        }

        @Override
        protected void cleanup(Context context) throws IOException, InterruptedException {
            super.cleanup(context);
        }
    }

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = new Job(conf, "Most Discussed topics by subreddit");
        job.setJarByClass(RedditAnalytics.class);
        job.setMapperClass(MapperImpl.class);
        job.setCombinerClass(ReducerImpl.class);
        job.setReducerClass(ReducerImpl.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        FileInputFormat.addInputPath(job, new Path(args[1]));
        FileOutputFormat.setOutputPath(job, new Path(args[2]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
