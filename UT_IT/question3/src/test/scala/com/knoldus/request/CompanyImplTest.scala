package com.knoldus.request

import com.knoldus.models.Company
import com.knoldus.validator.CompanyValidator
import org.scalatest.flatspec.AnyFlatSpec
import org.mockito.MockitoSugar.{mock, when}

class CompanyImplTest extends AnyFlatSpec {

  val mockedCompanyValidator: CompanyValidator = mock[CompanyValidator]
  val tcsCompany: Company = Company("tcs", "tcs@gmail.com", "Bangalore")
  val wiproCompany: Company = Company("wipro", "wiprocom", "Bangalore")
  val philipsCompany: Company= Company("Philips", "philips123@gmail.com", "Noida")
  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")


  "Company" should "already present" in {
    val companyImpl = new CompanyImpl(mockedCompanyValidator)
    when(mockedCompanyValidator.companyIsValid(knoldusCompany)) thenReturn false
    val result = companyImpl.createCompany(knoldusCompany)
    assert(result=="")
  }

  it should "get created" in {
    val companyImpl = new CompanyImpl(mockedCompanyValidator)
    when(mockedCompanyValidator.companyIsValid(tcsCompany)) thenReturn true
    val result = companyImpl.createCompany(tcsCompany)
    assert(result=="tcs")
  }

  it should "not get created due to invalid email" in {
    val companyImpl = new CompanyImpl(mockedCompanyValidator)
    when(mockedCompanyValidator.companyIsValid(wiproCompany)) thenReturn false
    val result = companyImpl.createCompany(wiproCompany)
    assert(result=="")
  }

  it should "not get created due to invalid email and company already exists" in {
    val companyImpl = new CompanyImpl(mockedCompanyValidator)
    when(mockedCompanyValidator.companyIsValid(philipsCompany)) thenReturn false
    val result = companyImpl.createCompany(philipsCompany)
    assert(result=="")
  }

}
