package com.eportal.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class PDFDataTest {
    private Integer column1;
    private String column2;
    private String column3;
    private String column4;
    private String column5;
}
