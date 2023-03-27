package com.springsecurity.Controller;

import com.springsecurity.Service.FileUplodeDownlodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;

@RestController

public class BalanceController {

    @Autowired
    FileUplodeDownlodeService fileUplodeDownlodeService;
    @GetMapping("/getAccount")
    public  String getAccount(){
        return "Account in DataBase";
    }


//    @PostMapping("/uplode")
//    public ResponseEntity<Object> uplodeFile(@RequestParam("file")MultipartFile file) throws IOException {
//        ResponseEntity<Object> response;
//      String name =  fileUplodeDownlodeService.store(file);
//      if(name!=null){
//          response = ResponseEntity.status(HttpStatus.OK).body("File Uploded");
//      }
//      else{
//         response =   ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("UnAble to UplodeFile");
//      }
//
//
//        return response;
//    }

    @GetMapping("/getAllTransactions")
    public ResponseEntity<Object> getTrans(){
        ByteArrayInputStream pdf =  fileUplodeDownlodeService.printPDFFormateTransaction();

        HttpHeaders httpHeaders = new HttpHeaders();


      return   ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(pdf));
    }
}
