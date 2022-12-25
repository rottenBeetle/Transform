package com.rottenbeetle.transform.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseError {
    private Date timestamp;
    private int errorCode;
    private HttpStatus status;
    private String error;
    private String message;
}
