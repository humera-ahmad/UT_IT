package com.knoldus.validator

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Company
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AnyFlatSpec

class CompanyValidatorTest extends AnyFlatSpec {

  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")
  val tcsCompany: Company = Company("tcs", "tcs@gmail.com", "Bangalore")
  val wiproCompany: Company = Company("wipro", "abcd", "Bangalore")

  val mockedCompanyReadDto: CompanyReadDto = mock[CompanyReadDto]
  val mockedEmailValidator: EmailValidator = mock[EmailValidator]

  "Company" should "returned 'already exists'" in {
    when(mockedCompanyReadDto.getCompanyByName(knoldusCompany.name)) thenReturn Option(knoldusCompany)
    when(mockedEmailValidator.emailIdIsValid(knoldusCompany.emailId)) thenReturn true

    val companyValidator = new CompanyValidator(mockedCompanyReadDto,mockedEmailValidator)
    val result = companyValidator.companyIsValid(knoldusCompany)

    assert(!result)
  }

  it should "returned 'invalid email id'" in {
    when(mockedCompanyReadDto.getCompanyByName(wiproCompany.name)) thenReturn None
    when(mockedEmailValidator.emailIdIsValid(wiproCompany.emailId)) thenReturn false

    val companyValidator = new CompanyValidator(mockedCompanyReadDto,mockedEmailValidator)
    val result = companyValidator.companyIsValid(wiproCompany)

    assert(!result)
  }

  it should "be created successfully" in {
    when(mockedCompanyReadDto.getCompanyByName(tcsCompany.name)) thenReturn None
    when(mockedEmailValidator.emailIdIsValid(tcsCompany.emailId)) thenReturn true

    val companyValidator = new CompanyValidator(mockedCompanyReadDto, mockedEmailValidator)
    val result = companyValidator.companyIsValid(tcsCompany)

    assert(result)
  }
}