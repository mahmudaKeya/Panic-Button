package com.example.betatest_1.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.betatest_1.view.NotificationActivity;
import com.example.betatest_1.R;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private Button logout;
    private Button btnNotification;


    private static final String CHANNEL_ID = "Panic Button";
    private static final String CHANNEL_NAME = "Panic Button";
    private static final String CHANNEL_DESC = "Panic Button Notification";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logout = findViewById(R.id.logout);
        btnNotification = findViewById(R.id.btn_notify);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(MainActivity.this, "Logged Out!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, StartActivity.class));
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ){

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(CHANNEL_DESC);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);

        }


//        btnNotification.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String message = "Help!";
//                NotificationCompat.Builder builder = new NotificationCompat.Builder(
//
//                        MainActivity.this
//                )
//                        .setSmallIcon(R.drawable.ic_message)
//                        .setContentTitle("New Notification")
//                        .setContentText(message)
//                        .setAutoCancel(true);
//
//                Intent intent = new Intent(MainActivity.this,
//                        NotificationActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                intent.putExtra("message", message);
//
//                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,
//                        0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//
//                builder.setContentIntent(pendingIntent);
//
//                NotificationManager notificationManager = (NotificationManager)getSystemService(
//
//                        Context.NOTIFICATION_SERVICE
//                );
//                notificationManager.notify(0, builder.build());
//
//            }
//        });
            btnNotification.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    displayNotification();
                }
            });

    }

    private void displayNotification(){

        Intent intent = new Intent(MainActivity.this, NotificationActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(
                MainActivity.this,
                100,
                intent,
                PendingIntent.FLAG_CANCEL_CURRENT
        );




        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle("New Notification")
                .setContentText("Help")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH);


        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(1, mBuilder.build());



//        Intent intent = new Intent(MainActivity.this,
//                NotificationActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
//        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,
//                       0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//
//                mBuilder.setContentIntent(pendingIntent);



    }
}