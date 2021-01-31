package com.knoldus.validator

import com.knoldus.db.EmployeeReadDto
import com.knoldus.models.Employee
import com.knoldus.request.EmployeeImpl
import org.scalatest.flatspec.AnyFlatSpec

class EmployeeValidatorIntegrationTest extends AnyFlatSpec {
  val employeeReadDto = new EmployeeReadDto
  val emailValidator = new EmailValidator
  val employeeValidator = new EmployeeValidator(employeeReadDto, emailValidator)
  val employeeImpl = new EmployeeImpl(employeeValidator)

  val wiproEmployee: Employee = Employee("Klaus", "Mickelson", 30,50000.00,"Software Trainee","Wipro","niklaus@wipro.com")
  val tcsEmployee: Employee = Employee("Matt", "Donavan", 30,30000.00,"Software Trainee","Tcs","tcstcs")
  val knoldusEmployee: Employee = Employee("Damon", "Salvatore", 22,70000.00,"Software Developer","Knoldus","damon@knoldus.com")

  "Employee" should "return: company is invalid" in{
    val result = employeeValidator.employeeIsValid(wiproEmployee)
    assert(!result)
  }

  it should "return: email id and company is invalid" in{
    val result = employeeValidator.employeeIsValid(tcsEmployee)
    assert(!result)
  }

  "Employee" should "return: company is valid" in{
    val result = employeeValidator.employeeIsValid(knoldusEmployee)
    assert(result)
  }

}
