package com.knoldus.FactorialAndPalindrome.request

import com.knoldus.FactorialAndPalindrome.validator.PalindromeValidator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AnyFlatSpec

class PalindromeImplTest extends AnyFlatSpec {

  val mockedPalindromedValidator: PalindromeValidator = mock[PalindromeValidator]
  val success = "It is a Palindrome number"
  val failed = "Not a Palindrome number"

  "Palindrome" should "return true" in {
    val palindromeImpl = new PalindromeImpl(mockedPalindromedValidator)
    when(mockedPalindromedValidator.isValidpalindrome(323)) thenReturn true
    val result = palindromeImpl.getDigit(323)
    assertResult(success)(result)
  }

  it should "return false" in {
    val palindromeImpl = new PalindromeImpl(mockedPalindromedValidator)
    when(mockedPalindromedValidator.isValidpalindrome(3222)) thenReturn false
    val result = palindromeImpl.getDigit(3222)
    assertResult(failed)(result)
  }

}
