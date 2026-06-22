package com.example.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button b;
    EditText edpeso, edaltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = findViewById(R.id.button);
        edaltura = findViewById(R.id.edAltura);
        edpeso = findViewById(R.id.edPeso);

        b.setOnClickListener(v -> {
            String strPeso = edpeso.getText().toString();
            String strAltura = edaltura.getText().toString();

            if(strPeso.isEmpty()){
                edpeso.setError("Informe o peso");
                edpeso.requestFocus();
                return;
            }

            if(strAltura.isEmpty()){
                edaltura.setError("Informe a altura");
                edaltura.requestFocus();
                return;
            }

            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("peso", strPeso);
            intent.putExtra("altura", strAltura);
            startActivity(intent);
        });
    }
}