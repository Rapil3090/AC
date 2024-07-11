package AC.exception;

import AC.type.ErrorCode;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AssetException extends RuntimeException {

    private ErrorCode errorCode;
    private String errorMessage;

    public AssetException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.errorMessage = errorCode.getDescription();
    }
}
