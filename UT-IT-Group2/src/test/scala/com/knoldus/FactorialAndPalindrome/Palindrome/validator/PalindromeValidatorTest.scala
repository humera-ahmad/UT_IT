package com.knoldus.FactorialAndPalindrome.Palindrome.validator

import org.scalatest.flatspec.AnyFlatSpec

class PalindromeValidatorTest extends AnyFlatSpec {

  val palindromeValidator = new PalindromeValidator

  "Palindrome" should "be palindrome" in {
    val result = palindromeValidator.isValidpalindrome(323)
    assert(result)
  }

  it should "not be palindrome" in {
    val result = palindromeValidator.isValidpalindrome(32243)
    assert(!result)
  }
}
