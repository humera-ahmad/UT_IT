package com.knoldus.FactorialAndPalindrome.Factorial.request

import org.scalatest.flatspec.AnyFlatSpec
import com.knoldus.FactorialAndPalindrome.Factorial.validator.FactorialValidator
import org.mockito.MockitoSugar.{mock, when}

class FactorialImplTest extends AnyFlatSpec {

  val mockedFactorialValidator: FactorialValidator= mock[FactorialValidator]

  "Factorial" should "pass" in {
    val factorialImpl = new FactorialImpl(mockedFactorialValidator)
    when(mockedFactorialValidator.isValidNumber(5)) thenReturn true
    val result = factorialImpl.getFactorial(5)
    assertResult(120)(result)
  }

  it should "not be negative" in {
    val factorialImpl = new FactorialImpl(mockedFactorialValidator)
    when(mockedFactorialValidator.isValidNumber(-5)) thenReturn false
    val result = factorialImpl.getFactorial(-5)
    assertResult(-1)(result)
  }

}
