package com.litetech.libs.statemanager;


import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;

import java.lang.reflect.Type;

public class StateManger {

    private static SharedPreferences sharedPreferences;
    private static StateManger stateManger;
    private static Gson gson;

    private StateManger(Context context) {
        sharedPreferences = context.getSharedPreferences(context.getPackageName() + ".state", Context.MODE_PRIVATE);
        gson = new Gson();
    }

    public static void init(Context context) {
        if (stateManger == null)
            stateManger = new StateManger(context);
    }


    public static StateManger getInstance() {
        return stateManger;
    }

    public void saveObject(String key, Object object) {
        try {
            String jsonObject = gson.toJson(object);
            sharedPreferences.edit().putString(key, jsonObject).apply();
        } catch (JsonIOException e) {
            throw e;
        }
    }

    public void deleteObject(String key) {
        sharedPreferences.edit().putString(key, null).apply();
    }

    public <T> T getObject(String key, Type type) {
        String jsonString = sharedPreferences.getString(key, null);
        return gson.fromJson(jsonString, type);
    }
//
//    public static Type ListType(final List list){
//        return new TypeToken<ArrayList<>>() {}.getType();
//    }
}
