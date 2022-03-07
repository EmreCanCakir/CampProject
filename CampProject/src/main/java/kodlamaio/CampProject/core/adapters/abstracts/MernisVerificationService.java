package kodlamaio.CampProject.core.adapters.abstracts;

import kodlamaio.CampProject.core.utilities.results.Result;

public interface MernisVerificationService {
    Result check(String identityNumber, String firstName, String lastName, int birthYear);
}
