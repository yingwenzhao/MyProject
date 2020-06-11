package constants;

import lombok.Getter;

@Getter
public enum ScheduleStatusEnum {

    INIT("INIT","初试状态"),

    RUN("RUN","运行状态"),

    WAIT_RETRY("WAIT_RETRY","等待重试状态"),

    SUCCESS("SUCCESS","成功状态"),

    STOP("STOP","终止状态"),
    ;


    private String code;
    private String message;

    ScheduleStatusEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
