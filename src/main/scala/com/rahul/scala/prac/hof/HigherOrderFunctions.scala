package com.rahul.scala.prac.hof

import scala.annotation.tailrec

object HigherOrderFunctions {
  def curry[A,B,C](f: (A, B) => C): A => B => C = ???

  def compose[A,B,C](f: A => B, g: B => C): A => C = ???

  def uncurry[A,B,C](f: A => B => C): (A, B) => C = ???

  def isSorted[A](as: Array[A], f: (A,A) => Boolean): Boolean = ???

  def factorial(n:Int): Int = {
    @tailrec
    def go(num: Int, acc: Int): Int = ???

    go(n, 1)
  }
}
