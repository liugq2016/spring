package cn.lqg.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * {@link Resource} implementation for a given {@link InputStream}.
 * <p>Should only be used if no other specific {@code Resource} implementation
 * is applicable. In particular, prefer {@link ByteArrayResource} or any of the
 * file-based {@code Resource} implementations where possible.
 *
 * <p>In contrast to other {@code Resource} implementations, this is a descriptor
 * for an <i>already opened</i> resource - therefore returning {@code true} from
 * {@link #isOpen()}. Do not use an {@code InputStreamResource} if you need to
 * keep the resource descriptor somewhere, or if you need to read from a stream
 * multiple times.
 * @author lgq
 * @Description 一个Resource接口的实现类，返回InputStream
 * @create 2021-01-09 16:06
 */
//TODO:这里须先去实现包下的AbstractResource类
public class InputStreamResource extends AbstractResource{
    @Override
    public Resource createRelative(String relativePath) throws IOException {
        return null;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return null;
    }
}
