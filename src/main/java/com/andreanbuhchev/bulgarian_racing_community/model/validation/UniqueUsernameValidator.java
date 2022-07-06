package com.andreanbuhchev.bulgarian_racing_community.model.validation;

import com.andreanbuhchev.bulgarian_racing_community.model.repository.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

  private UserRepository userRepository;

  public UniqueUsernameValidator(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {

    return userRepository.
        findByUsername(value).
        isEmpty();
  }
}
