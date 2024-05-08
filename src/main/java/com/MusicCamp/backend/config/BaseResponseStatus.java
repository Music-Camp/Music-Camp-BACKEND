package com.MusicCamp.backend.config;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum BaseResponseStatus {

    /** 전역예외 처리 에러코드*/
    GlOBAL_EXCEPTION(false,401, "전역 예외가 발생했습니다 log 확인."),

    /**
     * 1000 : 요청 성공
     */
    SUCCESS(true, 1000, "요청에 성공하였습니다.");

    private boolean isSuccess;
    private final int code;
    private final String message;
    private HttpStatus status;


    BaseResponseStatus(boolean isSuccess, int code, String message) { //BaseResponseStatus 에서 각 해당하는 코드를 생성자로 맵핑
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }

    BaseResponseStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    BaseResponseStatus(int code, String message, HttpStatus status) {
        this.code = code;
        this.message = message;
        this.status=status;
    }

}
