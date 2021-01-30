package com.knoldus.validator

import com.knoldus.db.EmployeeReadDto
import com.knoldus.models.Employee

class EmployeeValidator(employeeReadDto: EmployeeReadDto, validateEmail: EmailValidator) {

  def employeeIsValid(employee: Employee): Boolean = if (employeeReadDto.getEmployeeByName(employee.companyName).isDefined && validateEmail.emailIdIsValid(employee.emailId))
    true
  else
    false
}
