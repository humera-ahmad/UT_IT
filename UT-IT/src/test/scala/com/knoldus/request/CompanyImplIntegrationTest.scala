package com.knoldus.request

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Company
import com.knoldus.validator.{CompanyValidator, EmailValidator}
import org.scalatest.flatspec.AnyFlatSpec

class CompanyImplIntegrationTest extends AnyFlatSpec {
  val companyReadDto = new CompanyReadDto
  val companyValidator = new CompanyValidator(companyReadDto,emailValidator)
  val companyImpl = new CompanyImpl(companyValidator)
  val emailValidator = new EmailValidator

  "Company" should "not get created as it already exists" in {
    val result =  companyImpl.createCompany(companyReadDto.knoldusCompany)
    assert(result!="knoldusCompany")
  }

  it should "not get created as email id is invalid" in {
    val knoldusCompany: Company = Company("Knoldus", "abc.com", "Noida")
    val result =  companyImpl.createCompany(knoldusCompany)
    assert(result.isEmpty)
  }

  it should "not get created as email id is invalid and company already exists" in {
    val knoldusCompany: Company = Company("Knoldus", "gmail.inc", "Noida")
    val result =  companyImpl.createCompany(knoldusCompany)
    assert(result.isEmpty)
  }
}

