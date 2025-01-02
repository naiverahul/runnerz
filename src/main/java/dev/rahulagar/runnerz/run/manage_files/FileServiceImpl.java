package dev.rahulagar.runnerz.run.manage_files;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
public class FileServiceImpl implements FileService {

    private final Path uploadDir = Path.of("uploads");

    public FileServiceImpl() {
        try {
            Files.createDirectories(uploadDir);
        } catch (Exception e) {
            throw new RuntimeException("Could not initialize upload directory", e);
        }
    }

    @Override
    public String uploadFile(MultipartFile file) {
        try {
            Path targetPath = uploadDir.resolve(Objects.requireNonNull(file.getOriginalFilename()));
            Files.copy(file.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);
            return targetPath.toString();
        } catch (Exception e) {
            throw new RuntimeException("File upload failed", e);
        }
    }

    @Override
    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = uploadDir.resolve(fileName).normalize();
            return new org.springframework.core.io.UrlResource(filePath.toUri());
        } catch (Exception e) {
            throw new RuntimeException("File not found: " + fileName, e);
        }
    }
}
