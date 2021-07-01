package com.project.jpa.exceptions;

import io.micronaut.http.HttpStatus;

public class ResourceConflictException extends ServiceException {
  private static final long serialVersionUID = 100318l;

  public ResourceConflictException(String errorMessage) {
    super(HttpStatus.BAD_REQUEST, errorMessage);
  }
}
