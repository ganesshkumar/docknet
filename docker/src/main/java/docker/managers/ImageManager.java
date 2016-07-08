package docker.managers;

import com.spotify.docker.client.DockerException;
import com.spotify.docker.client.messages.Image;
import com.spotify.docker.client.messages.ImageInfo;
import com.spotify.docker.client.messages.RemovedImage;

import java.util.List;

/**
 * Created by ganessh on 07/07/16.
 */
public interface ImageManager {
    public List<Image> listAllImages() throws DockerException, InterruptedException;

    public ImageInfo inspectImage(String imageId) throws DockerException, InterruptedException;

    public List<RemovedImage> removeImage(String imageId) throws DockerException, InterruptedException;
}
