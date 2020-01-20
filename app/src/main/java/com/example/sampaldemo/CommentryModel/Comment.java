
package com.example.sampaldemo.CommentryModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Comment {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("ballType")
    @Expose
    private String ballType;
    @SerializedName("dateTime")
    @Expose
    private String dateTime;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("isFallOfWicket")
    @Expose
    private Boolean isFallOfWicket;
    @SerializedName("batsmanId")
    @Expose
    private Integer batsmanId;
    @SerializedName("batsmanName")
    @Expose
    private String batsmanName;
    @SerializedName("bowlerId")
    @Expose
    private Integer bowlerId;
    @SerializedName("bowlerName")
    @Expose
    private String bowlerName;
    @SerializedName("runs")
    @Expose
    private String runs;
    @SerializedName("battingTeamScore")
    @Expose
    private Integer battingTeamScore;
    @SerializedName("offStrikeBatsmanId")
    @Expose
    private Integer offStrikeBatsmanId;
    @SerializedName("wickets")
    @Expose
    private Integer wickets;
    @SerializedName("wicketSummary")
    @Expose
    private WicketSummary wicketSummary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBallType() {
        return ballType;
    }

    public void setBallType(String ballType) {
        this.ballType = ballType;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getIsFallOfWicket() {
        return isFallOfWicket;
    }

    public void setIsFallOfWicket(Boolean isFallOfWicket) {
        this.isFallOfWicket = isFallOfWicket;
    }

    public Integer getBatsmanId() {
        return batsmanId;
    }

    public void setBatsmanId(Integer batsmanId) {
        this.batsmanId = batsmanId;
    }

    public String getBatsmanName() {
        return batsmanName;
    }

    public void setBatsmanName(String batsmanName) {
        this.batsmanName = batsmanName;
    }

    public Integer getBowlerId() {
        return bowlerId;
    }

    public void setBowlerId(Integer bowlerId) {
        this.bowlerId = bowlerId;
    }

    public String getBowlerName() {
        return bowlerName;
    }

    public void setBowlerName(String bowlerName) {
        this.bowlerName = bowlerName;
    }

    public String getRuns() {
        return runs;
    }

    public void setRuns(String runs) {
        this.runs = runs;
    }

    public Integer getBattingTeamScore() {
        return battingTeamScore;
    }

    public void setBattingTeamScore(Integer battingTeamScore) {
        this.battingTeamScore = battingTeamScore;
    }

    public Integer getOffStrikeBatsmanId() {
        return offStrikeBatsmanId;
    }

    public void setOffStrikeBatsmanId(Integer offStrikeBatsmanId) {
        this.offStrikeBatsmanId = offStrikeBatsmanId;
    }

    public Integer getWickets() {
        return wickets;
    }

    public void setWickets(Integer wickets) {
        this.wickets = wickets;
    }

    public WicketSummary getWicketSummary() {
        return wicketSummary;
    }

    public void setWicketSummary(WicketSummary wicketSummary) {
        this.wicketSummary = wicketSummary;
    }

}
