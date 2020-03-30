package com.adsandurl.adsandurl.model;

import androidx.room.TypeConverter;

import com.google.gson.Gson;

public class ChildTypeConverter {

    @TypeConverter
    public static ChildData toChildData(String children) {
        Gson gson = new Gson();
        if (children == null) {
            return new ChildData();
        }
        return gson.fromJson(children, ChildData.class);
    }

    @TypeConverter
    public static String toStoreInString(ChildData children) {
        Gson gson = new Gson();
        return gson.toJson(children);
    }
}
