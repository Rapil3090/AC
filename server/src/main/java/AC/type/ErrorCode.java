package AC.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    INCOME_NOT_FOUND("지출을 찾을 수 없습니다"),
    EXPENSE_NOT_FOUND("수입을 찾을 수 없습니다"),
    INVALID_REQUEST("잘못된 요청입니다."),
    INTERNAL_SERVER_ERROR("내부 서버 오류가 발생했습니다.");

    private final String Description;

}
