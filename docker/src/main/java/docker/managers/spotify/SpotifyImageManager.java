package docker.managers.spotify;

import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerClient;
import com.spotify.docker.client.DockerException;
import com.spotify.docker.client.messages.Image;
import com.spotify.docker.client.messages.ImageInfo;
import com.spotify.docker.client.messages.RemovedImage;
import docker.managers.ImageManager;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ganessh on 07/07/16.
 */
@Component
public class SpotifyImageManager implements ImageManager {

    final DockerClient docker = new DefaultDockerClient("unix:///var/run/docker.sock");

    @Override
    public List<Image> listAllImages() throws DockerException, InterruptedException {
        return docker.listImages(DockerClient.ListImagesParam.allImages());
    }

    @Override
    public ImageInfo inspectImage(String imageId) throws DockerException, InterruptedException {
        return docker.inspectImage(imageId);
    }

    @Override
    public List<RemovedImage> removeImage(String imageId) throws DockerException, InterruptedException {
        return docker.removeImage(imageId);
    }
}
