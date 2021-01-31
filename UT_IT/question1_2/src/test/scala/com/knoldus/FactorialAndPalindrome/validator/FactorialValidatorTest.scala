package com.knoldus.FactorialAndPalindrome.validator

import org.scalatest.flatspec.AnyFlatSpec

class FactorialValidatorTest extends AnyFlatSpec {

  val numberValidator= new FactorialValidator

  "Number" should "is correct" in {
    val result = numberValidator.isValidNumber(5)
    assert(result)
  }

  "Number" should "be positive, you entered negative number" in {
    val result = numberValidator.isValidNumber(-5)
    assert(!result)
  }

}
