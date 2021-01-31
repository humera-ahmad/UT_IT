package com.knoldus.FactorialAndPalindrome.request

import com.knoldus.FactorialAndPalindrome.Utility.UtilityFactorial
import com.knoldus.FactorialAndPalindrome.validator.FactorialValidator

class FactorialImpl(factorialValidator: FactorialValidator) extends UtilityFactorial {

  def getFactorial(number: Int): Int={
    if (factorialValidator.isValidNumber(number: Int)){
      var sum = 1
      for (increment <- 1 to number) {
        sum = sum * increment
      }
      sum
    }
    else
      -1
  }
}
