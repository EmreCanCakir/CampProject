package kodlamaio.CampProject.business.concretes;

import kodlamaio.CampProject.business.abstracts.MernisVerificationService;
import kodlamaio.CampProject.business.adapters.PersonVerificationFromMernis;
import kodlamaio.CampProject.core.utilities.results.Result;
import kodlamaio.CampProject.core.utilities.results.SuccessResult;

public class MernisVerificationManager implements MernisVerificationService {
    @Override
    public Result check(PersonVerificationFromMernis personVerificationFromMernis) {
        return new SuccessResult("Mernis verification is success . ");
    }
}
