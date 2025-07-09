package com.nuevo.spa.gestortareas.util.helper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimestampHelper {
    public static String getNowDate() {
        return LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                .replace(' ', 'T');
    }
}
