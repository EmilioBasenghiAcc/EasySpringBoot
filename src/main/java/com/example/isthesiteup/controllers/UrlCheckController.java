package com.example.isthesiteup.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UrlCheckController {

    @GetMapping("/greetme")
    public String getMethodName() {
        return "Hello buddy!";
    }


    private final String SITE_IS_UP = "Site is up!";
    private final String SITE_IS_DOWN = "Site is down!";
    private final String INCORRECT_URL = "Incorrect URL!";

    @GetMapping("/check")    
    public String getUrlStatusMEssage(@RequestParam String url){
        String returnMessage = "";

        try {
            URL urlObj = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCodeCategory = conn.getResponseCode() / 100;
            System.out.println("responseCodeCategory: "+responseCodeCategory);
            if (responseCodeCategory == 2){
                System.out.print("DEBUG UP!");
                returnMessage = SITE_IS_UP+": "+conn.getResponseCode();
            } else if (responseCodeCategory == 3){
                returnMessage = SITE_IS_UP+": "+conn.getResponseCode();
            } else {
                returnMessage = SITE_IS_DOWN+": "+conn.getResponseCode();
            }
        } catch (MalformedURLException e) {
            returnMessage = INCORRECT_URL;
        } catch (IOException e) {
            returnMessage = SITE_IS_DOWN;
        }
        return returnMessage;
    }
    
}
