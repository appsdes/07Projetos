package com.example.a07projetos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextCliente, editTextNumConta, editTextSaldo, editTextDiaRendimento, editTextTaxaRendimento, editTextLimite, editTextValorOperacao;
    RadioGroup radioGroupConta;
    RadioButton radioButtonPoupanca, radioButtonEspecial;
    Button buttonCriarConta, buttonSacar, buttonDepositar, buttonMostrarDados;
    ContaBancaria contaSelecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCliente = findViewById(R.id.editTextCliente);
        editTextNumConta = findViewById(R.id.editTextNumConta);
        editTextSaldo = findViewById(R.id.editTextSaldo);
        editTextDiaRendimento = findViewById(R.id.editTextDiaRendimento);
        editTextTaxaRendimento = findViewById(R.id.editTextTaxaRendimento);
        editTextLimite = findViewById(R.id.editTextLimite);
        editTextValorOperacao = findViewById(R.id.editTextValorOperacao);
        radioGroupConta = findViewById(R.id.radioGroupConta);
        radioButtonPoupanca = findViewById(R.id.radioButtonPoupanca);
        radioButtonEspecial = findViewById(R.id.radioButtonEspecial);
        buttonCriarConta = findViewById(R.id.buttonCriarConta);
        buttonSacar = findViewById(R.id.buttonSacar);
        buttonDepositar = findViewById(R.id.buttonDepositar);
        buttonMostrarDados = findViewById(R.id.buttonMostrarDados);

        buttonCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                criarConta();
            }
        });

        buttonSacar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sacar();
            }
        });

        buttonDepositar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                depositar();
            }
        });

        buttonMostrarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDados();
            }
        });
    }

    private void criarConta() {
        String cliente = editTextCliente.getText().toString();
        int numConta = Integer.parseInt(editTextNumConta.getText().toString());
        float saldo = Float.parseFloat(editTextSaldo.getText().toString());

        if (radioButtonPoupanca.isChecked()) {
            int diaRendimento = Integer.parseInt(editTextDiaRendimento.getText().toString());
            float taxaRendimento = Float.parseFloat(editTextTaxaRendimento.getText().toString());
            contaSelecionada = new ContaPoupanca(cliente, numConta, saldo, diaRendimento);
        } else if (radioButtonEspecial.isChecked()) {
            float limite = Float.parseFloat(editTextLimite.getText().toString());
            contaSelecionada = new ContaEspecial(cliente, numConta, saldo, limite);
        }
    }

    private void sacar() {
        if (contaSelecionada != null) {
            float valor = Float.parseFloat(editTextValorOperacao.getText().toString());
            contaSelecionada.sacar(valor);
        }
    }

    private void depositar() {
        if (contaSelecionada != null) {
            float valor = Float.parseFloat(editTextValorOperacao.getText().toString());
            contaSelecionada.depositar(valor);
        }
    }

    private void mostrarDados() {
        if (contaSelecionada != null) {
            contaSelecionada.mostrarDados();
        }
    }
}
