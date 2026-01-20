package com.example.Chatbot.backend;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import java.util.HashMap;
import java.util.Map;

@Service
public class PythonAgentService {

    private final RestTemplate restTemplate = new RestTemplate();

    public String callAgent(String message) {

        String url = "http://localhost:8000/chat";

        Map<String, String> request = new HashMap<>();
        request.put("message", message);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(request, headers);

        ResponseEntity<Map> response =
                restTemplate.postForEntity(url, entity, Map.class);

        Map responseBody = response.getBody();
        return responseBody.get("reply").toString();
    }
}
