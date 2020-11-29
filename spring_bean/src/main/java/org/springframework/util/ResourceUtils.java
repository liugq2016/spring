package org.springframework.util;

import org.jetbrains.annotations.Nullable;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author lgq
 * @Description 将文件处理成Resource的工具类，枚举值并没写全，因为目前并未使用
 * @create 2020-11-29 20:45
 */
public abstract class ResourceUtils {

    /**  从类路径加载带有"classpath:"的伪URL前缀的文件 */
    public static final String CLASSPATH_URL_PREFIX = "classpath:";

    /**  从文件系统加载带有"file:"的URL前缀的文件 */
    public static final String FILE_URL_PREFIX = "file:";

    /**  从jar文件加载带有"jar:"的URL前缀的文件 */
    public static final  String JAR_URL_PREFIX = "jar:";

    /**  从tomcat文件加载带有"war:"的URL前缀的文件 */
    public static final String WAR_URL_PREFIX = "war:";

    /** 按文件系统中的URL协议加载文件  */
    public static final String URL_PROTOCOL_FILE = "file";

    /**  按jar文件条目的URL协议加载jar文件 */
    public static final String URL_PROTOCOL_JAR = "jar";

    /** 按war文件条目的URL协议加载war文件  */
    public static final String URL_PROTOCOL_WAR = "war";

    /** 按zip文件条目的URL协议加载zip文件  */
    public static final String URL_PROTOCOL_ZIP = "zip";


    /**
     *  判断给定的路径是否为带有"classpath:" 如是则返回true，如为标准的URL格式则创建相应的URL对象
     * @param resourceLocation
     * @return
     */
    public static boolean isUrl(@Nullable String resourceLocation){
        if (resourceLocation == null){
            return false;
        }
        if (resourceLocation.startsWith(CLASSPATH_URL_PREFIX)){
            return true;
        }
        try {
            new URL(resourceLocation);
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }

//    TODO:这里先去实现ClassUtils工具类
    public static URL getURL(String resourceLocation) throws FileNotFoundException{
        Assert.notNull(resourceLocation,"Resource location must not be null");
        if (resourceLocation.startsWith(CLASSPATH_URL_PREFIX)){
            String path = resourceLocation.substring(CLASSPATH_URL_PREFIX.length());
            ClassUtils.getDefaultClassLoader();
        }
    }

}
