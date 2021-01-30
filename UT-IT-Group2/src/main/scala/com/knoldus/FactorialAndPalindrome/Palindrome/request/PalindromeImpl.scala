package com.knoldus.FactorialAndPalindrome.Palindrome.request

import com.knoldus.FactorialAndPalindrome.Palindrome.validator.PalindromeValidator
import com.knoldus.FactorialAndPalindrome.Utility.UtilityPalindrome

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
