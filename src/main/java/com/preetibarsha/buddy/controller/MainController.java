package com.preetibarsha.buddy.controller;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/buddy")
@CrossOrigin(origins = "*")
public class MainController {

    private final ChatClient chatClient;

    public MainController(ChatClient.Builder builder) {
        this.chatClient = builder.defaultSystem("You are a Socratic DSA Tutor. Never provide the full code solution. " +
                "Instead, look at the problem and give a small, helpful hint that " +
                "leads the student to the answer." +
                "RULE 1: Never provide code solutions." +
                "RULE 2: Ask one guiding question at the end.").build();
    }

    @PostMapping("/hint")
    @RateLimiter(name = "buddyLimiter", fallbackMethod = "rateLimitFallback")
    public String getHint(@RequestBody String problemStatement) {
        return chatClient.prompt().user(problemStatement).call().content();
    }

    public String rateLimitFallback(String problemDescription, Throwable t) {
        return "Slow down, scholar! Buddy needs a minute to think. Please try again in a moment.";
    }

}
