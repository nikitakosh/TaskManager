package com.nikitakosh.TaskManager.exceptions;

public class NoSuchTaskException extends RuntimeException {
    public NoSuchTaskException(String cause) {
        super(cause);
    }
}
