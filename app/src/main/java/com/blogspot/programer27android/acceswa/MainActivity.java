package com.blogspot.programer27android.acceswa;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button group,personal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        group=findViewById(R.id.group);
        personal=findViewById(R.id.personal);
        personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWhatsapp();
            }
        });
        group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGroupWA();
            }
        });

    }

    private void openWhatsapp(){
        String number = "6282378584408"; //without "+"
        try{
            Intent sendWA = new Intent("android.intent.action.MAIN");
            sendWA.setAction(Intent.ACTION_SEND);
            sendWA.setType("text/palain");
            sendWA.putExtra(Intent.EXTRA_TEXT, "my message");
            sendWA.putExtra("jid",number+"@s.whatsapp.net");
            sendWA.setPackage("com.whatsapp");
            startActivity(sendWA);
        }
        catch (Exception e){
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }
    private void openGroupWA(){
        Uri uri=Uri.parse("https:chat.whatsapp.com/");
        Intent WA =new Intent(Intent.ACTION_VIEW,uri);
        WA.setPackage("com.whatsapp");
        try{
            startActivity(WA);
        }catch (ActivityNotFoundException e){
            startActivity(new Intent(Intent.ACTION_VIEW,uri));
        }
    }
}
