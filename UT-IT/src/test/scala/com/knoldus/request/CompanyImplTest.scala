package com.knoldus.request

import com.knoldus.models.Company
import com.knoldus.validator.CompanyValidator
import org.scalatest.flatspec.AnyFlatSpec
import org.mockito.MockitoSugar.{mock, when}

class CompanyImplTest extends AnyFlatSpec {

  val mockedCompanyValidator: CompanyValidator = mock[CompanyValidator]
  val tcsCompany: Company = Company("tcs", "tcs@gmail.com", "Bangalore")
  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")


  "Company" should "already be present" in {
    val companyImpl = new CompanyImpl(mockedCompanyValidator)
    when(mockedCompanyValidator.companyIsValid(knoldusCompany)) thenReturn true
    val result = companyImpl.createCompany(knoldusCompany)
    assert(result.isDefined)
  }

  it should "not be present" in {
    val companyImpl = new CompanyImpl(mockedCompanyValidator)
    when(mockedCompanyValidator.companyIsValid(tcsCompany)) thenReturn false
    val result = companyImpl.createCompany(tcsCompany)
    assert(result.isEmpty)
  }

}
