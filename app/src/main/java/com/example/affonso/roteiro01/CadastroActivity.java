package com.example.affonso.roteiro01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {

    private EditText mNome;
    private EditText mSobrenome;
    private EditText mUsuario;
    private EditText mSenha;
    private EditText mConfSenha;
    private Button mBotao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        mNome = (EditText)findViewById(R.id.nome);
        mSobrenome = (EditText)findViewById(R.id.sobrenome);
        mUsuario = (EditText)findViewById(R.id.usuario);
        mSenha = (EditText)findViewById(R.id.senha);
        mConfSenha = (EditText)findViewById(R.id.confSenha);
        mBotao = (Button)findViewById(R.id.botao);

        mBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logar();
            }
        });
    }
    private void logar() {
        String nome = mNome.getText().toString();
        String sobrenome = mSobrenome.getText().toString();
        String usuario = mUsuario.getText().toString();
        String senha = mSenha.getText().toString();
        String confmSenha = mConfSenha.getText().toString();

        if (usuario.equalsIgnoreCase("AffonsoCesar") && senha.equalsIgnoreCase ("123") && confmSenha.equalsIgnoreCase("123")) {
            Intent i = new Intent(this, MainActivity.class);
            Bundle b = new Bundle();
            b.putString("Usuario",usuario);
            i.putExtras(b);
            startActivity(i);
            finish();
        }
        else {
            View focus = null;
            if (TextUtils.isEmpty(nome)) {
                mNome.setError("Campo Vazio");
                focus = mNome;
                focus.requestFocus();
            }
            if (TextUtils.isEmpty(sobrenome)) {
                mSobrenome.setError("CampoVazio");
                focus = mSobrenome;
                focus.requestFocus();
            }
            if (TextUtils.isEmpty(usuario)) {
                mUsuario.setError("Campo Vazio");
                focus = mUsuario;
                focus.requestFocus();
            }
            if (TextUtils.isEmpty(senha)) {
                mSenha.setError("Campo Vazio");
                focus = mSenha;
                focus.requestFocus();
            }
            if (TextUtils.isEmpty(confmSenha)) {
                mConfSenha.setError("Campo Vazio");
                focus = mConfSenha;
                focus.requestFocus();
            }
            else {
                if (senha.equals("123")!= confmSenha.equals("123")) {
                    mSenha.setError("Senhas Cadastradas Não São Iguais!");
                    focus = mSenha;
                    focus.requestFocus();
                    mConfSenha.setError("Senhas Cadastradas Não São Iguais!");
                    focus = mConfSenha;
                    focus.requestFocus();
                }
                else {
                    mUsuario.setError("Usuário ou Senha Inválidos!");
                    focus = mUsuario;
                    focus.requestFocus();
                }

            }
        }

    }
}
