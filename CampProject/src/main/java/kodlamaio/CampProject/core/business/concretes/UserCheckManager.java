package kodlamaio.CampProject.core.business.concretes;

import kodlamaio.CampProject.core.business.abstracts.UserCheckService;
import kodlamaio.CampProject.core.utilities.constants.UTILS;
import kodlamaio.CampProject.core.utilities.results.ErrorResult;
import kodlamaio.CampProject.core.utilities.results.Result;
import kodlamaio.CampProject.core.utilities.results.SuccessResult;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class UserCheckManager implements UserCheckService {
    @Override
    public Result isValidEmail(String email) {
        if ((email == null) || (email.length() < 4) || (email.length() > 50) || (!Pattern.matches(UTILS.CONSTANTS.REGEX_EMAIL, email))) {
            return new ErrorResult("Email is not valid. ");
        }
        return new SuccessResult();
    }

    @Override
    public Result isValidPassword(String password) {
        if(password.equals(null) || password.length()<=8)
            return new ErrorResult("Password is not valid");
        return new SuccessResult();
    }

    @Override
    public Result isValidWebsite(String website) {
        if (website == null || website.length()<=5)
            return new ErrorResult("Website name is invalid");
        return new SuccessResult();
    }

    @Override
    public Result isValidPhoneCep(String phoneNumberCep) {
        if(phoneNumberCep == null || !Pattern.matches(UTILS.CONSTANTS.REGEX_CEP_PHONE_NUM, phoneNumberCep))
            return new ErrorResult("Phone number is invalid");
        return new SuccessResult();
    }

    @Override
    public Result isValidPhoneSabit(String phoneNumberSabit) {
        if(phoneNumberSabit == null || !Pattern.matches(UTILS.CONSTANTS.REGEX_SABIT_PHONE_NUM, phoneNumberSabit))
            return new ErrorResult("Phone number is invalid");
        return new SuccessResult();
    }

    @Override
    public Result isValidWebsiteDiffDomain(String email, String website) {
        if (!email.split("@")[0].equals(website)) {
            return new ErrorResult("Corporate email is invalid");
        }
        return new SuccessResult();
    }

    @Override
    public Result isValidPhones(String phoneNumber) {
        if(isValidPhoneCep(phoneNumber).isSuccess() || isValidPhoneSabit(phoneNumber).isSuccess())
        return new SuccessResult();
        return new ErrorResult("Phone number is invalid");
    }

    @Override
    public Result isValidBirthdate(String birthdate) {
        if(!Pattern.matches(UTILS.CONSTANTS.REGEX_BIRTHDATE,birthdate))
        return new ErrorResult("Date is not valid. ");
        return new SuccessResult();
    }

    @Override
    public Result isValidIdentityNumber(String identityNumber) {
        if(!Pattern.matches(UTILS.CONSTANTS.REGEX_NATIONALITY_ID,identityNumber)){
            return new ErrorResult("Nationality id is not valid .");
        }
        return new SuccessResult();
    }
}
