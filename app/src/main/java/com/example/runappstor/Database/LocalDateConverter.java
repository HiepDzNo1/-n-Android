package com.example.runappstor.Database;

import androidx.room.TypeConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class LocalDateConverter {


        private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        @TypeConverter
        public static LocalDate toLocalDate(String value) {
            return value == null ? null : LocalDate.parse(value, formatter);
        }

        @TypeConverter
        public static String fromLocalDate(LocalDate localDate) {
            return localDate == null ? null : localDate.format(formatter);
        }

        public static LocalDate convertDateToLocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault(); // Hoặc bạn có thể chọn ZoneId cụ thể
            return instant.atZone(zoneId).toLocalDate();
    }
}