package com.example.administrador.weathermix.data;

import org.json.JSONObject;

/**
 * Created by Administrador on 11/10/2016.
 */
public class Item implements JSONPopulator {
    private Condition condition;

    public Condition getCondition() {
        return condition;
    }

    @Override
    public void populate(JSONObject data) {
        condition = new Condition();
        condition. populate(data.optJSONObject("condition"));
    }
}
