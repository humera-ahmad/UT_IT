package com.knoldus.request
import com.knoldus.db.EmployeeReadDto
import com.knoldus.models.Employee
import com.knoldus.validator.{EmailValidator, EmployeeValidator}
import org.scalatest.flatspec.AnyFlatSpec

class EmployeeImplIntegrationTest extends AnyFlatSpec {
  val employeeReadDto = new EmployeeReadDto
  val emailValidator = new EmailValidator
  val employeeValidator = new EmployeeValidator(employeeReadDto, emailValidator)
  val employeeImpl = new EmployeeImpl(employeeValidator)



  "Employee" should "exist" in {
    val damonEmployee: Employee = Employee("Damon", "Salvatore", 22,70000.00,"Software Developer","Knoldus","damon@knoldus.com")
    val result =  employeeImpl.createEmployee(damonEmployee)
    assert(result=="Knoldus")
  }

  it should "be invalid as company does not exist" in {
    val klausEmployee: Employee = Employee("Klaus","Mickelson",30,40000,"Software Trainee","Wipro","niklaus@wipro.com")
    val result =  employeeImpl.createEmployee(klausEmployee)
    assert(result.isEmpty)
  }

  it should "be invalid as email id is invalid" in {
    val DamonEmployee: Employee = Employee("Damon", "Salvatore", 22,70000.00,"Software Developer","Knoldus","damoncom")
    val result = employeeImpl.createEmployee(DamonEmployee)
    assert(result.isEmpty)
  }

  it should "be invalid as email id is invalid and company does not exists" in {
    val klausEmployee: Employee = Employee("Klaus","Mickelson",30,40000,"Software Trainee","Wipro","niklauswiprocom")
    val result =  employeeImpl.createEmployee(klausEmployee)
    assert(result.isEmpty)
  }
}
