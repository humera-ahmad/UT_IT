package com.knoldus.password.request

import com.knoldus.password.validator.PasswordValidator
import org.scalatest.flatspec.AnyFlatSpec
import org.mockito.MockitoSugar.{mock, when}

class PasswordImplTest extends AnyFlatSpec{

  val mockedPasswordValidator: PasswordValidator = mock[PasswordValidator]
  val success = "Password is valid"
  val failing = "Password is invalid"

  "Password" should "be correct" in {
    val passwordImpl = new PasswordImpl(mockedPasswordValidator)
    when(mockedPasswordValidator.isValidPassword("MySQL@123")) thenReturn true
    val result = passwordImpl.getPassword("MySQL@123")
    assertResult(success)(result)
  }

  it should "not be correct because of spacing" in {
    val passwordImpl = new PasswordImpl(mockedPasswordValidator)
    when(mockedPasswordValidator.isValidPassword("MySQL @123")) thenReturn false
    val result = passwordImpl.getPassword("MySQL @123")
    assertResult(failing)(result)
  }

  it should "not be correct because there must be atleast one number" in {
    val passwordImpl = new PasswordImpl(mockedPasswordValidator)
    when(mockedPasswordValidator.isValidPassword("MySQL @123")) thenReturn false
    val result = passwordImpl.getPassword("MySQL @123")
    assertResult(failing)(result)
  }

  it should "not be correct because there must be atleast one lowercase" in {
    val passwordImpl = new PasswordImpl(mockedPasswordValidator)
    when(mockedPasswordValidator.isValidPassword("MYSQL@123")) thenReturn false
    val result = passwordImpl.getPassword("MYSQL@123")
    assertResult(failing)(result)
  }

  it should "not be correct because there must be atleast one uppercase character" in {
    val passwordImpl = new PasswordImpl(mockedPasswordValidator)
    when(mockedPasswordValidator.isValidPassword("scala2*56")) thenReturn false
    val result = passwordImpl.getPassword("scala2*56")
    assertResult(failing)(result)
  }

  it should "not be correct because there must be atleast one special character" in {
    val passwordImpl = new PasswordImpl(mockedPasswordValidator)
    when(mockedPasswordValidator.isValidPassword("MySQL56123")) thenReturn false
    val result = passwordImpl.getPassword("MySQL56123")
    assertResult(failing)(result)
  }

  it should "not be correct because there must be atleast 8 characters" in {
    val passwordImpl = new PasswordImpl(mockedPasswordValidator)
    when(mockedPasswordValidator.isValidPassword("Me@12")) thenReturn false
    val result = passwordImpl.getPassword("Me@12")
    assertResult(failing)(result)
  }

  it should "not be correct because there must be atmost 15 characters" in {
    val passwordImpl = new PasswordImpl(mockedPasswordValidator)
    when(mockedPasswordValidator.isValidPassword("MySQLscalajava@123")) thenReturn false
    val result = passwordImpl.getPassword("MySQLscalajava@123")
    assertResult(failing)(result)
  }
}
