package com.knoldus.FactorialAndPalindrome.request

import com.knoldus.FactorialAndPalindrome.Utility.UtilityPalindrome
import com.knoldus.FactorialAndPalindrome.validator.PalindromeValidator

class PalindromeImpl(palindromeValidator: PalindromeValidator) extends UtilityPalindrome {
  val success = "It is a Palindrome number"
  val failed = "Not a Palindrome number"
  def getDigit(number: Int): String ={
    if (palindromeValidator.isValidpalindrome(number))
      success
    else
      failed

  }

}
