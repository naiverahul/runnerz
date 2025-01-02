package dev.rahulagar.runnerz.run;

import dev.rahulagar.runnerz.run.enums.FileType;
import dev.rahulagar.runnerz.run.manage_files.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller // Updated to include `@Controller` for serving the HTML file
@RequestMapping("/chat")
public class ChatController {

    private final FileService fileService;

    // Inject FileService
    @Autowired
    public ChatController(FileService fileService) {
        this.fileService = fileService;
    }

    // Serve the chat.html page
    @GetMapping
    public String chatPage(Model model) {
        // Pass any required data to the model here if needed
        return "chat"; // The "chat" refers to `chat.html` in the templates directory
    }

    // Handle WebSocket messages
    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage message) {
        if (message.getFileName() != null && !message.getFileName().isEmpty() && message.getFileType() != null) {
            message.setFileUrl("/chat/download/" + message.getFileName()); // Generate a download URL
        }
        return message;
    }

    // Handle file uploads
    @PostMapping("/upload")
    @ResponseBody
    public ChatMessage uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("sender") String sender) {
        String fileUrl = fileService.uploadFile(file); // Use FileService to handle the file upload

        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setSender(sender);
        chatMessage.setFileName(file.getOriginalFilename());
        chatMessage.setFileUrl(fileUrl);
        chatMessage.setFileSize(file.getSize());
        chatMessage.setFileType(determineFileType(file.getContentType()));

        return chatMessage; // Return the chat message with file details
    }

    // Handle file downloads
    @GetMapping("/download/{fileName}")
    @ResponseBody
    public Resource downloadFile(@PathVariable String fileName) {
        return fileService.loadFileAsResource(fileName); // Use FileService to load the file
    }

    private FileType determineFileType(String contentType) {
        if (contentType == null) {
            return FileType.UNKNOWN;
        } else if (contentType.startsWith("image/")) {
            return FileType.IMAGE;
        } else if (contentType.startsWith("video/")) {
            return FileType.VIDEO;
        } else if (contentType.startsWith("audio/")) {
            return FileType.AUDIO;
        } else if (contentType.startsWith("application/")) {
            return FileType.DOCUMENT;
        } else {
            return FileType.UNKNOWN;
        }
    }
}
