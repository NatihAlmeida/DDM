package com.natasha.viewsgrouplista;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityFormularioConstraint extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_constraint);

        // Mapear os componentes
        final EditText editNome = findViewById(R.id.editNome);
        final EditText editEmail = findViewById(R.id.editEmail);
        Button btnEnviar = findViewById(R.id.btnCalendario); // Mantive seu ID original

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editNome.getText().toString();
                String email = editEmail.getText().toString();

                String mensagem = "Nome: " + nome + " | E-mail: " + email;
                Toast.makeText(ActivityFormularioConstraint.this, mensagem, Toast.LENGTH_LONG).show();
            }
        });
    }
}