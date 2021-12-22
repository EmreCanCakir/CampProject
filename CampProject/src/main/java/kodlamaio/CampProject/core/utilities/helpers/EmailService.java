package kodlamaio.CampProject.core.utilities.helpers;

import kodlamaio.CampProject.core.utilities.results.Result;

public interface EmailService {
    Result sent(String email, String title, String body);
}
