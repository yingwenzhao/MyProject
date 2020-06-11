package contextlistener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class LogContextListener implements ServletContextListener {
    private Logger log = LoggerFactory.getLogger("contextlistener.LogContextListener");
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        for (int i = 0;i<10;i++){
            log.debug("黎大猫打印了！！！！！！！！！！！！！！！！"+i);
        }

    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
