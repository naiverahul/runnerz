package dev.rahulagar.runnerz.run;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {

    @MessageMapping("/sendMessage") // Maps to /app/sendMessage
    @SendTo("/topic/messages")      // Sends to /topic/messages
    public ChatMessage sendMessage(ChatMessage message) {
        return message;
    }

    @GetMapping
    public String chat() {
        return "chat";
    }
}
