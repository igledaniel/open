package com.mapzen.open.util;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public abstract class MixpanelHelper {
    public static class Event {
        public static final String INITIAL_LAUNCH = "initial-launch";
        public static final String PELIAS_SUGGEST = "pelias-suggest";
        public static final String PELIAS_SEARCH = "pelias-search";
        public static final String ROUTING_START = "routing-start";
        public static final String LOGIN_PAGE = "login-page-";
        public static final String LOGIN_BUTTON_CLICK = "login-button-click";
        public static final String ROUTING_PREVIEW_CAR = "routing-preview-car";
        public static final String ROUTING_PREVIEW_FOOT = "routing-preview-foot";
        public static final String ROUTING_PREVIEW_BIKE = "routing-preview-bike";
    }

    public static class Payload {
        public static final String LOGGED_IN_KEY = "logged_in";
        public static final String PELIAS_TERM = "pelias_term";
        public static JSONObject fromHashMap(HashMap<String, Object> hashMap) {
            JSONObject payload = new JSONObject();
            try {
                for (String key: hashMap.keySet()) {
                    payload.put(key, String.valueOf(hashMap.get(key)));
                }
            } catch (JSONException e) {
                Logger.e("Failed at creating json object");
            }
            return payload;
        }
    }
}
