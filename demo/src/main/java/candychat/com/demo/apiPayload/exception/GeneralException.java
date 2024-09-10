package candychat.com.demo.apiPayload.exception;

import candychat.com.demo.apiPayload.code.BaseErrorCode;
import candychat.com.demo.apiPayload.code.ErrorReasonDTO;
import lombok.Getter;

@Getter
public class GeneralException extends RuntimeException{

    private BaseErrorCode code;

    public GeneralException(String message) {
        super(message);
        this.code = null;
    }

    public GeneralException(BaseErrorCode code) {
        super(code.getReason().getMessage());
        this.code = code;
    }

    public ErrorReasonDTO getErrorReason(){
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus(){
        return this.code.getReasonHttpStatus();
    }
}
