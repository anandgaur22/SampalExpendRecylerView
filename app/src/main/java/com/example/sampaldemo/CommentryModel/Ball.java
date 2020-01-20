
package com.example.sampaldemo.CommentryModel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ball {

    @SerializedName("ballNumber")
    @Expose
    private Integer ballNumber;
    @SerializedName("comments")
    @Expose
    private List<Comment> comments = null;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("result")
    @Expose
    private String result;

    public Integer getBallNumber() {
        return ballNumber;
    }

    public void setBallNumber(Integer ballNumber) {
        this.ballNumber = ballNumber;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
