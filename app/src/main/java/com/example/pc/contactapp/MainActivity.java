package com.example.pc.contactapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //onCreate method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //search methode on search button click
    public void searchMeth(View v){
        Intent searchIntent = new Intent(MainActivity.this, Search_Activity.class);
        startActivity(searchIntent);
    }

    //add methode on add button click
    public void addmeth(View v){
        Intent addIntent = new Intent(MainActivity.this, Add_Activity.class);
        startActivity(addIntent);
    }
}
