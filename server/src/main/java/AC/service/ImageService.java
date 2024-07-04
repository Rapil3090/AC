package AC.service;

import AC.domain.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {

    List<Image> saveFile(List<MultipartFile> multipartFile, Long expenseId);

}
