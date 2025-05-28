package vn.cloud.llm_mcp_client_demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChatController {

    private final AiService aiService;

    public ChatController(AiService aiService) {
        this.aiService = aiService;
    }

    @GetMapping("/")
    public String index() {
        return "chat";
    }

    @PostMapping("/chat/message")
    public String sendMessage(@RequestParam("message") String message, Model model) {
        String response = aiService.complete(message);
        model.addAttribute("userMessage", message);
        model.addAttribute("aiResponse", response);
        return "chat-message :: messageFragment";
    }
}