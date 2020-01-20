
package com.example.sampaldemo.CommentryModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WicketSummary {

    @SerializedName("batsmanName")
    @Expose
    private String batsmanName;
    @SerializedName("dismissalMethod")
    @Expose
    private String dismissalMethod;
    @SerializedName("batsmanRuns")
    @Expose
    private String batsmanRuns;
    @SerializedName("ballsFaced")
    @Expose
    private String ballsFaced;
    @SerializedName("batsman4sinInnings")
    @Expose
    private String batsman4sinInnings;
    @SerializedName("batsman6sinInnings")
    @Expose
    private String batsman6sinInnings;
    @SerializedName("strikeRate")
    @Expose
    private String strikeRate;

    public String getBatsmanName() {
        return batsmanName;
    }

    public void setBatsmanName(String batsmanName) {
        this.batsmanName = batsmanName;
    }

    public String getDismissalMethod() {
        return dismissalMethod;
    }

    public void setDismissalMethod(String dismissalMethod) {
        this.dismissalMethod = dismissalMethod;
    }

    public String getBatsmanRuns() {
        return batsmanRuns;
    }

    public void setBatsmanRuns(String batsmanRuns) {
        this.batsmanRuns = batsmanRuns;
    }

    public String getBallsFaced() {
        return ballsFaced;
    }

    public void setBallsFaced(String ballsFaced) {
        this.ballsFaced = ballsFaced;
    }

    public String getBatsman4sinInnings() {
        return batsman4sinInnings;
    }

    public void setBatsman4sinInnings(String batsman4sinInnings) {
        this.batsman4sinInnings = batsman4sinInnings;
    }

    public String getBatsman6sinInnings() {
        return batsman6sinInnings;
    }

    public void setBatsman6sinInnings(String batsman6sinInnings) {
        this.batsman6sinInnings = batsman6sinInnings;
    }

    public String getStrikeRate() {
        return strikeRate;
    }

    public void setStrikeRate(String strikeRate) {
        this.strikeRate = strikeRate;
    }

}
