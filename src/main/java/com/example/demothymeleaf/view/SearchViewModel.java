package com.example.demothymeleaf.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchViewModel {

    private String query = "";
    private String name = " ";
    private int id;
    private Date date;



}
