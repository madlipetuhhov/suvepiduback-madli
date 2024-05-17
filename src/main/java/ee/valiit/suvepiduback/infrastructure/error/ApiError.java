package ee.valiit.suvepiduback.infrastructure.error;

import lombok.Data;

@Data
public class ApiError {
    private String message;
    private Integer errorCode;
}

