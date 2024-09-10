package candychat.com.demo.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorReasonDTO {
    private String message;
    private String code;
    private Boolean isSuccess;
    private HttpStatus httpStatus;


}
