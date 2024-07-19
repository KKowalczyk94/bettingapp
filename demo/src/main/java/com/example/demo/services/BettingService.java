package com.example.demo.services;

import com.example.demo.Entities.api.Event;
import com.example.demo.Entities.api.Sport;
import com.example.demo.Entities.dtos.EventDTO;
import com.example.demo.Entities.dtos.SportDTO;
import com.example.demo.converter.EntityToDTOConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.BufferedSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.type.TypeReference;


import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<SportDTO> getSports() throws Exception {
        String url = baseUrl + "/sports";
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", apiKey);
        headers.set("x-rapidapi-host", apiHost);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new IOException("Unexpected code " + response.getStatusCode());
        }

        String responseBody = response.getBody();
        List<Sport> sports = objectMapper.readValue(responseBody, new TypeReference<List<Sport>>() {});
        return sports.stream().map(EntityToDTOConverter::toSportDTO).collect(Collectors.toList());
    }


    public List<EventDTO> getOdds(String sport) throws Exception {
        String url = baseUrl + "/sports/" + sport + "/odds?regions=us&oddsFormat=decimal&markets=h2h&dateFormat=iso";
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", apiKey);
        headers.set("x-rapidapi-host", apiHost);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new IOException("Unexpected code " + response.getStatusCode());
        }

        String responseBody = response.getBody();
        List<Event> events = objectMapper.readValue(responseBody, new TypeReference<List<Event>>() {});
        return events.stream().map(EntityToDTOConverter::toEventDTO).collect(Collectors.toList());
    }

    public List<Event> getScores(String sport) throws Exception {
        String url = baseUrl + "/sports/" + sport + "/scores?daysFrom=3";
        String response = restTemplate.getForObject(url, String.class);
        return objectMapper.readValue(response, new TypeReference<List<Event>>() {});
    }
}
