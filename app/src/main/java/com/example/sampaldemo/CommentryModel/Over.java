
package com.example.sampaldemo.CommentryModel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Over {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("uniqueOverId")
    @Expose
    private String uniqueOverId;
    @SerializedName("number")
    @Expose
    private Integer number;
    @SerializedName("balls")
    @Expose
    private List<Ball> balls = null;
    @SerializedName("overSummary")
    @Expose
    private OverSummary overSummary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUniqueOverId() {
        return uniqueOverId;
    }

    public void setUniqueOverId(String uniqueOverId) {
        this.uniqueOverId = uniqueOverId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public void setBalls(List<Ball> balls) {
        this.balls = balls;
    }

    public OverSummary getOverSummary() {
        return overSummary;
    }

    public void setOverSummary(OverSummary overSummary) {
        this.overSummary = overSummary;
    }

}
