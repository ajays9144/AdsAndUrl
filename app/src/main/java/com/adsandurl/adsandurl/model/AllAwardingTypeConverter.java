package com.adsandurl.adsandurl.model;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class AllAwardingTypeConverter {
    @TypeConverter
    public static List<AllAwarding> toMedia(String data) {
        Gson gson = new Gson();
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<AllAwarding>>() {
        }.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String toMediaInString(List<AllAwarding> children) {
        Gson gson = new Gson();
        return gson.toJson(children);
    }
}
