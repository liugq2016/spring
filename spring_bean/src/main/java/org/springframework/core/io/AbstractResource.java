package org.springframework.core.io;

import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.channels.ReadableByteChannel;

/**
 * @author lgq
 * @Description 实现Resource接口的部分行为
 * @create 2020-11-29 19:35
 */
public abstract class AbstractResource implements Resource{

    /**
     * 这个实现将检查一个文件是否能打开，将检查文件目录和文件本身是否存在
     */
    @Override
    public boolean exists() {
        // 检查文件是否存在
        if (isFile()){
            try {
                return getFile().exists();
            } catch (IOException e) {
                Logger logger = LoggerFactory.getLogger(getClass());
                logger.debug("Could not retrieve File for existence check of"+getDescription());
            }
        }
        //检查是否能打开InputStream
        try {
            getInputStream().close();
            return true;
        } catch (IOException e) {
            Logger logger = LoggerFactory.getLogger(getClass());
            if (logger.isDebugEnabled()){
                logger.debug("Could not retrieve InputStream for existence check of"+getDescription());
            }
        }
        return false;
    }

    /**
     * 这个实现会永远返回true，当文件存在时
     * @return
     */
    @Override
    public boolean isReadable() {
        return exists();
    }

    /**
     * 这个实现会永远返回false
     * @return
     */
    @Override
    public boolean isOpen() {
        return false;
    }

    /**
     * 这个实现会永远返回false
     * @return
     */
    @Override
    public boolean isFile() {
        return false;
    }

    /**
     * 这个实现抛出一个FileNotFoundException异常，假设文件不能被处理成URL
     * @return
     * @throws IOException
     */
    @Override
    public URL getURL() throws IOException {
        throw new FileNotFoundException(getDescription() +"cannot be resolved to URL");
    }

    /**
     * 该实现会基于URL将URL构建成URI
     * @return
     * @throws IOException
     */
    @Override
    public URI getURI() throws IOException {
        URL url = getURL();
        return null;
    }

    @Override
    public File getFile() throws IOException {
        return null;
    }

    @Override
    public ReadableByteChannel readableChannel() throws IOException {
        return null;
    }

    @Override
    public long contentLength() throws IOException {
        return 0;
    }

    @Override
    public long lastModified() throws IOException {
        return 0;
    }

    @Override
    public Resource createRelationtive(String relativePath) throws IOException {
        return null;
    }

    @Override
    public @Nullable String getFilename() {
        return null;
    }
}
