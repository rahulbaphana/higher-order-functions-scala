package com.rahul.scala.prac.hof

import com.rahul.scala.prac.hof.HigherOrderFunctions._
import org.scalatest.{Matchers, WordSpec}

class HigherOrderFunctionsTest extends WordSpec with Matchers {

  "A higher order function" should {
    "curry transform" should {
      "add(a,b) to add(a)(b)" in {
        def add(a: Int, b: Int): Int = a + b

        def incrementByOne = curry(add)(1)

        incrementByOne(2) shouldBe 3
        incrementByOne(3) shouldBe 4
      }

      "greet(msg, name) to greet(msg)(name)" in {
        def greet(msg: String, name: String): String = s"$msg $name"

        def hiGreeter = curry(greet)("Hi")

        hiGreeter("John") shouldBe "Hi John"
        hiGreeter("Samuel") shouldBe "Hi Samuel"
      }
    }

    "compose transform" should {
      """to combine "incrementByOne(a: Int): Int" and "printResult(n: Int): String" functions to take input of incrementByOne(..) and output of printResult(..)""" in {
        def incrementByOne(a: Int): Int = a + 1
        def printResult(n: Int): String = s"The result is: $n"

        def incrementWithResult = compose(incrementByOne, printResult)

        incrementWithResult(4) shouldBe "The result is: 5"
        incrementWithResult(5) shouldBe "The result is: 6"
        incrementWithResult(10) shouldBe "The result is: 11"
      }
    }

    "uncurry transform" should {
      "add(a)(b) to add(a,b)" in {
        def add(a: Int)(b: Int) = a + b

        def unCurriedAdd = uncurry(add)

        unCurriedAdd(1, 2) shouldBe 3
        unCurriedAdd(4, 1) shouldBe 5
        unCurriedAdd(5, 2) shouldBe 7
      }

      "greet(msg)(name) to greet(msg, name)" in {
        def greet(msg: String)(name: String) = s"${msg} ${name}"

        def unCurriedGreet = uncurry(greet)

        unCurriedGreet("Hi", "John") shouldBe "Hi John"
        unCurriedGreet("Hi", "Samuel") shouldBe "Hi Samuel"
      }
    }

    "isSorted" should {
      "answer if array is sorted as per comparator passed to it" in {
        isSorted(Array(11, 45, 12, 60, 5, 1, 44), (a:Int, b:Int) => a < b) shouldBe false
        isSorted(Array(1, 2, 3, 4, 5, 6, 7), (a:Int, b:Int) => a < b) shouldBe true
        isSorted(Array("A", "E", "B", "F"), (a:String, b:String) => a < b) shouldBe false
        isSorted(Array("A", "B", "E", "F"), (a:String, b:String) => a < b) shouldBe true
      }
    }

    "calculate" should {
      "factorial using tail-recursion" in {
        factorial(0) shouldBe 1
        factorial(3) shouldBe 6
        factorial(2) shouldBe 2
        factorial(5) shouldBe 120
      }
    }
  }
}
