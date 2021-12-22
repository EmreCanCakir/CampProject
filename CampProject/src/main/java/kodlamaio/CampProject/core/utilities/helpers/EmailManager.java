package kodlamaio.CampProject.core.utilities.helpers;

import kodlamaio.CampProject.core.utilities.results.Result;
import kodlamaio.CampProject.core.utilities.results.SuccessResult;

public class EmailManager implements EmailService{

    @Override
    public Result sent(String email, String title, String body) {
        return new SuccessResult("Email sent successfully");
    }
}
