package kodlamaio.CampProject.core.utilities.constants;

import lombok.experimental.UtilityClass;
import java.util.Locale;

@UtilityClass
public class UTILS {


    @UtilityClass
    public class CONSTANTS{
        public static final String REGEX_CEP_PHONE_NUM = "/^(05)([0-9]{2})\\s?([0-9]{3})\\s?([0-9]{2})\\s?([0-9]{2})$/\n";
        public static final String REGEX_SABIT_PHONE_NUM = "/^(0)([2348]{1})([0-9]{2})\\s?([0-9]{3})\\s?([0-9]{2})\\s?([0-9]{2})$/";
        public static final String REGEX_NATIONALITY_ID = "^[1-9]{1}[0-9]{9}[02468]{1}$\n";
        public static final String REGEX_BIRTHDATE = "/^([1-9]|[12][0-9]|3[01])(|\\/|\\.|\\-|\\s)?(0[1-9]|1[12])\\2(19[0-9]{2}|200[0-9]|201[0-8])$/\n";
        public static final String REGEX_EMAIL = "^\\\\w+(\\\\.\\\\w+)*@\\\\p{javaLowerCase}{2,12}+(\\\\.\\\\p{javaLowerCase}{2,6})+$";
        public static final String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$\n";
        public static final String REGEX_WEBSITE = "^(w{3}\\.)?[^.]+(\\.\\p{javaLowerCase}{2,12})+$";
        public static final String REGEX_CORPORATE_EMAIL = "email.split(\"@\")[1].equals(website)";
    }

}
