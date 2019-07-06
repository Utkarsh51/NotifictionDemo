package com.example.android.cardviewcamera;

import android.app.NotificationManager;
import android.content.Intent;
import android.support.v4.app.RemoteInput;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    NotificationManager nm;
    TextView tv ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv = findViewById(R.id.hdf);
        Bundle b1 = RemoteInput.getResultsFromIntent(getIntent());
        if(b1 != null){
            tv.setText(b1.getString(MainActivity.myKey));
        }

        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        nm.cancel(MainActivity.notification_id);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        menu.add(0,1,0,"Item3");
        menu.add(0,2,0,"Item4");
        SubMenu sm = menu.addSubMenu("Sub menu");
        sm.add(0, 3, 0, "SubMenu1");
        sm.add(0, 4, 0, "SubMenu2");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.item1:
                Toast.makeText(this,item.getTitle(),Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Main2Activity.this,Main3Activity.class);
                startActivity(i);
                break;
            case R.id.item2:
                Toast.makeText(this,item.getTitle(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.item11:
                Toast.makeText(this,item.getTitle(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.item12:
                Toast.makeText(this,item.getTitle(),Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(this,item.getTitle(),Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this,item.getTitle(),Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this,item.getTitle(),Toast.LENGTH_SHORT).show();
                break;

        }
        return true;
    }
}
