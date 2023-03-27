package com.springsecurity.Entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "fileUplodeDownlode")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class FileUpDownlode {
    @Id
    @GeneratedValue
    private int id;

    private String fileName;

    private String fileType;
    @Lob
    private byte[] data;
}
