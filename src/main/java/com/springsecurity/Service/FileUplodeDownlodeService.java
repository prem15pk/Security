package com.springsecurity.Service;


import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfWriter;
import com.springsecurity.Repository.FileUplodeDownlodeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileUplodeDownlodeService {

    FileUplodeDownlodeRepository uplodeDownlodeRepository;

    public ByteArrayInputStream printPDFFormateTransaction(){

        String title = "Bank Transactions";
        String contrnt = "Transactions List";
        Document document = new Document();


        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PdfWriter.getInstance(document,outputStream);
        document.open();



        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD,30, Color.BLUE);

        Paragraph paragraph = new Paragraph(title,fontTitle);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph);

        Font parafount = FontFactory.getFont(FontFactory.HELVETICA_BOLD,14);
        Paragraph elements = new Paragraph(contrnt,parafount);
        document.add(elements);
        document.close();
        return new ByteArrayInputStream(outputStream.toByteArray());

    }
}
