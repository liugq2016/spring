package org.springframework.core.io;


import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import org.jetbrains.annotations.Nullable;


/**
 * @author lgq
 * @Description 提供一个文件或class路径下的文件读进内存的接口
 * @create 2020-11-29 18:59
 */
public interface Resource extends InputStreamSource{

    /**
     *  判断此文件是否以物理形式存在
     */
    boolean exists();

    /**
     * 判断该文件是否可读
     */
    default boolean isReadable(){return exists();}

    /**
     * 判断该文件是否可以被打开
     */
    default boolean isOpen() {return false;};

    /**
     *  确定此资源是否表示文件系统中的文件
     */
    default boolean isFile() {return false;};

    /**
     * 为当前资源返回一个URL句柄
     * @throws IOException
     */
    URL getURL() throws IOException;

    /**
     * 为当前资源返回一个URI句柄
     * @throws IOException
     */
    URI getURI() throws IOException;

    /**
     * 为当前资源返回一个文件句柄
     * @throws IOException
     */
    File getFile() throws IOException;

    /**
     * 每次调用都会返回一个新的Channel对象
     * @throws IOException
     */
    default ReadableByteChannel readableChannel() throws IOException{
        return Channels.newChannel(getInputStream());
    }

    /**
     * 确定这个资源的长度
     * @throws IOException
     */
    long contentLength() throws IOException;

    /**
     * 确定资源的最后一次修改的时间戳
     * @throws IOException
     */
    long lastModified() throws IOException;

    /**
     * 创建与当前资源相关的资源
     * @param relativePath
     * @throws IOException
     */
    Resource createRelationtive(String relativePath) throws IOException;

    /**
     *  确定当前资源的文件名
     *  @Nullable 允许该方法返回空值(null) import org.springframework.lang.Nullable;
     */
    @Nullable
    String getFilename();

    /**
     *  返回当前资源的描述
     */
    String getDescription();

}
