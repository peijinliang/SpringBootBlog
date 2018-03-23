package com.blog.vo;

/**
 * Crete by Marlon
 * Create Date: 2018/3/23
 * Class Describe
 **/
public class ErrorMsg {

    private String key;
    private String value;

    public ErrorMsg(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ErrorMsg{" +
                       "key='" + key + '\'' +
                       ", value='" + value + '\'' +
                       '}';
    }
}
