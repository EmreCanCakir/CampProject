package kodlamaio.CampProject.business.concretes;

import kodlamaio.CampProject.business.abstracts.CvService;
import kodlamaio.CampProject.core.utilities.business.BusinessRules;
import kodlamaio.CampProject.core.utilities.results.*;
import kodlamaio.CampProject.dataAccess.abstracts.CvDao;
import kodlamaio.CampProject.entities.concretes.Cv;
import kodlamaio.CampProject.entities.concretes.dtos.CvAddDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CvManager implements CvService {

    private CvDao cvDao;
    private ModelMapper modelMapper;

    @Autowired
    public CvManager(CvDao cvDao, ModelMapper modelMapper) {
        this.cvDao = cvDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public DataResult<Cv> getByJobSeekerId(int jobSeekerId) {
        if(!cvDao.getByJobSeeker_Id(jobSeekerId).isEmpty()){
            return new SuccessDataResult<>(this.cvDao.getByJobSeeker_Id(jobSeekerId).get());
        }
        return new ErrorDataResult<>("Cv's job seeker id does not found. ");
    }

    @Override
        public DataResult<Cv> getById(int id) {
        if(this.cvDao.findById(id).isEmpty()){
            return new SuccessDataResult<>(this.cvDao.getById(id));
        }
        return new ErrorDataResult<>("Cv id does not found. ");
    }

    @Override
    public Result add(CvAddDto entity) {
        Cv cv = modelMapper.map(entity,Cv.class);
        if(!this.cvDao.findById(cv.getId()).isEmpty()){
            this.cvDao.save(cv);
            return new SuccessResult();
        }
        return new ErrorResult("Cv is already exist. ");
    }

    @Override
    public Result deleteById(int id) {
        if(!this.cvDao.findById(id).isEmpty()){
            this.cvDao.deleteById(id);
        }
        return new ErrorResult("Cv does not exist. ");
    }

}
