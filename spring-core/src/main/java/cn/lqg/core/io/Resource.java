package cn.lqg.core.io;

import cn.lqg.core.lang.Nullable;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * @author lgq
 * @Description Interface for a resource descriptor that abstracts from the actual
 * type of underlying resource, such as a file or class path resource.
 * <p>An InputStream can be opened for every resource if it exists in
 * physical form, but a URL or File handle can just be returned for
 * certain resources. The actual behavior is implementation-specific.
 * @create 2021-01-09 15:05
 */
public interface Resource extends InputStreamSource {

    /**
     * Determine whether this resource actually exists in physical form.
     * <p>This method performs(执行) a definitive(确定的) existence（存在性） check, whereas(但是) the
     * existence of a {@code Resource} handle only guarantees(保证) a valid(有效的) descriptor(描述) handle
     * @return boolean
     */
    boolean exists();

    /**
     * Indicate(指示) whether non-empty contents of this resource can be read via(凭借) {@link #getInputStream()}.
     * @return boolean
     */
    default boolean isReadable(){return exists();}

    /**
     * Indicate whether this resource represents a handle with an open stream.
     * If {@code true}, the InputStream cannot be read multiple times,
     * and must be read and closed to avoid resource leaks.
     * <p>Will be {@code false} for typical resource descriptors.
     *
     * @return boolean
     */
    default boolean isOpen(){return false;}

    /**
     * Determine whether this resource represents a file in a file system.
     * A value of {@code true} strongly suggests (but does not guarantee)
     * that a {@link #getFile()} call will succeed.
     * <p>This is conservatively {@code false} by default.
     * @since 5.0
     * @see #getFile()
     * @return boolean
     */
    default boolean isFile(){return false;}

    /**
     * Return a URI handle for this resource.
     * @throws IOException if the resource cannot be resolved as URL,
     * i.e. if the resource is not available as descriptor
     * @return URI
     */
    URI getURI() throws IOException;

    /**
     * Return a URL handle for this resource.
     * @throws IOException if the resource cannot be resolved as URI,
     * i.e. if the resource is not available as descriptor
     * @since 2.5
     * @return URL
     */
    URL getURL() throws IOException;

    /**
     * Return a File handle for this resource.
     * @throws java.io.FileNotFoundException if the resource cannot be resolved as
     * absolute file path, i.e. if the resource is not available in a file system
     * @throws IOException in case of general resolution/reading failures
     * @see #getInputStream()
     * @return File
     */
    File getFile() throws IOException;

    /**
     * Return a {@link ReadableByteChannel}.
     * <p>It is expected that each call creates a <i>fresh</i> channel.
     * <p>The default implementation returns {@link Channels#newChannel(InputStream)}
     * with the result of {@link #getInputStream()}.
     * @return the byte channel for the underlying resource (must not be {@code null})
     * @throws java.io.FileNotFoundException if the underlying resource doesn't exist
     * @throws IOException if the content channel could not be opened
     * @since 5.0
     * @see #getInputStream()
     */
    default ReadableByteChannel readableChannel() throws IOException{
        return Channels.newChannel(getInputStream());
    }

    /**
     * Determine the content length for this resource.
     * @throws IOException if the resource cannot be resolved
     * (in the file system or as some other known physical resource type)
     * @return long
     */
    long contentLength() throws IOException;

    /**
     * Determine the last-modified timestamp for this resource.
     * @throws IOException if the resource cannot be resolved
     * (in the file system or as some other known physical resource type)
     * @return long
     */
    long lastModified() throws IOException;

    /**
     * Create a resource relative to this resource.
     * @param relativePath the relative path (relative to this resource)
     * @return the resource handle for the relative resource
     * @throws IOException if the relative resource cannot be determined
     */
    Resource createRelative(String relativePath) throws IOException;

    /**
     * Determine a filename for this resource, i.e. typically the last
     * part of the path: for example, "myfile.txt".
     * <p>Returns {@code null} if this type of resource does not
     * have a filename.
     * @return String
     */
    @Nullable
    String getFilename();

    /**
     * Return a description for this resource,
     * to be used for error output when working with the resource.
     * <p>Implementations are also encouraged to return this value
     * from their {@code toString} method.
     * @see Object#toString()
     * @return String
     */
    String getDescription();

}
