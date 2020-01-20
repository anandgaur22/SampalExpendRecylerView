
package com.example.sampaldemo.CommentryModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CommentryModel {

    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("commentary")
    @Expose
    private Commentary commentary;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("poweredBy")
    @Expose
    private String poweredBy;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Commentary getCommentary() {
        return commentary;
    }

    public void setCommentary(Commentary commentary) {
        this.commentary = commentary;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPoweredBy() {
        return poweredBy;
    }

    public void setPoweredBy(String poweredBy) {
        this.poweredBy = poweredBy;
    }

}
