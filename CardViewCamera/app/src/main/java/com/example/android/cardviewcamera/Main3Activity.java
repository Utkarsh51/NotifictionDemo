package com.example.android.cardviewcamera;

import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {
    EditText edt;
    Button btn;
    ListView lv;
    ArrayList<String> nameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        nameList = new ArrayList<String>();
        //nameList.add("hello");
        btn = findViewById(R.id.button2);
        edt = findViewById(R.id.editText2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edt.getText().toString().isEmpty()){
                    String s =  edt.getText().toString();
                    nameList.add(s);
                }
            }
        });
        lv = findViewById(R.id.lv);
    }
}
