package com.todoo.app.entity;

import java.sql.Date;

import lombok.Data;

@Data
public class Todo {

    private long id;
    private String title;
    private int done_flg;
    private Date time_limit;
    
    
    //index1
    private int progress;
    
 
}
