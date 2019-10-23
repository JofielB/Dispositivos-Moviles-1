package com.example.eva2_8_activity_result_lista;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Uri uriContact;
    private String contactID;
    private String phoneNumber;

    Intent intentoClima;
    Intent intentoRestaurante;

    Button botonClima;
    Button botonRestaurante;
    Button botonContacts;
    Button botonCall;

    TextView text;
    TextView phoneText;
    final int WEATHER = 4200;
    final int RESTAURANTS = 6900;
    final int CONTACTS = 8000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.txtTest);
        phoneText = findViewById(R.id.txtPhoneNumber);
        intentoClima = new Intent(this,ClimaActivity.class);
        botonClima = findViewById(R.id.btnClima);
        botonClima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //AQUI SE ABRE LA ACTIVIDAD DE CLIMA DE ESTA MISMA APP
                startActivityForResult(intentoClima,WEATHER);

                //DE ESTA MANERA SE ABRE LA APLICACION DEL CLIMA Y SE UTILIZA LO QUE ESTA TIENE
//                ComponentName cn = new ComponentName("com.example.eva1_10_lista_clima",
//                        "com.example.eva1_10_lista_clima.MainActivity");
//                Intent in = new Intent(Intent.ACTION_MAIN);
//                in.setComponent(cn);
//                startActivityForResult(in,WEATHER);
            }
        });

        intentoRestaurante = new Intent(this,RestauranteActivity.class);
        botonRestaurante = findViewById(R.id.btnRestaurante);
        botonRestaurante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(intentoRestaurante,RESTAURANTS);
            }
        });

        botonContacts = findViewById(R.id.btnCont);
        botonContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Intent.ACTION_PICK,
                        ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(in,CONTACTS);
            }
        });

        botonCall = findViewById(R.id.btnCall);
        botonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numero = "tel:"+ phoneText.getText().toString();
                //URI: uniform resource identificator
                Intent marcar = new Intent(Intent.ACTION_DIAL,Uri.parse(numero));
                startActivity(marcar);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case WEATHER:
                if(resultCode == Activity.RESULT_OK){ //resultCode es la seleccion que da el usuario
                    //Aqui recibimos datos
                    text.setText("You chose the city: "+data.getStringExtra("MENSAJE"));
                }else {
                    Toast.makeText(this, "ACCION CANSELADA", Toast.LENGTH_SHORT).show();
                }
                break;
            case RESTAURANTS:
                if(resultCode == Activity.RESULT_OK){
                    //Aqui recibimos datos
                    text.setText("You chose the restaurant: "+data.getStringExtra("MENSAJE"));
                }else {
                    Toast.makeText(this, "ACCION CANSELADA", Toast.LENGTH_SHORT).show();
                }
                break;
            case CONTACTS:
                if(resultCode == Activity.RESULT_OK){
                    //SE ADQUIERE EL ID DEL CONTACTO
                    String datos = data.getDataString();
//                    Toast.makeText(this,datos,Toast.LENGTH_SHORT).show();

                    //AQUI SE MANDA A LA INFO DEL CONTACTO
//                    Intent intento = new Intent(Intent.ACTION_VIEW,
//                            Uri.parse(datos));
//                    startActivity(intento);

                    //OBTENER EL NUMERO
                    uriContact = data.getData();
                    phoneNumber = retrieveContactNumber();
                    phoneText.setText(phoneNumber);
                }else {
                    Toast.makeText(this, "ACCION CANSELADA", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }
    private String retrieveContactNumber() {

        String contactNumber = null;

        // getting contacts ID
        Cursor cursorID = getContentResolver().query(uriContact,
                new String[]{ContactsContract.Contacts._ID},
                null, null, null);

        if (cursorID.moveToFirst()) {

            contactID = cursorID.getString(cursorID.getColumnIndex(ContactsContract.Contacts._ID));
        }

        cursorID.close();

        // Using the contact ID now we will get contact phone number
        Cursor cursorPhone = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER},

                ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ? AND " +
                        ContactsContract.CommonDataKinds.Phone.TYPE + " = " +
                        ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE,

                new String[]{contactID},
                null);

        if (cursorPhone.moveToFirst()) {
            contactNumber = cursorPhone.getString(cursorPhone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
        }

        cursorPhone.close();
        return contactNumber;
    }

}
