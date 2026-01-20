package com.example.Chatbot.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private PythonAgentService aiService;

    @PostMapping
    public ChatResponse chat(@RequestBody ChatRequest request) {
        String reply = aiService.callAgent(request.getMessage());
        return new ChatResponse(reply);
    }

    @GetMapping("/test")
    public String test() {
        return "Test endpoint works!";
    }
}
