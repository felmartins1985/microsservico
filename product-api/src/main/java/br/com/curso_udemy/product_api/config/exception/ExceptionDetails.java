package br.com.curso_udemy.product_api.config.exception;

import lombok.Data;

@Data
public class ExceptionDetails {
    private Integer status;
    private String message;

    public void setStatus(int value) {
    }

    public void setMessage(String message) {
    }
}
