package dev.rahulagar.runnerz.run;

import dev.rahulagar.runnerz.run.enums.FileType;
import dev.rahulagar.runnerz.run.enums.MessageType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {
    private Long id;
    private String sender;
    private String content;
    private MessageType type;

    private String fileName;
    private String fileUrl;
    private long fileSize;
    private FileType fileType;
}
