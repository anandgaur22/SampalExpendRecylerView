
package com.example.sampaldemo.CommentryModel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Commentary {

    @SerializedName("innings")
    @Expose
    private List<Inning> innings = null;

    public List<Inning> getInnings() {
        return innings;
    }

    public void setInnings(List<Inning> innings) {
        this.innings = innings;
    }

}
