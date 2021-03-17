package com.example.demo;

import javax.validation.Valid;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @Autowired
    private UniversidadesService UniversidadesService;

    @GetMapping("/status")
    public ResponseEntity<String> status() {
        return new ResponseEntity<>("{\"result\" : \"OK\"}", HttpStatus.OK);
    }

    @PostMapping(
            path="/login2",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> login2(
            @Valid @RequestBody LoginCredential loginParam,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>("{\"result\" : \"KO\"}", HttpStatus.BAD_REQUEST);
        }

        if ((loginParam.getUser().equals("demo@demo.com")) &&
                (loginParam.getPassword().equals("DEMO"))) {
            return new ResponseEntity<>("{\"result\" : \"OK\"}", HttpStatus.OK);
        }
        return new ResponseEntity<>("{\"result\" : \"KO\"}", HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/universidades")
    public JSONArray getUnis() {
        return UniversidadesService.getUnis();
    }

    @GetMapping("/universidades/{id}")
    public JSONArray getNotasCorteById(@PathVariable String id) {
        return UniversidadesService.getNotasCorteById(id);
    }

    @GetMapping("/info/{id}")
    public JSONObject getInfoUniById(@PathVariable String id) {
        return UniversidadesService.getInfoUniById(id);
    }

    @GetMapping("/search/{id}")
    public JSONArray searchUni(@PathVariable String id) {
        return UniversidadesService.searchUni(id);
    }

    @PostMapping(
            path="/contact",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> contact(
            @Valid @RequestBody Contact contact,
            BindingResult bindingResult) {


        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>("{\"result\" : \"KO\"}", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("{\"result\" : \"OK\"}", HttpStatus.OK);
    }
}
