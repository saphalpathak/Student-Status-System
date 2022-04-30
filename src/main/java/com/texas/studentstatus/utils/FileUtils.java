package com.texas.studentstatus.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@Component
public class FileUtils {

    public static String saveFile(MultipartFile multipartFile) throws IOException {
        String fileDir = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "Student Status System";

        File dir = new File(fileDir);

        if (!dir.exists()) {
            dir.mkdirs();
        } else {
            log.info("File already exists");
        }

        UUID uuid =UUID.randomUUID();

        String filePath = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "Student Status System"
                + uuid + multipartFile.getOriginalFilename();
        File savedFile = new File(filePath);
        multipartFile.transferTo(savedFile);
        return filePath;
    }

}
