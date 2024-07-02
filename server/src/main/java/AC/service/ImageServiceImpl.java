package AC.service;

import AC.domain.Image;
import AC.exception.ImageException;
import AC.repository.ImageRepository;
import AC.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    public List<Image> saveFile(List<MultipartFile> multipartFile) {
        if (multipartFile.isEmpty()) {
            throw new ImageException(ErrorCode.IMAGE_NOT_FOUND);
        }

        List<Image> saveImage = new ArrayList<>();

        for (MultipartFile multipartFiles : multipartFile) {

            String uuid = UUID.randomUUID().toString();
            String path = "/Users/rapil/Desktop/repo/AccountBook/image/";
            String originalFileName = multipartFiles.getOriginalFilename();
            String savedFileName = uuid + "." + originalFileName;

            File file = new File(path + savedFileName);

            try {
                multipartFiles.transferTo(file);
                Image image = new Image();
                image.setSaveDate(LocalDateTime.now());
                image.setImageName(savedFileName);
                image.setImageName(originalFileName);
                saveImage.add(image);

                imageRepository.save(image);

            } catch (IOException e) {
                throw new ImageException(ErrorCode.IMAGE_NOT_FOUND);
            }
        }

        return saveImage;


    }
}
