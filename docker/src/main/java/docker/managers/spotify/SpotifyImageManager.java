package docker.managers.spotify;

import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerClient;
import com.spotify.docker.client.DockerException;
import com.spotify.docker.client.messages.Image;
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
    public List<Image> listAllImages() {
        List<Image> images = new ArrayList<Image>();
        try {
            images = docker.listImages(DockerClient.ListImagesParam.allImages());
        } catch (DockerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            return images;
        }
    }
}
