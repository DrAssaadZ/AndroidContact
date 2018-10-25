package com.example.pc.contactapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class Search_Activity extends AppCompatActivity {

    ListView mylist ;
    DatabaseHelper obj ;
    EditText searchEdit;

    //onCreate method of the search activity class
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_);

        searchEdit = (EditText)findViewById(R.id.searchEditText);

        obj = new DatabaseHelper(this);
        mylist = (ListView)findViewById(R.id.searchListView);
        ArrayAdapter<String> datalist = new ArrayAdapter<String>(this,R.layout.display_cont,obj.GetAllData());
        mylist.setAdapter(datalist);
    }

    //showing result in the datalist
    public void showSearchResult(View v){
        ArrayAdapter<String> datalist2 = new ArrayAdapter<String>(this,R.layout.display_cont,obj.searchData(searchEdit.getText().toString()));
        mylist.setAdapter(datalist2);
    }

}
