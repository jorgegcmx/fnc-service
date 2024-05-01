package com.core.service.utils;

import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;


@Service
public class DateNow {
    public Date FechaActual(){
        return  Date.valueOf(LocalDate.now());
    }
}
