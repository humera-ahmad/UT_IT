package com.knoldus.FactorialAndPalindrome.Factorial.request

import com.knoldus.FactorialAndPalindrome.Factorial.validator.FactorialValidator
import com.knoldus.FactorialAndPalindrome.Utility.UtilityFactorial

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
