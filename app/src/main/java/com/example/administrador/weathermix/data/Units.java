package com.example.administrador.weathermix.data;

import org.json.JSONObject;

/**
 * Created by Administrador on 11/10/2016.
 */
public class Units implements JSONPopulator {
    private String temperature;

    public String getTemperature() {
        return temperature;
    }

    @Override
    public void populate(JSONObject data) {
        temperature = data.optString("temperature");
    }
}
