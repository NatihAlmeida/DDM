package com.example.myapplication;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;

public class MainActivity2 extends AppCompatActivity {

    TextView tvIMC;
    TextView tvClassificacao;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvIMC = findViewById(R.id.tvIMC);
        tvClassificacao = findViewById(R.id.tvClassificacao);
        imageView = findViewById(R.id.imageView);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null){

            double peso = Double.parseDouble(bundle.getString("peso"));
            double altura = Double.parseDouble(bundle.getString("altura"));

            double imc = peso / (altura * altura);

            DecimalFormat dc = new DecimalFormat("##.##");
            tvIMC.setText(dc.format(imc));

            if(imc < 18.5){
                tvClassificacao.setText("Abaixo do peso");
                imageView.setImageResource(R.drawable.abaixopeso);
            }
            else if(imc < 25){
                tvClassificacao.setText("Peso normal");
                imageView.setImageResource(R.drawable.normal);
            }
            else if(imc < 30){
                tvClassificacao.setText("Sobrepeso");
                imageView.setImageResource(R.drawable.sobrepeso);
            }
            else if(imc < 35){
                tvClassificacao.setText("Obesidade grau 1");
                imageView.setImageResource(R.drawable.obesidade1);
            }
            else if(imc < 40){
                tvClassificacao.setText("Obesidade grau 2");
                imageView.setImageResource(R.drawable.obesidade2);
            }
            else{
                tvClassificacao.setText("Obesidade grau 3");
                imageView.setImageResource(R.drawable.obesidade3);
            }
        }
    }
}