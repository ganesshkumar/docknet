package docker.managers;

import com.spotify.docker.client.messages.Image;

import java.util.List;

/**
 * Created by ganessh on 07/07/16.
 */
public interface ImageManager {
    public List<Image> listAllImages();
}
