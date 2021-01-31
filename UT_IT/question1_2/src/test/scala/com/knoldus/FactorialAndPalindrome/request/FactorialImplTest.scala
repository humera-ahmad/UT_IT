package com.knoldus.FactorialAndPalindrome.request

import com.knoldus.FactorialAndPalindrome.validator.FactorialValidator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AnyFlatSpec

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
