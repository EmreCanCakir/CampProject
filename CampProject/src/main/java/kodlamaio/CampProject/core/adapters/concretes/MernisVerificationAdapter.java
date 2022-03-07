package kodlamaio.CampProject.core.adapters.concretes;

import kodlamaio.CampProject.core.adapters.abstracts.MernisVerificationService;
import kodlamaio.CampProject.core.utilities.results.ErrorResult;
import kodlamaio.CampProject.core.utilities.results.Result;
import kodlamaio.CampProject.core.utilities.results.SuccessResult;
import mernis.HEFKPSPublicSoap;
import org.springframework.stereotype.Service;

@Service
public class MernisVerificationAdapter implements MernisVerificationService {
    @Override
    public Result check(String identityNumber, String firstName, String lastName, int birthYear) {
       HEFKPSPublicSoap kpsPublicSoapProxy = new HEFKPSPublicSoap();
        boolean isSuccess ;
        try {
            isSuccess = kpsPublicSoapProxy.TCKimlikNoDogrula(
                    Long.parseLong(identityNumber),
                    firstName,
                    lastName,
                    birthYear);
            if (isSuccess == false)
                return new ErrorResult("Mernis verification is not success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new SuccessResult();
    }
}
