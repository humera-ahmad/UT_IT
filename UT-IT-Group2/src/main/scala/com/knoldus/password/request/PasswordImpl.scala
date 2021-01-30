package com.knoldus.password.request

import com.knoldus.password.validator.PasswordValidator

class PasswordImpl(passwordValidator: PasswordValidator) {
  val success = "Password is valid"
  val failing = "Password is invalid"

  def getPassword(password: String): String={
    if (passwordValidator.isValidPassword(password: String)) {
      success
    }
    else {
      failing
    }
  }
}
