package com.knoldus.db

import com.knoldus.models.Employee

import scala.collection.immutable.HashMap
class EmployeeReadDto {

  val knoldusEmployee: Employee = Employee("Damon", "Salvatore", 22,70000.00,"Software Developer","Knoldus","damon@knoldus.com")
  val philipsEmployee: Employee = Employee("Stefan","Salvatore",19,50000.00,"Associate software engineer","Philips", "philips123@gmail.com")
  val employees: HashMap[String, Employee] = HashMap("Knoldus" -> knoldusEmployee, "Philips" -> philipsEmployee)

  def getEmployeeByName(name: String): Option[Employee] = employees.get(name)

}
