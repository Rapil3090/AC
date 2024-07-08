package AC.controller;

import AC.domain.Image;
import AC.service.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @PostMapping("/image")
    public ResponseEntity<List<Image>> saveImage(
            @RequestParam("file") List<MultipartFile> files,
            @RequestParam("expenseId") Long expenseId) {


        return ResponseEntity.ok(imageService.saveFile(files, expenseId));
    }

    @GetMapping("/image")
    public ResponseEntity<List<Image>> getImages(
            @RequestParam("expenseId") Long expenseId) {

        return ResponseEntity.ok(imageService.getImages(expenseId));
    }

}
