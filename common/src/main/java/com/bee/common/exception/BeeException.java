package com.bee.common.exception;

/**
 * @author jiangjunqing
 * @date 2019/11/12
 * @desc 全局异常
 */
public class BeeException extends RuntimeException {

    /**
     * 异常返回码,大于0时,返回给前端,为null时返回默认code(500)给前端
     */
    private Integer code;

    /**
     * 抛出异常的来源
     */
    private String source;

    public BeeException(String message, String source) {
        super(message);
        this.source = source;
    }

    public BeeException(String message, Integer code, String source) {
        super(message);
        this.source = source;
        this.code = code;
    }

    public BeeException(String source) {
        this.source = source;
    }

    public BeeException() {
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
