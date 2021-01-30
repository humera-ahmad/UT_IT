package com.knoldus.validator

import com.knoldus.models.Company
import com.knoldus.db.CompanyReadDto

class CompanyValidator(companyReadDto: CompanyReadDto,validateEmail: EmailValidator) {

  def companyIsValid(company: Company): Boolean = {
    if (companyReadDto.getCompanyByName(company.name).isEmpty && validateEmail.emailIdIsValid(company.emailId))
      true
    else
      false
  }
}