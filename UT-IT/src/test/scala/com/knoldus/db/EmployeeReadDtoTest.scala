package com.knoldus.db
import org.scalatest.flatspec.AnyFlatSpec

class EmployeeReadDtoTest extends AnyFlatSpec {
  "Employee's company" should "be present" in {
    val employeeReadDto = new EmployeeReadDto
    val result = employeeReadDto.getEmployeeByName("Knoldus")
    assert(result!=None)
  }

  it should "not be present" in {
    val employeeReadDto = new EmployeeReadDto
    val result = employeeReadDto.getEmployeeByName("TCS")
    assert(result==None)
  }
}
