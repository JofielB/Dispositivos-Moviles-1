package com.example.eva2_9_dialogo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button botonDef;
    Button botonEdt;
    Dialog dialog;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         botonDef = findViewById(R.id.btnDefault);
         botonDef.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 new AlertDialog.Builder(MainActivity.this)
                         .setTitle("Estandar dialog box")
                         .setMessage("I am a dialog box")
                         .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(DialogInterface dialogInterface, int i) {
                                 //What is done when the event ok is actioned
                                 Toast.makeText(getApplicationContext(),"It´s ok",Toast.LENGTH_SHORT).show();
                             }
                         })
                         .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(DialogInterface dialogInterface, int i) {
                                 Toast.makeText(getApplicationContext(),"It´s not ok",Toast.LENGTH_SHORT).show();
                             }
                         })
                         .setNeutralButton("CANCEL", new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(DialogInterface dialogInterface, int i) {
                                 Toast.makeText(getApplicationContext(),"Action canceled",Toast.LENGTH_SHORT).show();
                             }
                         }).create().show();

             }
         });
         botonEdt = findViewById(R.id.btnEdit);
         botonEdt.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 dialog = new Dialog(MainActivity.this);
                 dialog.setContentView(R.layout.layout_dialog);
                 Button btnOk;
                 editText = dialog.findViewById(R.id.edTxt);
                 btnOk = dialog.findViewById(R.id.btnOk);
                 btnOk.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View view) {
                         String sCade = editText.getText().toString();
                         Toast.makeText(MainActivity.this,sCade,Toast.LENGTH_SHORT).show();
                         dialog.dismiss();
                     }
                 });
                 dialog.show();
             }
         });
    }
}
