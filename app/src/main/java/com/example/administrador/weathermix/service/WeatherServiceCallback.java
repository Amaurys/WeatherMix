package com.example.administrador.weathermix.service;

import com.example.administrador.weathermix.data.Channel;

/**
 * Created by Administrador on 11/10/2016.
 */
public interface WeatherServiceCallback {
    void serviceSuccess(Channel channel);
    void serviceFailure(Exception ex);
}

