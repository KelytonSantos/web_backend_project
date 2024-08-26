package com.project.service.exceptions;

//@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Actor Not Found")
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Object id) {
        super("Resource Not Found. Id " + id);
    }
}
