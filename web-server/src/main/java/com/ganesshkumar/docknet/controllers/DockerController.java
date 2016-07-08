package com.ganesshkumar.docknet.controllers;

import com.spotify.docker.client.DockerException;
import com.spotify.docker.client.messages.Image;
import com.spotify.docker.client.messages.ImageInfo;
import com.spotify.docker.client.messages.RemovedImage;
import docker.managers.ImageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ganessh on 06/07/16.
 */
@RestController
public class DockerController {

    private final ImageManager imageManager;

    @Autowired
    public DockerController(ImageManager imageManager) {
        this.imageManager = imageManager;
    }

    @RequestMapping(value = "/docker/images", method = RequestMethod.GET)
    public List<Image> getAllImages() throws DockerException, InterruptedException {
        return imageManager.listAllImages();
    }

    @RequestMapping(value = "/docker/images/{imageId}", method = RequestMethod.GET)
    public ImageInfo inspectImage(@PathVariable (value = "imageId") String imageId) throws DockerException, InterruptedException {
        return imageManager.inspectImage(imageId);
    }

    @RequestMapping(value = "/docker/images/{imageId}", method = RequestMethod.DELETE)
    public List<RemovedImage> removeImage(@PathVariable (value = "imageId") String imageId) throws DockerException, InterruptedException {
        return imageManager.removeImage(imageId);
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Docker threw exception")
    @ExceptionHandler(DockerException.class)
    public void dockerException() {}

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Docker execution was interrupted")
    @ExceptionHandler(InterruptedException.class)
    public void interruptedException() {}
}
