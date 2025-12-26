package com.college.college.dto;

import lombok.Data;

@Data
public class CreateStudent {
    private String name;
    private String[] subjects;
    private Integer fees;
}
