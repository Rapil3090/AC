package AC.controller;

import AC.domain.Image;
import AC.service.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@AllArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @PostMapping("/image")
    public ResponseEntity<List<Image>> saveImage(
            @RequestParam("file") List<MultipartFile> files) {


        return ResponseEntity.ok(imageService.saveFile(files));
    }

}
