
package com.example.sampaldemo.CommentryModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OverSummary {

    @SerializedName("bowlersId")
    @Expose
    private Integer bowlersId;
    @SerializedName("bowlersName")
    @Expose
    private String bowlersName;
    @SerializedName("bowlersBowlingFigures")
    @Expose
    private String bowlersBowlingFigures;
    @SerializedName("battingTeamsScore")
    @Expose
    private String battingTeamsScore;
    @SerializedName("runsConcededinOver")
    @Expose
    private String runsConcededinOver;
    @SerializedName("extrasConcededinOver")
    @Expose
    private String extrasConcededinOver;
    @SerializedName("wicketsTakeninOver")
    @Expose
    private String wicketsTakeninOver;

    public Integer getBowlersId() {
        return bowlersId;
    }

    public void setBowlersId(Integer bowlersId) {
        this.bowlersId = bowlersId;
    }

    public String getBowlersName() {
        return bowlersName;
    }

    public void setBowlersName(String bowlersName) {
        this.bowlersName = bowlersName;
    }

    public String getBowlersBowlingFigures() {
        return bowlersBowlingFigures;
    }

    public void setBowlersBowlingFigures(String bowlersBowlingFigures) {
        this.bowlersBowlingFigures = bowlersBowlingFigures;
    }

    public String getBattingTeamsScore() {
        return battingTeamsScore;
    }

    public void setBattingTeamsScore(String battingTeamsScore) {
        this.battingTeamsScore = battingTeamsScore;
    }

    public String getRunsConcededinOver() {
        return runsConcededinOver;
    }

    public void setRunsConcededinOver(String runsConcededinOver) {
        this.runsConcededinOver = runsConcededinOver;
    }

    public String getExtrasConcededinOver() {
        return extrasConcededinOver;
    }

    public void setExtrasConcededinOver(String extrasConcededinOver) {
        this.extrasConcededinOver = extrasConcededinOver;
    }

    public String getWicketsTakeninOver() {
        return wicketsTakeninOver;
    }

    public void setWicketsTakeninOver(String wicketsTakeninOver) {
        this.wicketsTakeninOver = wicketsTakeninOver;
    }

}
