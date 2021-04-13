package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.sharedpreferences", Context.MODE_PRIVATE);
        ArrayList<String> friends = new ArrayList<>();
        friends.add("Sirishti");
        friends.add("Shubham");
        friends.add("Shivam");
        try {
            sharedPreferences.edit().putString("Friends", ObjectSerializer.serialize(friends)).apply();
            Log.i("Friends are: ", ObjectSerializer.serialize(friends));
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<String> list = new ArrayList<>();
        try {
            list = (ArrayList<String>)ObjectSerializer.deserialize(sharedPreferences.getString("Friends", ObjectSerializer.serialize(new ArrayList<String>())));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.i("New List is: ", list.toString());
        //SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.sharedpreferences", Context.MODE_PRIVATE);
        //sharedPreferences.edit().putString("username", "shubh").apply();
        //String username = sharedPreferences.getString("username", "");
        //Log.i("Username is: ", username);
    }
}