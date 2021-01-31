package com.knoldus.validator
import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Company
import com.knoldus.request.CompanyImpl
import org.scalatest.flatspec.AnyFlatSpec

class CompanyValidatorIntegrationTest extends AnyFlatSpec {
  val companyReadDto = new CompanyReadDto
  val emailValidator = new EmailValidator
  val companyValidator = new CompanyValidator(companyReadDto, emailValidator)
  val companyImpl = new CompanyImpl(companyValidator)


  "company" should "return: already exists" in {
    val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")
    val result = companyValidator.companyIsValid(knoldusCompany)
    assert(!result)
  }

  it should "return 'invalid email id'" in {
    val philipsCompany: Company = Company("Philips", "abc", "Noida")
    val result = companyValidator.companyIsValid(philipsCompany)
    assert(!result)
  }

  it should "return 'invalid email id and company already exists'" in {
    val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail", "Noida")
    val result = companyValidator.companyIsValid(knoldusCompany)
    assert(!result)
  }

  it should "return 'valid'" in {
    val knoldusCompany: Company = Company("tcs", "tcs@gmail.com", "Noida")
    val result = companyValidator.companyIsValid(knoldusCompany)
    assert(result)
  }

}
