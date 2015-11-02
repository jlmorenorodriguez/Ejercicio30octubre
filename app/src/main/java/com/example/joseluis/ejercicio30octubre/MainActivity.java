package com.example.joseluis.ejercicio30octubre;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtNombre,edtEdad;
    private TextView txtResult;
    private Button btnComprobar,btnBorrar;
    private final int CODE1 =1 , CODE2 =2;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtNombre = (EditText)findViewById(R.id.edtNombre);
        edtEdad = (EditText) findViewById(R.id.edtEdad);
        txtResult = (TextView)findViewById(R.id.txtResult);
        btnComprobar = (Button)findViewById(R.id.btnComprobar);
        btnComprobar.setOnClickListener(this);
        btnBorrar = (Button)findViewById(R.id.btnBorrar);
        btnBorrar.setOnClickListener(this);

        sp = getSharedPreferences("datos",MODE_PRIVATE);

        mostrarInfo();

    }

    private void mostrarInfo() {

        edtNombre.setText(sp.getString("nombre",""));
        edtEdad.setText(sp.getString("edad",""));
        txtResult.setText(sp.getString("result",""));
    }

    @Override
    public void onClick(View v) {
        SharedPreferences.Editor editor = sp.edit();

        switch (v.getId()){
            case R.id.btnComprobar:
                editor.putString("nombre",edtNombre.getText().toString());
                editor.putString("edad",edtEdad.getText().toString());
                editor.commit();
                int edad = Integer.parseInt(edtEdad.getText().toString());
                if(edad>18){

                    Intent i = new Intent(MainActivity.this,Main2Activity.class);
                    startActivityForResult(i,CODE1);

                }else if(edad<18){

                    Intent i2 = new Intent(MainActivity.this,Main3Activity.class);
                    startActivityForResult(i2, CODE2);
                }
                else{
                    Toast.makeText(getApplicationContext(),
                            getResources().getString(R.string.msgError), Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.btnBorrar:
                editor.clear();
                editor.commit();
                mostrarInfo();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode){
            case CODE1:

                if(resultCode==RESULT_OK){
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("result", data.getStringExtra("result"));
                    editor.commit();
                }

                break;
            case CODE2:
                if(resultCode==RESULT_OK){
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("result",data.getStringExtra("result"));
                    editor.commit();
                }

                break;
        }
        txtResult.setText(sp.getString("result",""));

    }
}
