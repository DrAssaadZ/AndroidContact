package com.example.pc.contactapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_Activity extends AppCompatActivity {

    DatabaseHelper myinstance;
    EditText Fname,Lname,Num;
    Button addContatctButton;

    //onCreate method of the add activity class
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_);
        Fname = (EditText)findViewById(R.id.NameEditText);
        Lname = (EditText)findViewById(R.id.LastNameEditText);
        Num = (EditText)findViewById(R.id.PhoneEditText);
        addContatctButton = (Button)findViewById(R.id.AddContactBtn);
        myinstance = new DatabaseHelper(this);
    }

    //add data to database
    public void addDateMeth(View v){
        try {
            myinstance.insertData(Fname.getText().toString(), Lname.getText().toString(), Num.getText().toString());
            Toast.makeText(this,"Guest added",Toast.LENGTH_LONG).show();
            Fname.setText("");
            Lname.setText("");
            Num.setText("");
        }catch (Exception e){
            Toast.makeText(this,"Guest wasn't added",Toast.LENGTH_LONG).show();
        }
    }
}
