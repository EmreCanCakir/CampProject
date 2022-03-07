package kodlamaio.CampProject.core.adapters.concretes;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import kodlamaio.CampProject.core.adapters.abstracts.CloudinaryService;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@Component
public class CloudinaryServiceManager implements CloudinaryService {

    private final Cloudinary cloudinary;

    public CloudinaryServiceManager() {
        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "themre28",
                "api_key", "511886318313898",
                "api_secret", "prqndNH3i5O9fh-wyqOOHfR9nto",
                "secure", true));
    }

    @Override
    public Map<?, ?> upload(MultipartFile multipartFile) {
        try {
            return cloudinary.uploader().upload(convertMultiPartToFile(multipartFile), ObjectUtils.emptyMap());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Map<?, ?> delete(String id) {
        try {
            return cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public File convertMultiPartToFile(MultipartFile multipartFile) {
        File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        try {
            FileOutputStream stream = new FileOutputStream(file);
            stream.write(multipartFile.getBytes());
            stream.close();
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
