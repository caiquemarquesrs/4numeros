package com.example.a4numeros;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private EditText edtNumero1, edtNumero2, edtNumero3, edtNumero4;
    private TextView txtResultado;
    private Button btnExecutar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNumero1 = findViewById(R.id.edtNumero1);
        edtNumero2 = findViewById(R.id.edtNumero2);
        edtNumero3 = findViewById(R.id.edtNumero3);
        edtNumero4 = findViewById(R.id.edtNumero4);
        txtResultado = findViewById(R.id.txtResultado);
        btnExecutar = findViewById(R.id.btnExecutar);

        btnExecutar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processarNumeros();
            }
        });
    }

    private void processarNumeros() {
        try {
            int num1 = Integer.parseInt(edtNumero1.getText().toString());
            int num2 = Integer.parseInt(edtNumero2.getText().toString());
            int num3 = Integer.parseInt(edtNumero3.getText().toString());
            int num4 = Integer.parseInt(edtNumero4.getText().toString());

            int[] numeros = {num1, num2, num3, num4};

            String ordemInserida = "Ordem Inserida: " + Arrays.toString(numeros);

            Arrays.sort(numeros);
            String ordemCrescente = "Ordem Crescente: " + Arrays.toString(numeros);

            int[] numerosDecrescente = new int[numeros.length];
            for (int i = 0; i < numeros.length; i++) {
                numerosDecrescente[i] = numeros[numeros.length - 1 - i];
            }
            String ordemDecrescente = "Ordem Decrescente: " + Arrays.toString(numerosDecrescente);

            txtResultado.setText(ordemInserida + "\n" + ordemCrescente + "\n" + ordemDecrescente);

        } catch (NumberFormatException e) {
            txtResultado.setText("Por favor, insira apenas números válidos.");
        }
    }
}
