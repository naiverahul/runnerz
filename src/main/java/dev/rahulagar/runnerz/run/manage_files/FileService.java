package dev.rahulagar.runnerz.run.manage_files;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    String uploadFile(MultipartFile file);
    public Resource loadFileAsResource(String fileName);

}
