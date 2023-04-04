package com.provedcode.test.controller;

import com.provedcode.test.service.S3Service;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/")
public class S3Controller {
    S3Service s3Service;

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        return s3Service.saveFile(file);
    }

    @GetMapping("/download/{filename}")
    public byte[] download(@PathVariable String filename) {
        return s3Service.downloadFile(filename);
    }

    @DeleteMapping("/delete/{filename}")
    public String delete(@PathVariable String filename) {
        return s3Service.deleteFile(filename);
    }

    @GetMapping("/")
    public List<String> getAllFiles() {
        return s3Service.listAllFiles();
    }

}
