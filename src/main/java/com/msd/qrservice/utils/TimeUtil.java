package com.msd.qrservice.utils;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {

    public static Timestamp generateTimestamp(int nofDays) {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timestamp.getTime());
        cal.setTimeInMillis(timestamp.getTime());
        cal.add(Calendar.DAY_OF_MONTH, nofDays);
        timestamp = new Timestamp(cal.getTime().getTime());
        return timestamp;
    }

}
