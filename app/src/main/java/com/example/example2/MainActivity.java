package com.example.example2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Context myContext;
    Toast myToast;
    Intent myIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myContext = getApplicationContext();
        myToast = new Toast(myContext);
        myToast. makeText(myContext, "i am toast", Toast.LENGTH_LONG).show();

        AlertDialog.Builder dialogConf = new AlertDialog.Builder(this);

        dialogConf.setTitle("This is title");
        dialogConf.setMessage("this is the text");
        dialogConf.setIcon(R.mipmap.ic_launcher);

        dialogConf.setNeutralButton("dismiss",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        myToast.makeText(myContext, "You clicked dismiss", Toast.LENGTH_LONG).show();
                    }
                });

        dialogConf.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        myToast.makeText(myContext, "You clicked No", Toast.LENGTH_LONG).show();
                    }
                });

        dialogConf.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        myToast.makeText(myContext, "You clicked Yes", Toast.LENGTH_LONG).show();
                    }
                });

        AlertDialog myDialog = dialogConf.create();
        myDialog.show();

        Notification.Builder notifConf = new Notification.Builder(this);
        notifConf.setContentTitle("This is notification");
        notifConf.setContentText("this is detail");
        notifConf.setSmallIcon(R.mipmap.ic_launcher);

        NotificationManager myNotification = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        myNotification.notify(12345676, notifConf.build());

        //Intent myIntent = new Intent(this, MainActivity.class);
        //PendingIntent
    }
}
