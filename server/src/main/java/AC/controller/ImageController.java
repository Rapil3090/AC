package AC.controller;

import AC.domain.Image;
import AC.service.ImageService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/images")
    public ResponseEntity<List<Image>> getImages(
            @RequestParam("expenseId") Long expenseId) {

        return ResponseEntity.ok(imageService.getImages(expenseId));
    }

    @GetMapping("/image/{imageId}")
    public ResponseEntity<Resource> getImage(@PathVariable Long imageId, HttpServletRequest request) {
        try {
            Resource resource = imageService.getImage(imageId);

            String contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
            if (contentType == null) {
                contentType = "application/octet-stream";
            }

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"");

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .headers(headers)
                    .body(resource);
        } catch (IOException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
