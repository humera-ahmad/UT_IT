package com.knoldus.request

import com.knoldus.models.Company
import com.knoldus.validator.CompanyValidator

class CompanyImpl(companyValidator: CompanyValidator) {

  def createCompany(company: Company): String = {
    if (companyValidator.companyIsValid(company)) company.name
    else ""
  }
}
