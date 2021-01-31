package com.knoldus.db
import org.scalatest.flatspec.AnyFlatSpec

class CompanyReadDtoTest extends AnyFlatSpec{
  "Company" should "exist" in {
    val companyReadDto = new CompanyReadDto
    val result = companyReadDto.getCompanyByName("Philips")
    assert(result.isDefined)
  }

  it should "not exist" in {
    val companyReadDto = new CompanyReadDto
    val result = companyReadDto.getCompanyByName("TCS")
    assert(result.isEmpty)
  }

}
