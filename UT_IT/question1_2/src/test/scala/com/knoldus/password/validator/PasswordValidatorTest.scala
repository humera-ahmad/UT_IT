package com.knoldus.password.validator

import org.scalatest.flatspec.AnyFlatSpec

class PasswordValidatorTest extends AnyFlatSpec {

  val password= new PasswordValidator()

  "Password" should "have all necessary features" in {
    val result = password.isValidPassword("MySQL@123")
    assert(result)
  }

  it should "contain at least one Uppercase Character" in {
    val result = password.isValidPassword("scala2*56")
    assert(!result)
  }

  it should "contain at least one Lowercase Character" in{
    val result = password.isValidPassword("JAVA65%$")
    assert(!result)
  }

  it should "contain at least one number" in{
    val result = password.isValidPassword("Abcdefgh@")
    assert(!result)
  }

  it should "contain at least one Special Character" in{
    val result = password.isValidPassword("Abcde1234")
    assert(!result)
  }

  it should "contain minimum 8 Characters" in{
    val result= password.isValidPassword("Ai@48#")
    assert(!result)
  }

  it should "contain maximum 15 Characters" in{
    val result = password.isValidPassword("AbcdeFg@1234&56df")
    assert(!result)
  }

  it should "not contain any spaces" in{
    val result = password.isValidPassword("Abd @ 1234")
    assert(!result)
  }
}

