package com.knoldus.password.validator

class PasswordValidator{
  def isValidPassword(password: String): Boolean = password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.\\S)(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$") && password != null
}
