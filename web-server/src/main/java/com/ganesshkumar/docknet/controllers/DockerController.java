package com.ganesshkumar.docknet.controllers;

import com.spotify.docker.client.messages.Image;
import docker.managers.ImageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Image> getAllImages() {
        return imageManager.listAllImages();
    }
}
