package com.gendigital.tiendamascotas;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by Fernado De la Rocha on 09/07/2016.
 */
public class SendMail extends AsyncTask<Void, Void, Void> {

    public static final String EMAIL = "fernando.delarocha88@gmail.com";
    public static final String PASSWORD = "Fernando01";

    private Context context;
    private Session session;

    private String email;
    private String message;

    private ProgressDialog pd;

    public SendMail(Context context, String email, String message){

        this.context = context;
        this.email = email;
        this.message = message;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd = ProgressDialog.show(context,"Enviando email", "espera...",false,false);
    }

    @Override
    protected Void doInBackground(Void... params) {
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.port", "465");

        session = Session.getDefaultInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL,PASSWORD);
            }
        });

        try {
            MimeMessage miMensaje = new MimeMessage(session);
            miMensaje.setFrom(new InternetAddress(EMAIL));
            miMensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            miMensaje.setSubject("Test");
            miMensaje.setText(message);
            Transport.send(miMensaje);

        }catch (MessagingException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        pd.dismiss();
        Toast.makeText(context, "Correo Enviado", Toast.LENGTH_SHORT).show();
    }
}