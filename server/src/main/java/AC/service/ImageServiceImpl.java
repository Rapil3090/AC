package AC.service;

import AC.domain.Expense;
import AC.domain.Image;
import AC.exception.ExpenseException;
import AC.exception.ImageException;
import AC.repository.ExpenseRepository;
import AC.repository.ImageRepository;
import AC.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;
    private final ExpenseRepository expenseRepository;

    public List<Image> saveFile(List<MultipartFile> multipartFile, Long expenseId) {
        if (multipartFile.isEmpty()) {
            throw new ImageException(ErrorCode.IMAGE_NOT_FOUND);
        }

        Expense expense = expenseRepository.findById(expenseId).orElseThrow(
                () -> new ExpenseException(ErrorCode.EXPENSE_NOT_FOUND));

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
                image.setSaveImageName(savedFileName);
                image.setSaveDate(LocalDateTime.now());
                image.setImageName(originalFileName);
                image.setExpense(expense);
                image.setImagePath(path + savedFileName);
                saveImage.add(image);

                imageRepository.save(image);

            } catch (IOException e) {
                throw new ImageException(ErrorCode.IMAGE_NOT_FOUND);
            }
        }
        return saveImage;
    }

    public List<Image> getImages(Long expenseId) {

        return imageRepository.findByExpenseId(expenseId);
    }

    public Resource getImage(Long imageId) throws IOException {
        Image image = imageRepository.findById(imageId).orElseThrow(
                () -> new ImageException(ErrorCode.IMAGE_NOT_FOUND));

        String path = "/Users/rapil/Desktop/repo/AccountBook/image/";
        Path filePath = Paths.get(path + image.getSaveImageName());

        return new UrlResource(filePath.toUri());
    }

}
