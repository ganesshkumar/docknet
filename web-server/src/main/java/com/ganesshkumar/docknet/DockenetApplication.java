package com.ganesshkumar.docknet;

import com.ganesshkumar.docknet.controllers.DockerController;
import com.ganesshkumar.docknet.controllers.PagesController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackageClasses = {
        docker.managers.ImageManager.class,
        DockerController.class,
        PagesController.class
})

@SpringBootApplication
public class DockenetApplication {
    public static void main(String[] args) {
        SpringApplication.run(DockenetApplication.class, args);
    }
}
