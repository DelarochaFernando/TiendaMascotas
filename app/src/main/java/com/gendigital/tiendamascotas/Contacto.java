package com.gendigital.tiendamascotas;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;

import com.gendigital.petstore.R;

import javax.mail.Session;

public class Contacto extends AppCompatActivity {

    private TextInputEditText tvNombreContacto;
    private TextInputEditText tvEmailContacto;
    private TextInputEditText tvMensajeContacto;
    private Button btnEnviarMensajeContacto;

    private Context context;
    private Session session;

    private ProgressDialog pd;
    public String nomCont;
    public String emailCont;
    public String mensCont;

    public Contacto(){

    }
    public Contacto(String nomCont, String emailCont, String mensCont){
        this.nomCont = nomCont;
        this.emailCont = emailCont;
        this.mensCont = mensCont;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        tvNombreContacto = (TextInputEditText)findViewById(R.id.tvNombreContacto);
        tvEmailContacto = (TextInputEditText)findViewById(R.id.tvEmailContacto);
        tvMensajeContacto = (TextInputEditText)findViewById(R.id.tvMensajeContacto);
        btnEnviarMensajeContacto = (Button)findViewById(R.id.btnEnviarMensajeContacto);



    }

    public void enviarInformacion(View v){

        nomCont = tvNombreContacto.getText().toString().trim();
        emailCont = tvEmailContacto.getText().toString().trim();
        mensCont = tvMensajeContacto.getText().toString().trim();
        if (!nomCont.equals("") && !emailCont.equals("") && !mensCont.equals("")){
            SendMail sm = new SendMail(this,emailCont,mensCont);
            sm.execute();
            Toast.makeText(this, "Your mail has been sent", Toast.LENGTH_SHORT).show();
            //Intent intent = new Intent(MailActivity.this, MainActivity.class);
            //startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "One or more Fields are empty, check please !", Toast.LENGTH_SHORT).show();
        }

    }

}
