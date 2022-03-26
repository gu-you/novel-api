package com.example.novel;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class BaseEntity {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date startTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endTime;

}
