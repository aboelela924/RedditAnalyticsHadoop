import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Comment {
    @SerializedName("score_hidden")
    @Expose
    private Boolean scoreHidden;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("link_id")
    @Expose
    private String linkId;
    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("downs")
    @Expose
    private Integer downs;
    @SerializedName("created_utc")
    @Expose
    private String createdUtc;
    @SerializedName("score")
    @Expose
    private Integer score;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("distinguished")
    @Expose
    private Object distinguished;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("archived")
    @Expose
    private Boolean archived;
    @SerializedName("parent_id")
    @Expose
    private String parentId;
    @SerializedName("subreddit")
    @Expose
    private String subreddit;
    @SerializedName("author_flair_css_class")
    @Expose
    private Object authorFlairCssClass;
    @SerializedName("author_flair_text")
    @Expose
    private Object authorFlairText;
    @SerializedName("gilded")
    @Expose
    private Integer gilded;
    @SerializedName("retrieved_on")
    @Expose
    private Integer retrievedOn;
    @SerializedName("ups")
    @Expose
    private Integer ups;
    @SerializedName("controversiality")
    @Expose
    private Integer controversiality;
    @SerializedName("subreddit_id")
    @Expose
    private String subredditId;
    @SerializedName("edited")
    @Expose
    private Boolean edited;

    public Boolean getScoreHidden() {
        return scoreHidden;
    }

    public void setScoreHidden(Boolean scoreHidden) {
        this.scoreHidden = scoreHidden;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getDowns() {
        return downs;
    }

    public void setDowns(Integer downs) {
        this.downs = downs;
    }

    public String getCreatedUtc() {
        return createdUtc;
    }

    public void setCreatedUtc(String createdUtc) {
        this.createdUtc = createdUtc;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Object getDistinguished() {
        return distinguished;
    }

    public void setDistinguished(Object distinguished) {
        this.distinguished = distinguished;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getSubreddit() {
        return subreddit;
    }

    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    public Object getAuthorFlairCssClass() {
        return authorFlairCssClass;
    }

    public void setAuthorFlairCssClass(Object authorFlairCssClass) {
        this.authorFlairCssClass = authorFlairCssClass;
    }

    public Object getAuthorFlairText() {
        return authorFlairText;
    }

    public void setAuthorFlairText(Object authorFlairText) {
        this.authorFlairText = authorFlairText;
    }

    public Integer getGilded() {
        return gilded;
    }

    public void setGilded(Integer gilded) {
        this.gilded = gilded;
    }

    public Integer getRetrievedOn() {
        return retrievedOn;
    }

    public void setRetrievedOn(Integer retrievedOn) {
        this.retrievedOn = retrievedOn;
    }

    public Integer getUps() {
        return ups;
    }

    public void setUps(Integer ups) {
        this.ups = ups;
    }

    public Integer getControversiality() {
        return controversiality;
    }

    public void setControversiality(Integer controversiality) {
        this.controversiality = controversiality;
    }

    public String getSubredditId() {
        return subredditId;
    }

    public void setSubredditId(String subredditId) {
        this.subredditId = subredditId;
    }

    public Boolean getEdited() {
        return edited;
    }

    public void setEdited(Boolean edited) {
        this.edited = edited;
    }

    public void cleanComment(){
        Pattern p = Pattern.compile("\\b(i|me|my|myself|we|our|ours|ourselves|you|you're|you've|you'll|you'd|your|yours|yourself|yourselves|he|him|his|himself|she|she's|her|hers|herself|it|it's|its|itself|they|them|their|theirs|themselves|what|which|who|whom|this|that|that'll|these|those|am|is|are|was|were|be|been|being|have|has|had|having|do|does|did|doing|a|an|the|and|but|if|or|because|as|until|while|of|at|by|for|with|about|against|between|into|through|during|before|after|above|below|to|from|up|down|in|out|on|off|over|under|again|further|then|once|here|there|when|where|why|how|all|any|both|each|few|more|most|other|some|such|no|nor|not|only|own|same|so|than|too|very|s|t|can|will|just|don|don't|should|should've|now|d|ll|m|o|re|ve|y|ain|aren|aren't|couldn|couldn't|didn|didn't|doesn|doesn't|hadn|hadn't|hasn|hasn't|haven|haven't|isn|isn't|ma|mightn|mightn't|mustn|mustn't|needn|needn't|shan|shan't|shouldn|shouldn't|wasn|wasn't|weren|weren't|won|won't|wouldn|wouldn't\n)\\b\\s?");
        Matcher m = p.matcher(this.body);
        this.body = m.replaceAll("");
    }
}
