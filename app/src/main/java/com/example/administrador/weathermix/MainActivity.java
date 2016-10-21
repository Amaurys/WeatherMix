package com.example.administrador.weathermix;

import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrador.weathermix.data.Channel;
import com.example.administrador.weathermix.data.Item;
import com.example.administrador.weathermix.service.WeatherServiceCallback;
import com.example.administrador.weathermix.service.YahooWeatherService;

public class MainActivity extends AppCompatActivity implements WeatherServiceCallback {

    private ImageView weatherIconImageViewer;
    private TextView temperaturaTextView;
    private TextView conditionTextView;
    private TextView locationTextView;

    private YahooWeatherService service;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weatherIconImageViewer = (ImageView) findViewById(R.id.weatherIcon);
        temperaturaTextView = (TextView) findViewById(R.id.temperatureTextView);
        conditionTextView = (TextView) findViewById(R.id.conditionTextView);
        locationTextView = (TextView) findViewById(R.id.locationTextView);

        service = new YahooWeatherService(this);
        service.refreshWeather("santo domingo, dominican republic");

        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading... ");
        dialog.show();
    }

    @Override
    public void serviceSuccess(Channel channel) {

        dialog.hide();

        Item item = channel.getItem();
        int resourceId = getResources().getIdentifier("drawable/icon_"+item.getCondition().getCode(),null,getPackageName());

        Drawable weatherIconDrawable = getResources().getDrawable(resourceId);

        weatherIconImageViewer.setImageDrawable(weatherIconDrawable);

        temperaturaTextView.setText(item.getCondition().getTemperature() + "\u00B0" + channel.getUnits().getTemperature());
        conditionTextView.setText(item.getCondition().getDescription());
        locationTextView.setText(service.getLocation());
    }

    @Override
    public void serviceFailure(Exception ex) {
        dialog.hide();
        Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();
    }
}
