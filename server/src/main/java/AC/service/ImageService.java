package AC.service;

import AC.domain.Image;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImageService {

    List<Image> saveFile(List<MultipartFile> multipartFile, Long expenseId);

    List<Image> getImages(Long expenseId);

    Resource getImage(Long imageId) throws IOException;

}
