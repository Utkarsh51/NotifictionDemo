package com.example.android.cardviewcamera;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.support.v4.app.RemoteInput;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView iv1,iv2,iv3,iv4;
    Button b1,b2;
    static int i =1;
    NotificationManager nm;
    public static final String channal_ID = "My channel Id";
    public static final int notification_id = 22;
    public static final String myKey = "Remote Input";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv1  = findViewById(R.id.img1);
        iv2  = findViewById(R.id.img2);
        iv3  = findViewById(R.id.img3);
        iv4  = findViewById(R.id.img4);
        b1 = findViewById(R.id.b1);

        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

    }

    public void openCamera(View view) {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,200);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == 200){
            Bundle bundle = data.getExtras();
            Bitmap bitmap = (Bitmap) bundle.get("data");
            setBitmap(bitmap);
        }
    }

    private void setBitmap(Bitmap bitmap){
        switch (i){
            case 1:
                iv1.setImageBitmap(bitmap);
                i++;
                break;
            case 2:
                iv2.setImageBitmap(bitmap);
                i++;
                break;
            case 3:
                iv3.setImageBitmap(bitmap);
                i++;
                break;
            case 4:
                iv4.setImageBitmap(bitmap);
                i=1;
                break;
        }
    }

    public void showNotification(View view){
        //myNotificationChannel();

        Intent i = new Intent(MainActivity.this,Main2Activity.class);
        PendingIntent pi = PendingIntent.getActivity(this,1,i,PendingIntent.FLAG_CANCEL_CURRENT);

       Intent i1 = new Intent(MainActivity.this,MainActivity.class);
        PendingIntent pi1 = PendingIntent.getActivity(this,1,i1,PendingIntent.FLAG_CANCEL_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,channal_ID);

        builder.setSmallIcon(R.drawable.ic_airline_seat_flat_black_24dp);
        builder.setContentTitle("My Notification");
        builder.setContentText("This is my Notification");

        builder.setContentIntent(pi);

        //builder.addAction(R.drawable.check,"Ok..",pi);
       // builder.addAction(R.drawable.cancel,"Cancel",pi1);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            RemoteInput ri = new RemoteInput.Builder(myKey).setLabel("Replying..").build();

            NotificationCompat.Action action = new NotificationCompat.Action.Builder(R.drawable.check,"Reply..",pi).addRemoteInput(ri).build();
            builder.addAction(action);
        }
        builder.setAutoCancel(true);


        nm.notify(notification_id,builder.build());
    }

   /* public void myNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String name = "My channel Name";
            String desc = "My notification channel";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel = new NotificationChannel(channal_ID, name, importance);
            notificationChannel.setDescription(desc);
            nm.createNotificationChannel(notificationChannel);

        }
    }*/


}
