package com.litetech.libs.statemangerlibrary;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.litetech.libs.statemanager.StateManger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StateManger.init(this);

        AppCompatButton save = findViewById(R.id.save);
        AppCompatButton retrieve = findViewById(R.id.retrieve);
        AppCompatButton delete = findViewById(R.id.del);
        final AppCompatTextView storedText = findViewById(R.id.storedTExt);
        final AppCompatEditText text = findViewById(R.id.text);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(text.getText().toString())){
                    StateManger.getInstance().saveObject("text",text.getText().toString());
                    Toast.makeText(getApplicationContext(),"Saved",Toast.LENGTH_SHORT).show();
                }
            }
        });


        retrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stText = StateManger.getInstance().getObject("text",String.class);
                if (stText != null){
                    storedText.setText(stText);
                }else {
                    Toast.makeText(getApplicationContext(),"No text found",Toast.LENGTH_SHORT).show();
                }
            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StateManger.getInstance().deleteObject("text");
                Toast.makeText(getApplicationContext(),"Data deleted",Toast.LENGTH_SHORT).show();
                storedText.setText("");
            }
        });


    }
}

