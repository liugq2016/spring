package org.springframework.core.io;


import java.io.IOException;
import java.io.InputStream;

/**
 * @author lgq
 * @Description 该接口返回InputStream对象，是一个基接口
 * @create 2020-11-29 17:01
 */
public interface InputStreamSource {

    /**
     *  仅提供一个返回InputStream对象的方法
     * @return an {@link InputStream} for the content of an underlying resource
     * @throws IOException IOException if the content stream could not be opened
     */
    InputStream getInputStream() throws IOException;

}
