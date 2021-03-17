package com.example.demo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public interface UniversidadesService {
    JSONArray getUnis();

    JSONArray getNotasCorteById(String id);

    JSONObject getInfoUniById(String id);

    JSONArray searchUni(String id);
}
