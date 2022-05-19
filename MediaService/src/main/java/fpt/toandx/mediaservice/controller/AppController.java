package fpt.toandx.mediaservice.controller;

import fpt.toandx.mediaservice.util.FileUploadUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/media")
public class AppController {
    @GetMapping("/hello")
    public String hello()
    {
        return "Hello world";
    }

    @PostMapping("/save")
    public String saveFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        String uploadDir = "file/";

        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

        return "File uploaded!";
    }
}
