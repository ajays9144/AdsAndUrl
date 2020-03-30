package com.adsandurl.adsandurl.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Child implements Serializable {
    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("data")
    @Expose
    private ChildData data;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public ChildData getData() {
        return data;
    }

    public void setData(ChildData data) {
        this.data = data;
    }
}
