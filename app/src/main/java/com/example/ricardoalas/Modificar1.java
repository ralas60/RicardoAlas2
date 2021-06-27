package com.example.ricardoalas;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Modificar1 extends AppCompatActivity {
    EditText et_nombre, et_apellido, et_contrasena;
    Button bt_modificar;
    int id;
    String nombre;
    String apellido;
    String contrasena;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar1);

        Bundle b= getIntent().getExtras();
        if(b!=null){
            id = b.getInt("Id");
            nombre=b.getString("Nombre");
            apellido=b.getString("Apellido");
            contrasena=b.getString("Contrasena");
        }



        et_nombre = (EditText) findViewById(R.id.et_nombre);
        et_apellido = (EditText) findViewById(R.id.et_apellido);
        et_contrasena = (EditText) findViewById(R.id.et_contrasena);
        et_nombre.setText(nombre);
        et_apellido.setText(apellido);
        et_contrasena.setText(contrasena);

        bt_modificar= (Button) findViewById(R.id.bt_guardar);
        bt_modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Modificar(id, nombre, apellido, contrasena);
                onBackPressed();
            }
        });



    }
    private void Modificar(int Id, String nombre, String Nombre, String Apellido){
        BaseHelper helper = new BaseHelper(this,"Demo", null,1);
        SQLiteDatabase db = helper.getWritableDatabase();

        String sql = "update Personas2 set nombre'"+Nombre + "',Apellido'"+ Apellido + "',Contrasena'"+ contrasena + "' where Id="+Id;
        db.execSQL(sql);
        db.close();
    }
}