package net.ramonsilva.roomdemo.data.converters;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

public class DateConverter {

    @TypeConverter
    public static Date toDate(long date){
        return new Date(date);
    }

    @TypeConverter
    public static long fromDate(Date date){
        return date.getTime();
    }

}
