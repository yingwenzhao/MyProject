package constants;


public enum SysCodeConstants {
    SUCCESS("000000", "受理成功"),


    EXCEPTIONS("999999","系统异常");

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String code;
    private String message;

    SysCodeConstants(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
