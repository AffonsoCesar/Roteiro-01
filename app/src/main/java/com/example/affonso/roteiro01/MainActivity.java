package com.example.affonso.roteiro01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTexto = (TextView)findViewById(R.id.texto);
        Bundle b = getIntent().getExtras();
        String texto = b.getString("Usuario");
        mTexto.setText("Olá "+texto+ " seja bem vindo!");
    }
}
