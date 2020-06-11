package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public final class DateUtil {

    private static ReentrantLock lock = new ReentrantLock();

    private static Map<String, ThreadLocal<SimpleDateFormat>> sdfMap = new HashMap<String, ThreadLocal<SimpleDateFormat>>();

    private static SimpleDateFormat getSdf(final String pattern) {
        ThreadLocal<SimpleDateFormat> formatThreadLocal = sdfMap.get(pattern);

        if (formatThreadLocal == null) {
            lock.lock();
            try {
                formatThreadLocal = sdfMap.get(pattern);
                if (formatThreadLocal == null){
                    formatThreadLocal =  new ThreadLocal<SimpleDateFormat>(){
                        protected SimpleDateFormat initialValue() {
                            return new SimpleDateFormat(pattern);
                        }
                    };
                    sdfMap.put(pattern,formatThreadLocal);
                }
            } finally {
                lock.unlock();
            }
        }

        return formatThreadLocal.get();

    }

    public static String format(Date date,String pattern){
        if(date == null){
            return null;
        }
        return getSdf(pattern).format(date);
    }

    public static Date parse(String dateStr,String pattern) throws ParseException {
        return getSdf(pattern).parse(dateStr);
    }

    public static final Date addSeconds(Date date,int val){
        return addTime(date,Calendar.SECOND,val);
    }

    public static final Date addTime(Date date,int timeType,int val){
        if(date==null){
            return null;
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(timeType,val);
        return instance.getTime();
    }



}
