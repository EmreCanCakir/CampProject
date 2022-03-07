package kodlamaio.CampProject.core.utilities.configs;

import kodlamaio.CampProject.entities.concretes.*;
import kodlamaio.CampProject.entities.concretes.dtos.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);     // Strict Bire bir eslestirme yapar.
        modelMapper.addMappings(employerAddDtoEmployerPropertyMap);
        modelMapper.addMappings(jobSeekerAddDtoJobSeekerPropertyMap);
        modelMapper.addMappings(systemStaffDtoSystemStaffPropertyMap);
        modelMapper.addMappings(jobAdvertDtoJobAdvertPropertyMap);
        modelMapper.addMappings(jobSeekerSkillAddDtoJobSeekerSkillPropertyMap);
        modelMapper.addMappings(jobSeekerSchoolAddDtoJobSeekerSchoolPropertyMap);
        modelMapper.addMappings(jobSeekerLanguageAddDtoJobSeekerLanguagePropertyMap);
        modelMapper.addMappings(jobExperienceAddDtoJobSeekerExperiencePropertyMap);
        return modelMapper;
    }

    private final PropertyMap<EmployerAddDto, Employer> employerAddDtoEmployerPropertyMap = new PropertyMap<EmployerAddDto, Employer>() {
        @Override
        protected void configure() {
            map(true, destination.isActive());
            map(new ArrayList<>(), destination.getJobAdverts());
            map(new ArrayList<>(),destination.getImages());
        }
    };

    private final PropertyMap<JobSeekerAddDto, JobSeeker> jobSeekerAddDtoJobSeekerPropertyMap = new PropertyMap<JobSeekerAddDto, JobSeeker>() {
        @Override
        protected void configure() {
            map(true, destination.isActive());
            map(new ArrayList<>(),destination.getCvs());
            map(new ArrayList<>(),destination.getJobSeekerSkills());
            map(new ArrayList<>(),destination.getJobSeekerSchools());
            map(new ArrayList<>(),destination.getJobSeekerLanguages());
            map(new ArrayList<>(),destination.getJobSeekerExperiences());
            map(new ArrayList<>(),destination.getImages());
        }
    };
    private final PropertyMap<SystemStaffDto, SystemStaff> systemStaffDtoSystemStaffPropertyMap = new PropertyMap<SystemStaffDto, SystemStaff>() {
        @Override
        protected void configure() {
            map(true, destination.isActive());
            map(new ArrayList<>(),destination.getImages());
        }
    };
    private final PropertyMap<JobAdvertDto, JobAdvert> jobAdvertDtoJobAdvertPropertyMap = new PropertyMap<JobAdvertDto, JobAdvert>() {
        @Override
        protected void configure() {
            map(true, destination.isActive());
            map(source.getEmployerId(), destination.getEmployer().getId());
            map(source.getJobPositionId(), destination.getJobPosition().getId());
            map(source.getCityId(), destination.getCity().getId());

        }
    };

    private final PropertyMap<JobSeekerSkillAddDto, JobSeekerSkill> jobSeekerSkillAddDtoJobSeekerSkillPropertyMap = new PropertyMap<JobSeekerSkillAddDto, JobSeekerSkill>() {
        @Override
        protected void configure() {
            map(source.getJobSeekerId(),destination.getJobSeeker().getId());
            map(source.getJobSeekerSkillId(),destination.getSkill().getId());
        }
    };
    private final PropertyMap<JobSeekerSchoolAddDto,JobSeekerSchool> jobSeekerSchoolAddDtoJobSeekerSchoolPropertyMap = new PropertyMap<JobSeekerSchoolAddDto, JobSeekerSchool>() {
        @Override
        protected void configure() {
            map(source.getJobSeekerId(),destination.getJobSeeker().getId());
            map(source.getSchoolId(),destination.getSchool().getId());
            map(source.getDepartmentId(),destination.getDepartment().getId());
        }
    };
    private final PropertyMap<JobSeekerLanguageAddDto,JobSeekerLanguage> jobSeekerLanguageAddDtoJobSeekerLanguagePropertyMap = new PropertyMap<JobSeekerLanguageAddDto, JobSeekerLanguage>() {
        @Override
        protected void configure() {
        map(source.getJobSeekerId(),destination.getJobSeeker().getId());
        map(source.getLanguageId(),destination.getLanguage().getId());
        }
    };
    private final PropertyMap<JobExperienceAddDto,JobSeekerExperience> jobExperienceAddDtoJobSeekerExperiencePropertyMap = new PropertyMap<JobExperienceAddDto, JobSeekerExperience>() {
        @Override
        protected void configure() {
            map(source.getJobSeekerId(),destination.getJobSeeker().getId());
            map(source.getJobPositionId(),destination.getJobPosition().getId());
        }
    };

}
