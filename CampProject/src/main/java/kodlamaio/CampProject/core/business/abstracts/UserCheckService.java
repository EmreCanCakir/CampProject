package kodlamaio.CampProject.core.business.abstracts;

import kodlamaio.CampProject.core.utilities.results.Result;

import java.util.Date;

public interface UserCheckService {

    Result isValidEmail(String email);
    Result isValidPassword(String password);
    Result isValidWebsite(String website);
    Result isValidPhoneCep(String phoneNumberCep);
    Result isValidPhoneSabit(String phoneNumberSabit);
    Result isValidWebsiteDiffDomain(String email, String website);
    Result isValidPhones(String phoneNumber);
    Result isValidBirthdate(String birthdate);
    Result isValidIdentityNumber(String identityNumber);
}
