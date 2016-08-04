package com.gendigital.tiendamascotas;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import javax.mail.internet.AddressException;

/**
 * Created by Fernado De la Rocha on 07/07/2016.
 */
public class EmailSender extends AsyncTask<String,Void,Boolean> {

    private ProgressDialog pd;
    private Context context;
    @Override
    protected Boolean doInBackground(String... data) {
        String emailSenderAddress = (String)data[0];
        String emailSenderPassword = (String)data[1];
        String recipients = (String)data[2];
        String subject = (String)data[3];
        String comments = (String)data[4];
        //String pictureFileName=(String)data[5];

        Email m = new Email(emailSenderAddress, emailSenderPassword);

        m.set_to(recipients);
        m.set_from(emailSenderAddress);
        m.set_subject(subject);
        m.set_body(comments);

        try {
            ///m.addAttachment("/sdcard/filelocation");
            //m.setPictureFileName(pictureFileName);
            return m.send();
        } catch (Exception e) {
            //Toast.makeText(MainActivity.this, "There was a problem sending the email." + e.getMessage(), Toast.LENGTH_LONG).show();
            //throw  new Exception("Error sending ")
            throw new RuntimeException("Bang");
            //throw new RuntimeException(e);

            //return null;
        }
    }

    @Override
    protected void onPreExecute() {
        pd = ProgressDialog.show(context,"Enviando email...","espera un momento...",false,false);
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        pd.dismiss();
        Toast.makeText(context,"Email enviado",Toast.LENGTH_SHORT).show();
        super.onPostExecute(aBoolean);
    }
}
