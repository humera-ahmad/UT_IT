package com.knoldus.validator
import com.knoldus.db.EmployeeReadDto
import com.knoldus.models.Employee
import org.scalatest.flatspec.AnyFlatSpec
import org.mockito.MockitoSugar.{mock, when}

class EmployeeValidatorTest extends AnyFlatSpec {

  val wiproEmployee: Employee = Employee("Klaus", "Mickelson", 30,50000.00,"Software Trainee","Wipro","niklaus@wipro.com")
  val knoldusEmployee: Employee = Employee("Damon", "Salvatore", 22,70000.00,"Software Developer","Knoldus","damon@knoldus.com")
  val mockedEmployeeReadDto: EmployeeReadDto = mock[EmployeeReadDto]
  val mockedEmailValidator: EmailValidator = mock[EmailValidator]

  "Employee" should "return: exist as it is a valid employee" in{
    when(mockedEmployeeReadDto.getEmployeeByName(knoldusEmployee.companyName)) thenReturn Option(knoldusEmployee)
    when(mockedEmailValidator.emailIdIsValid(knoldusEmployee.emailId)) thenReturn true
    val employeeValidator= new EmployeeValidator(mockedEmployeeReadDto ,  mockedEmailValidator)
    val result=employeeValidator.employeeIsValid(knoldusEmployee)
    assert(result)
  }

  "Employee" should "return: company is invalid" in{
    when(mockedEmployeeReadDto.getEmployeeByName(wiproEmployee.companyName)) thenReturn None
    when(mockedEmailValidator.emailIdIsValid(wiproEmployee.emailId)) thenReturn true
    val employeeValidator= new EmployeeValidator(mockedEmployeeReadDto ,  mockedEmailValidator)
    val result=employeeValidator.employeeIsValid(wiproEmployee)
    assert(!result)
  }

  "Employee" should "return: email id is invalid" in{
    when(mockedEmployeeReadDto.getEmployeeByName(knoldusEmployee.companyName)) thenReturn None
    when(mockedEmailValidator.emailIdIsValid("xyz")) thenReturn false
    val employeeValidator= new EmployeeValidator(mockedEmployeeReadDto ,  mockedEmailValidator)
    val result=employeeValidator.employeeIsValid(knoldusEmployee)
    assert(!result)
  }

  "Employee" should "return: email id and company is invalid" in{
    when(mockedEmployeeReadDto.getEmployeeByName(wiproEmployee.companyName)) thenReturn None
    when(mockedEmailValidator.emailIdIsValid(wiproEmployee.emailId)) thenReturn false
    val employeeValidator= new EmployeeValidator(mockedEmployeeReadDto ,  mockedEmailValidator)
    val result=employeeValidator.employeeIsValid(wiproEmployee)
    assert(!result)
  }

}
