package com.knoldus.request

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Company
import com.knoldus.validator.{CompanyValidator, EmailValidator}
import org.scalatest.flatspec.AnyFlatSpec

class CompanyImplIntegrationTest extends AnyFlatSpec {
  val companyReadDto = new CompanyReadDto
  val emailValidator = new EmailValidator
  val companyValidator = new CompanyValidator(companyReadDto,emailValidator)
  val companyImpl = new CompanyImpl(companyValidator)

  "Company" should "not get created as it already exists" in {
    val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")
    val result =  companyImpl.createCompany(knoldusCompany)
    assert(result=="")
  }

  it should "not get created as email id is invalid" in {
    val knoldusCompany: Company = Company("Knoldus", "abc.com", "Noida")
    val result =  companyImpl.createCompany(knoldusCompany)
    assert(result=="")
  }

  it should "not get created as email id is invalid and company already exists" in {
    val knoldusCompany: Company = Company("Knoldus", "gmail.inc", "Noida")
    val result =  companyImpl.createCompany(knoldusCompany)
    assert(result=="")
  }

  "Company" should "get created" in {
    val tcsCompany: Company = Company("TCS", "tcs@gmail.com", "Noida")
    val result =  companyImpl.createCompany(tcsCompany)
    assert(result=="TCS")
  }
}

