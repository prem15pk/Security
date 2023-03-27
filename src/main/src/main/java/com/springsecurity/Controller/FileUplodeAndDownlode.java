package com.springsecurity.Controller;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
public class FileUplodeAndDownlode {

    @PostMapping(value = "/uplode",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uplodeFile(@RequestParam ("/file")MultipartFile multipartFile) throws IOException {

        File file = new File("C:\\Users\\dell\\Pictures\\Camera Roll"
                +multipartFile.getName());
        if(!file.exists()){
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(multipartFile.getBytes());
        fileOutputStream.close();
        return"File Uploded";
    }

    @GetMapping("/downlode")
    public ResponseEntity<Object> downlode(@RequestParam("fileName") String fileName) throws FileNotFoundException {
        File file = new File("C:\\Users\\dell\\Pictures\\Camera Roll"+fileName);

        InputStreamResource inputStreamResource = new InputStreamResource(new FileInputStream(file));

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Discription",
                "attachment; fileName=downlode-"+fileName);
        return ResponseEntity.ok().headers(httpHeaders).body(inputStreamResource);
    }
}
