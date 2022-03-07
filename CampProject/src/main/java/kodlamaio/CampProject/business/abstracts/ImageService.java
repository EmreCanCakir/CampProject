package kodlamaio.CampProject.business.abstracts;

import kodlamaio.CampProject.core.utilities.results.DataResult;
import kodlamaio.CampProject.core.utilities.results.Result;
import kodlamaio.CampProject.entities.concretes.Image;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    DataResult<Image> getById(int id);

    DataResult<Image> getByPublicId(String publicId);

    Result upload(MultipartFile multipartFile, int id);

    Result deleteById(int id);

    Result deleteByPublicId(String publicId);
}
