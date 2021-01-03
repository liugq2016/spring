package spring.springframework.core.io.support;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author lgq
 * @Description 作为InputSteam对象的简单接口, 这是Spring更广泛接口Resource的基本接口
 *
 * <p>For single-use streams, {@link InputStreamResource} can be used for any
 *  given {@code InputStream}. Spring's {@link ByteArrayResource} or any
 *  file-based {@code Resource} implementation can be used as a concrete
 *  instance, allowing one to read the underlying content stream multiple times.
 *  This makes this interface useful as an abstract content source for mail
 *  attachments, for example.
 *
 * @create 2021-01-03 15:48
 */
public interface InputStreamResource {

    /**
     *Return an {@link InputStream} for the content of an underlying resource.
     * <p>It is expected that each call creates a <i>fresh</i> stream.
     * <p>This requirement is particularly important when you consider an API such
     * as JavaMail, which needs to be able to read the stream multiple times when
     * creating mail attachments. For such a use case, it is <i>required</i>
     * that each {@code getInputStream()} call returns a fresh stream.
     * @return the input stream for the underlying resource (must not be {@code null})
     * @throws java.io.FileNotFoundException if the underlying resource doesn't exist
     * @throws IOException if the content stream could not be opened
     */
    InputStream getInputStream() throws IOException;

}
