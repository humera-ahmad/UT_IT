package com.knoldus.request

import com.knoldus.models.Employee
import com.knoldus.validator.EmployeeValidator

class EmployeeImpl(employeeValidator: EmployeeValidator) {

  def createEmployee(employee: Employee): String = {
    if (employeeValidator.employeeIsValid(employee))
      employee.companyName
    else ""
  }
}
