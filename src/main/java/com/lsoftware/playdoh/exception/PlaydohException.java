package com.lsoftware.playdoh.exception;

public class PlaydohException extends RuntimeException {

    public PlaydohException() {
    }

    public PlaydohException(String s) {
        super(s);
    }

    public PlaydohException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public PlaydohException(Throwable throwable) {
        super(throwable);
    }
}
