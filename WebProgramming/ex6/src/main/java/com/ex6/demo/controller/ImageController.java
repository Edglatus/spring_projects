package com.ex6.demo.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ImageController {
	@Autowired
	ServletContext context;

    @RequestMapping("/files/{imagename}")
    public void imageViewer(HttpServletRequest req, HttpServletResponse res, @PathVariable("imagename") String imageName) {
        String path = context.getRealPath("resources/uploads/");
        Path image = Paths.get(path, imageName);

        if (Files.exists(image)) {
            res.setHeader("Content-Disposition", "inline");
            res.setContentType(MediaType.IMAGE_PNG_VALUE);
            try {
                Files.copy(image, res.getOutputStream());
                res.getOutputStream().flush();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }

}