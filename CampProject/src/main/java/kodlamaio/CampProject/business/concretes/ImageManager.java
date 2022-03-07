package kodlamaio.CampProject.business.concretes;

import kodlamaio.CampProject.business.abstracts.ImageService;
import kodlamaio.CampProject.core.adapters.abstracts.CloudinaryService;
import kodlamaio.CampProject.core.entities.User;
import kodlamaio.CampProject.core.utilities.results.*;
import kodlamaio.CampProject.dataAccess.abstracts.ImageDao;
import kodlamaio.CampProject.entities.concretes.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

@Service
public class ImageManager implements ImageService {

    private ImageDao imageDao;
    private CloudinaryService cloudinaryService;

    @Autowired
    public ImageManager(ImageDao imageDao, CloudinaryService cloudinaryService) {
        this.imageDao = imageDao;
        this.cloudinaryService = cloudinaryService;
    }

    @Override
    public DataResult<Image> getById(int id) {
        if(!this.imageDao.findById(id).isEmpty()){
            return new SuccessDataResult<>(this.imageDao.getById(id));
        }
        return new ErrorDataResult<>("Image id does not found. ");
    }

    @Override
    public DataResult<Image> getByPublicId(String publicId) {
        return new SuccessDataResult<>(this.imageDao.getByPublicId(publicId).get());
    }

    @Override
    public Result upload(MultipartFile multipartFile, int userId) {
        if(this.imageDao.getByUser_Id(userId).isEmpty()){
           return new ErrorResult();
        }else {
            if (multipartFile == null || multipartFile.isEmpty())
                return new ErrorResult("File does not found. ");

            int width, height;
            try {
                BufferedImage bufferedImage = ImageIO.read(multipartFile.getInputStream());
                if (bufferedImage == null) return new ErrorResult("That is not an image. ");
                width = bufferedImage.getWidth();
                height = bufferedImage.getHeight();

            } catch (IOException e) {
                return new ErrorResult("Image does not validated. ");
            }
            Map<?, ?> uploadRes = cloudinaryService.upload(multipartFile);
            if (uploadRes == null) return new ErrorResult("Image cannot uploaded. ");
            Image image = new Image(0, (String) uploadRes.get("public_id"), (String) uploadRes.get("original_filename"),
                    new User(userId), (String) uploadRes.get("url"), width, height);
            Image savedImg = imageDao.save(image);
            return new SuccessDataResult<>(savedImg);
        }
    }

    @Override
    public Result deleteById(int id) {
        if(this.imageDao.findById(id).isEmpty()){
            return new ErrorResult("Image does not found. ");
        }
        Image image = imageDao.getById(id);
        Map<?, ?> upload = cloudinaryService.delete(image.getPublicId());
        if (upload == null)
            return new ErrorDataResult<>("Image does not deleted. ");

        imageDao.deleteById(id);
        return new SuccessResult("Image is deleted successfully. ");
    }

    @Override
    public Result deleteByPublicId(String publicId) {
        Map<?, ?> upload = cloudinaryService.delete(publicId);
        if (upload == null) return new ErrorDataResult<>("Image Does not exist.");

        imageDao.deleteByPublicId(publicId);
        return new SuccessResult("Image is deleted successfully. ");
    }
}
