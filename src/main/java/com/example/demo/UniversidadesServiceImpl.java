package com.example.demo;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

@Service
public class UniversidadesServiceImpl implements UniversidadesService {

    @Override
    public JSONArray getUnis() {
        JSONArray jsonObject = null;
        try {
            JSONParser parser = new JSONParser();

            Object obj = parser.parse(new FileReader("./src/universidades.json"));
            
            jsonObject = (JSONArray) obj;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

    @Override
    public JSONArray getNotasCorteById(String id) {
        JSONArray filtered = new JSONArray();
        JSONArray jsonObject = null;
        try {
            JSONParser parser = new JSONParser();

            Object obj = parser.parse(new FileReader("./src/notas_corte.json"));

            jsonObject = (JSONArray) obj;

            Iterator i = jsonObject.iterator();

            while (i.hasNext()) {
                JSONObject nota = (JSONObject) i.next();
                String uni = (String)nota.get("Universidad");
                if (uni.equals(id)) {
                    filtered.add(nota);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filtered;
    }

    @Override
    public JSONObject getInfoUniById(String id) {
        JSONObject filtered = new JSONObject();
        JSONArray jsonObject = null;
        try {
            JSONParser parser = new JSONParser();

            Object obj = parser.parse(new FileReader("./src/universidades.json"));

            jsonObject = (JSONArray) obj;

            Iterator i = jsonObject.iterator();

            while (i.hasNext()) {
                JSONObject nota = (JSONObject) i.next();
                String uni = (String)nota.get("name");
                if (uni.equals(id)) {
                    return nota;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filtered;
    }

    @Override
    public JSONArray searchUni(String id) {
        JSONArray filtered = new JSONArray();
        JSONArray jsonObject = null;
        try {
            JSONParser parser = new JSONParser();

            Object obj = parser.parse(new FileReader("./src/universidades.json"));

            jsonObject = (JSONArray) obj;

            Iterator i = jsonObject.iterator();

            while (i.hasNext()) {
                JSONObject uni = (JSONObject) i.next();
                String name = (String)uni.get("name");
                String busqueda = id.toLowerCase().strip();
                if (name.toLowerCase().strip().contains(id)) {
                    filtered.add(uni);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filtered;
    }
}
