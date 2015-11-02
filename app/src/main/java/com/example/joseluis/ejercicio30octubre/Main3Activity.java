package com.example.joseluis.ejercicio30octubre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class Main3Activity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    private CheckBox chk1,chk2,chk3,chk4,chk5,chk6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        chk1 = (CheckBox)findViewById(R.id.chk1);
        chk2 = (CheckBox)findViewById(R.id.chk2);
        chk3 = (CheckBox)findViewById(R.id.chk3);
        chk4 = (CheckBox)findViewById(R.id.chk4);
        chk5 = (CheckBox)findViewById(R.id.chk5);
        chk6 = (CheckBox)findViewById(R.id.chk6);
        chk1.setOnCheckedChangeListener(this);
        chk2.setOnCheckedChangeListener(this);
        chk3.setOnCheckedChangeListener(this);
        chk4.setOnCheckedChangeListener(this);
        chk5.setOnCheckedChangeListener(this);
        chk6.setOnCheckedChangeListener(this);


    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.chk1:
            case R.id.chk2:
            case R.id.chk3:
            case R.id.chk4:
            case R.id.chk5:
            case R.id.chk6:
                //(buttonView).getText().toString();
                Intent i = new Intent();
                i.putExtra("result",(buttonView).getText().toString());
                setResult(RESULT_OK,i);
                finish();
                break;
        }
    }

}
