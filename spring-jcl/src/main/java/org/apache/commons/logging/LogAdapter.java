package org.apache.commons.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.spi.LoggerContext;
import org.apache.logging.log4j.spi.ExtendedLogger;

import java.io.Serializable;

/**
 * Spring's common JCL adapter(适配器) behind(后面) {@link LogFactory} and {@link LogFactoryService}.
 * Detects(检测，发现) the presence(存在) of Log4j 2.x / SLF4J, falling back to {@code java.util.logging}.
 *
 * @author lgq
 * @Description Spring的JCL适配器
 * @create 2021-01-09 20:08
 */
final class LogAdapter {

    private static final String LOG4J_SPI = "org.apache.logging.log4j.spi.ExtendedLogger";

    private static final String LOG4J_SLF4J_PROVIDER = "org.apache.logging.slf4j.SLF4JProvider";

    private static final String SLF4J_SPI = "org.slf4j.spi.LocationAwareLogger";

    private static final String SLF4J_API = "org.slf4j.Logger";

    private static final LogApi logApi;

    //初始化成员变量logApi的值
    static {
        if (isPresent(LOG4J_SPI)) {
            if (isPresent(LOG4J_SLF4J_PROVIDER) && isPresent(LOG4J_SPI)){
                // log4j-to-slf4j bridge -> we'll rather go with the SLF4J SPI;
                // however, we still prefer Log4j over the plain SLF4J API since
                // the latter does not have location awareness support.
                logApi = LogApi.SLF4J_LAL;
            }else {
                // Use Log4j 2.x directly, including location awareness support
                logApi = LogApi.LOG4J;
            }
        }
        else if(isPresent(SLF4J_SPI)){
            // Full SLF4J SPI including location awareness support
            logApi = LogApi.SLF4J_LAL;
        }
        else if (isPresent(SLF4J_API)){
            // Minimal SLF4J API without location awareness support
            logApi = LogApi.SLF4J;
        }
        else {
            // java.util.logging as default
            logApi = LogApi.JUL;
        }
    }

    private LogAdapter(){}

    /**
     * Create an actual {@link Log} instance for the selected API.
     * @param name the logger name
     */
    //TODO:需先实现各种日志模式的日志打印对象(logger)
//    public static Log createLog(String name){
////        switch (logApi){
////            case LOG4J:
////
////        }
//    }


    private static boolean isPresent(String className){
        try {
            Class.forName(className,false,LogAdapter.class.getClassLoader());
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }


    private enum LogApi{LOG4J,SLF4J_LAL,SLF4J,JUL}

    @SuppressWarnings("serial")
    private static class Log4jLog implements Log, Serializable{

        private static final String FQCN = Log4jLog.class.getName();

        private static final LoggerContext loggerContext =
                LogManager.getContext(Log4jLog.class.getClassLoader(),false);

        private final ExtendedLogger logger;

        public Log4jLog(String name){
            LoggerContext context = Log4jLog.loggerContext;
            if (context == null){
               context = LogManager.getContext(Log4jLog.class.getClassLoader(),false);
            }
            this.logger = context.getLogger(name);
        }

        @Override
        public boolean isFatalEnabled() {
            return false;
        }

        @Override
        public boolean isErrorEnabled() {
            return false;
        }

        @Override
        public boolean isWarnEnabled() {
            return false;
        }

        @Override
        public boolean isInfoEnable() {
            return false;
        }

        @Override
        public boolean isDebugEnable() {
            return false;
        }

        @Override
        public boolean isTraceEnable() {
            return false;
        }

        @Override
        public void fatal(Object message) {

        }

        @Override
        public void fatal(Object message, Throwable t) {

        }

        @Override
        public void error(Object message) {

        }

        @Override
        public void error(Object message, Throwable t) {

        }

        @Override
        public void warn(Object message) {

        }

        @Override
        public void warn(Object message, Throwable t) {

        }

        @Override
        public void info(Object message) {

        }

        @Override
        public void info(Object message, Throwable t) {

        }

        @Override
        public void debug(Object message) {

        }

        @Override
        public void debug(Object message, Throwable t) {

        }

        @Override
        public void trace(Object message) {

        }

        @Override
        public void trace(Object message, Throwable t) {

        }
    }


}
