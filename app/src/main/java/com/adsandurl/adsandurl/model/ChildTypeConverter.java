package com.adsandurl.adsandurl.model;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class ChildTypeConverter {

    @TypeConverter
    public static List<Child> toChildObject(String children) {
        Gson gson = new Gson();
        if (children == null) {
            return Collections.emptyList();
        }
        Type listType = new TypeToken<List<Child>>() {
        }.getType();
        return gson.fromJson(children, listType);
    }

    @TypeConverter
    public static String toStoreInString(List<Child> children) {
        Gson gson = new Gson();
        return gson.toJson(children);
    }
}
