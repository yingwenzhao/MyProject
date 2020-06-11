package util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
public final class HostUtil {

    private static String HOST_NAME;

    private HostUtil() {

    }

    public static String getHostName() {
        if (StringUtils.isBlank(HOST_NAME)) {
            try {
                return InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException e) {
                log.error("", e);
            }
            return "UNKNOWN";
        } else {
            return HOST_NAME;
        }
    }

    public static String getThreadNo() {
        return getHostName() + "_" + System.currentTimeMillis() + "_" + (int) (Math.random() * 9000 + 1000);
    }


}
