package org.apache.commons.logging;

/**
 * A minimal incarnation of Apache Commons Logging's {@code LogFactory} API,
 * providing just the common {@link Log} lookup methods. This is inspired
 * by the JCL-over-SLF4J bridge and should be source as well as binary
 * compatible with all common use of the Commons Logging API (in particular:
 * with {@code LogFactory.getLog(Class/String)} field initializers).
 *
 * <p>This implementation does not support Commons Logging's original provider
 * detection. It rather only checks for the presence of the Log4j 2.x API
 * and the SLF4J 1.7 API in the Spring Framework classpath, falling back to
 * {@code java.util.logging} if none of the two is available. In that sense,
 * it works as a replacement for the Log4j 2 Commons Logging bridge as well as
 * the JCL-over-SLF4J bridge, both of which become irrelevant for Spring-based
 * setups as a consequence (with no need for manual excludes of the standard
 * Commons Logging API jar anymore either). Furthermore, for simple setups
 * without an external logging provider, Spring does not require any extra jar
 * on the classpath anymore since this embedded log factory automatically
 * delegates to {@code java.util.logging} in such a scenario.
 *
 * <p><b>Note that this Commons Logging variant is only meant to be used for
 * infrastructure logging purposes in the core framework and in extensions.</b>
 * It also serves as a common bridge for third-party libraries using the
 * Commons Logging API, e.g. Apache HttpClient, and HtmlUnit, bringing
 * them into the same consistent arrangement without any extra bridge jars.
 *
 * <p><b>For logging need in application code, prefer direct use of Log4j 2.x
 * or SLF4J or {@code java.util.logging}.</b> Simply put Log4j 2.x or Logback
 * (or another SLF4J provider) onto your classpath, without any extra bridges,
 * and let the framework auto-adapt to your choice.
 *
 * @author lgq
 * @Description 打印日志的抽象类
 * @create 2021-01-09 16:23
 */
public abstract class LogFactory {

    public static Log getLog(Class<?> clazz){
        return getLog(clazz.getName());
    }

    public static Log getLog(String name){
        return null;
    }

}
