package kodlamaio.CampProject.core.utilities.constants;

import kodlamaio.CampProject.core.utilities.results.Result;
import lombok.experimental.UtilityClass;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;

@UtilityClass
public class UTILS {


    @UtilityClass
    public class CONSTANTS{
        public static final String REGEX_CEP_PHONE_NUM = "^((\\+?\\d{1,3})?0?[\\s-]?)?\\(?0?\\d{3}\\)?[\\s-]?\\d{3}[\\s-]?\\d{2}[\\s-]?\\d{2}$";
        public static final String REGEX_SABIT_PHONE_NUM = "/^(0)([2348]{1})([0-9]{2})\\s?([0-9]{3})\\s?([0-9]{2})\\s?([0-9]{2})$/";
        public static final String REGEX_NATIONALITY_ID = "^[1-9]{1}[0-9]{9}[02468]{1}$\n";
        public static final String REGEX_BIRTHDATE = "/^([1-9]|[12][0-9]|3[01])(|\\/|\\.|\\-|\\s)?(0[1-9]|1[12])\\2(19[0-9]{2}|200[0-9]|201[0-8])$/\n";
        public static final String REGEX_EMAIL = "^\\w+(\\.\\w+)*@\\p{javaLowerCase}{2,12}+(\\.\\p{javaLowerCase}{2,6})+$";
        public static final String REGEX_PASSWORD = "((?=.*[a-z])(?=.*d)(?=.*[A-Z]).{6,16})";
        public static final String REGEX_WEBSITE = "^(w{3}\\.)?[^.]+(\\.\\p{javaLowerCase}{2,12})+$";
        public static final String REGEX_CORPORATE_EMAIL = "email.split(\"@\")[0].equals(website)";
    }

    public Sort getSortByDirection(Short sortDirection, String propName) {

        if (sortDirection == null || sortDirection < 0) return Sort.by(Sort.Direction.DESC, propName);
        else return Sort.by(Sort.Direction.ASC, propName);
    }

    public ResponseEntity<?> getResponseEntity(Result result){
        if(result.isSuccess()){
            return ResponseEntity.ok(result);
        }else {
            return ResponseEntity.badRequest().body(result);
        }
    }

}
