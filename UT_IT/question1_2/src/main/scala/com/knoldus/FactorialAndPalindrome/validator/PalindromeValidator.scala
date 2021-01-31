package com.knoldus.FactorialAndPalindrome.validator

class PalindromeValidator{
  def isValidpalindrome(number: Int): Boolean = {
    var num: Int = number
    var remainder = 0
    var reverse = 0
    while (num > 0) {
      remainder = num % 10
      reverse = reverse * 10 + remainder
      num = num / 10
    }
    if (reverse == number) {
      true
    }
    else {
      false
    }
  }

}
