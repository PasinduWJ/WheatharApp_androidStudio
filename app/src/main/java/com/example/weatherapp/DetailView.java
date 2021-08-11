package com.example.weatherapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DetailView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);

        TextView txtdate=(TextView)findViewById(R.id.date);
        TextView txtcity=(TextView)findViewById(R.id.city);
        ImageView imageView=(ImageView)findViewById(R.id.icon);
        TextView txtTemp=(TextView)findViewById(R.id.temp);
        TextView txtDesc=(TextView)findViewById(R.id.description);
        TextView txtHumidity=(TextView)findViewById(R.id.humidity);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String date = extras.getString("date");
            String city = extras.getString("city");
            Integer icon = extras.getInt("icon");
            String temp = extras.getString("temp");
            String desc = extras.getString("desc");
            String humidity = extras.getString("humidity");

            txtdate.setText(date);
            txtcity.setText(city);
            imageView.setImageResource(icon);
            txtTemp.setText(temp);
            txtDesc.setText(desc);
            txtHumidity.setText("Humidity : "+humidity);
        }
    }
    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.alert_message);
        builder.setTitle(R.string.alert_title);
        builder.setPositiveButton(R.string.btn_yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        builder.setNegativeButton(R.string.btn_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}