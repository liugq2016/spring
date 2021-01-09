package cn.lqg.core.io;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.channels.ReadableByteChannel;

/**
 * @author lgq
 * @Description
 * @create 2021-01-09 16:09
 */
public abstract class AbstractResource implements Resource{

    /**
     * This implementation checks whether a File can be opened,
     * falling back to whether an InputStream can be opened.
     * This will cover both directories and content resources.
     */
    @Override
    public boolean exists() {
        // Try file existence: can we find the file in the file system?
        if (isFile()){
            try {
                return getFile().exists();
            } catch (IOException ex) {
                //TODO:这里是spring-jcl包下的实现类，需先去实现这个打印类
                ex.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean isReadable() {
        return false;
    }


    @Override
    public boolean isOpen() {
        return false;
    }

    /**
     * This implementation always returns {@code false}.
     */
    @Override
    public boolean isFile() {
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public URI getURI() throws IOException {
        return null;
    }

    @Override
    public URL getURL() throws IOException {
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
    public String getFilename() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }
}
