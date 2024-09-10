package candychat.com.demo.apiPayload.code.status;

import candychat.com.demo.apiPayload.code.BaseErrorCode;
import candychat.com.demo.apiPayload.code.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    // Common results
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),



    // Exception handling test
    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP4001", "에러 핸들링 테스트"),

    // Member
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "MEMBER001", "Member not found"),
    MEMBER_ALREADY_EXISTS(HttpStatus.CONFLICT, "MEMBER002", "Member already exists"),

    // Couple
    COUPLE_NOT_FOUND(HttpStatus.NOT_FOUND, "COUPLE001", "Couple not found"),
    COUPLE_ALREADY_EXISTS(HttpStatus.CONFLICT, "COUPLE002", "Couple already exists"),

    //Date
    DATE_NOT_FOUND(HttpStatus.NOT_FOUND, "DATE001", "Date not found"),
    DATE_INVALID(HttpStatus.BAD_REQUEST, "DATE002", "Invalid date"),

    // Photo
    PHOTO_NOT_FOUND(HttpStatus.NOT_FOUND, "PHOTO001", "Photo not found"),
    PHOTO_UPLOAD_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "PHOTO002", "Failed to upload photo"),

    // Conversation
    CONVERSATION_NOT_FOUND(HttpStatus.NOT_FOUND, "CONVERSATION001", "Conversation not found"),
    CONVERSATION_SAVE_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "CONVERSATION002", "Failed to save conversation"),

    // Emoji
    EMOJI_NOT_FOUND(HttpStatus.NOT_FOUND, "EMOJI001", "Emoji not found"),
    EMOJI_INVALID(HttpStatus.BAD_REQUEST, "EMOJI002", "Invalid emoji");




    private final HttpStatus httpStatus;
    private final String code;
    private final String message;


    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build()
                ;
    }
}
