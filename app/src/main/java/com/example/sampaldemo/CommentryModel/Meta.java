
package com.example.sampaldemo.CommentryModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta {

    @SerializedName("series")
    @Expose
    private Series series;
    @SerializedName("matchTypeId")
    @Expose
    private Integer matchTypeId;
    @SerializedName("matchId")
    @Expose
    private Integer matchId;
    @SerializedName("total")
    @Expose
    private Integer total;

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public Integer getMatchTypeId() {
        return matchTypeId;
    }

    public void setMatchTypeId(Integer matchTypeId) {
        this.matchTypeId = matchTypeId;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

}
