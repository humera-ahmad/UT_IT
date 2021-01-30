package com.knoldus.request

import com.knoldus.validator.EmployeeValidator
import com.knoldus.models.{Company, Employee}
import org.scalatest.flatspec.AnyFlatSpec
import org.mockito.MockitoSugar.{mock, when}

class EmployeeImplTest extends AnyFlatSpec {

  val mockedEmployeeValidator: EmployeeValidator = mock[EmployeeValidator]
  val wiproEmployee: Employee = Employee("Klaus","Mickelson",30,40000,"Software Trainee","Wipro","niklaus@wipro.com")
  val philipsEmployee: Employee = Employee("Stefan","Salvatore",19,50000.00,"Associate software engineer","Philips", "philips123@gmail.com")
  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")

  "Employee's implementation" should "pass " in {
    val employeeImpl = new EmployeeImpl(mockedEmployeeValidator)
    when(mockedEmployeeValidator.employeeIsValid(philipsEmployee)) thenReturn true
    val result = employeeImpl.createEmployee(philipsEmployee)
    assert(result.isDefined)
  }

  "Employee" should "be not valid" in {
    val employeeImpl = new EmployeeImpl(mockedEmployeeValidator)
    when(mockedEmployeeValidator.employeeIsValid(wiproEmployee)) thenReturn false
    val result = employeeImpl.createEmployee(wiproEmployee)
    assert(result.isEmpty)
  }
}
