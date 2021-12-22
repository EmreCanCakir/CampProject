package kodlamaio.CampProject.business.abstracts;

import kodlamaio.CampProject.business.adapters.PersonVerificationFromMernis;
import kodlamaio.CampProject.core.utilities.results.Result;

public interface MernisVerificationService {
    Result check(PersonVerificationFromMernis personVerificationFromMernis);
}
