package com.example.mycarapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ApplicationPreferences {

    static final String KEYNAME = "MYCAR";


    private  static SharedPreferences mSharedPref;

    private ApplicationPreferences() {}

    public static void init(Context context) {
        if(mSharedPref == null) {
            mSharedPref = context.getSharedPreferences(KEYNAME, Activity.MODE_PRIVATE);
        }
    }

    public static void saveCar(CarModel value) {

        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        Gson gson = new Gson();
        String json = gson.toJson(value);
        prefsEditor.putString(KEYNAME, json);
        prefsEditor.apply();
    }

    public static CarModel readCar(String defValue) {

        Gson gson = new Gson();
        String json = mSharedPref.getString(KEYNAME, null);
        Type type = new TypeToken<CarModel>(){}.getType();
        return gson.fromJson(json, type);

    }
}
