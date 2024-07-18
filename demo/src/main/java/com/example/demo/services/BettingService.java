package com.example.demo.services;

import com.example.demo.Entities.api.Event;
import com.example.demo.Entities.api.Sport;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BettingService {

    @Value("${api.rapidapi.key}")
    private String apiKey;

    @Value("${api.rapidapi.host}")
    private String apiHost;

    @Value("${api.rapidapi.base-url}")
    private String baseUrl;

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final OkHttpClient client;
    private final RestTemplate restTemplate;

    public List<Sport> getSports() throws Exception {
//        String url = baseUrl + "/sports?all=true";
//        String response = restTemplate.getForObject(url, String.class);
//        return objectMapper.readValue(response, new TypeReference<List<Sport>>() {});
        Request request = new Request.Builder()
                .url("https://odds.p.rapidapi.com/v4/sports?all=true")
                .get()
                .addHeader("x-rapidapi-key", apiKey)
                .addHeader("x-rapidapi-host", apiHost)
                .build();
        try(Response response = client.newCall(request).execute()){
            if (!response.isSuccessful()){
                throw new IOException("Unexpected code " + response);
            }
            return objectMapper.readValue(response.body().string(), new TypeReference<List<Sport>>() {});
        }
    }

    public List<Event> getOdds(String sport) throws Exception {
        String url = baseUrl + "/sports/" + sport + "/odds?regions=us&oddsFormat=decimal&markets=h2h&dateFormat=iso";
        String response = restTemplate.getForObject(url, String.class);
        return objectMapper.readValue(response, new TypeReference<List<Event>>() {});
    }

    public List<Event> getScores(String sport) throws Exception {
        String url = baseUrl + "/sports/" + sport + "/scores?daysFrom=3";
        String response = restTemplate.getForObject(url, String.class);
        return objectMapper.readValue(response, new TypeReference<List<Event>>() {});
    }
}
