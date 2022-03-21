package com.hhyusein.gstore.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.CONFLICT;

@ResponseStatus(CONFLICT)
public class DuplicateRecordException extends RuntimeException {

    public DuplicateRecordException(String message) {
        super(message);
    }
}
