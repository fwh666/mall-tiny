package com.macro.mall.tiny.modules.xd.enums;
/**
 * @author fuwenhao
 * @createDate 2024/1/30 18:37
 * @Description 
 **/
public enum DeleteEnum {
    NOT_DELETE(0, "未删除"),
    DELETED(1, "已删除");

    private Integer code;
    private String message;

    DeleteEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static DeleteEnum getByCode(Integer code) {
        for (DeleteEnum deleteEnum : DeleteEnum.values()) {
            if (deleteEnum.getCode().equals(code)) {
                return deleteEnum;
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
