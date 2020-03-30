package com.adsandurl.adsandurl.model;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "hot_posts")
public class HotChild implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private long id;
    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("data")
    @Expose
    @Embedded
    private ChildData data;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
