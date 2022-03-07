package kodlamaio.CampProject.core.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
public class ApiError {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime dateTime;

    private HttpStatus httpStatus;

    private String message;

    private Map<?,?> errors;

    private Set<?> details;

    public ApiError(Map<?,?> errors){
        this.dateTime = LocalDateTime.now();
        this.httpStatus = HttpStatus.BAD_REQUEST;
        this.message = null;
        this.errors = errors;
        this.details = null;
    }

    public ApiError(String message,Map<?,?> errors,Set<?> details){
        this.dateTime = LocalDateTime.now();
        this.httpStatus = HttpStatus.BAD_REQUEST;
        this.message = message;
        this.errors = errors;
        this.details = details;
    }

    public ApiError(HttpStatus httpStatus,String message,Map<?,?> errors,Set<?> details){
        this.dateTime = LocalDateTime.now();
        this.httpStatus = httpStatus;
        this.message = message;
        this.errors = errors;
        this.details = details;
    }






}
