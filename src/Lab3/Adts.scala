package Lab3

import scala.util.Try

/** Реализуйте следующие функции.
 *
 * List(1, 2) match {
 * case head :: tail => ???
 * case Nil          => ???
 * case l            => ???
 * }
 *
 * Option(1) match {
 * case Some(a) => ???
 * case None    => ???
 * }
 *
 * Either.cond(true, 1, "right") match {
 * case Left(i)  => ???
 * case Right(s) => ???
 * }
 *
 * Try(impureExpression()) match {
 * case Success(a)     => ???
 * case Failure(error) => ???
 * }
 *
 * Try(impureExpression()).toEither
 *
 */
object Adts {
  def main(arg: Array[String]) = {
    println("a")
    println(GetNth(List(1, 2, 3, 4, 5), 2))
    println(GetNth(List(1), 2))
    println(GetNth(List(), 2))
    println("b")
    val b1: Option[Int] = Some(5)
    val b2: Option[Int] = None
    println(Double(b1))
    println(Double(b2))
    println("c")
    println(IsEven(2))
    println(IsEven(1))
    println("d")
    println(safeDivide(2, 0))
    println(safeDivide(10, 5))

    def badFunc(str: String): Int = str(0).toInt / 0

    def goodFunc(str: String): Int = str.toInt

    println(testGoodOldJava(goodFunc, "123"))
    println(testGoodOldJava(badFunc, "123"))
  }

  // a) Дан List[Int], верните элемент с индексом n
  def GetNth(list: List[Int], n: Int): Option[Int] = list match {
    case head :: tail => list.lift(n) //если голова==хвосту
    case Nil => None
    case list => list.lift(n)
  }

  // примените функцию из пункта (a) здесь, не изменяйте сигнатуру
  def testGetNth(list: List[Int], n: Int): Option[Int] = GetNth(list, n)

  // b) Напишите функцию, увеличивающую число в два раза.
  def Double(n: Option[Int]): Option[Int] = n match {
    case Some(n) => Some(n + n)
    case None => None

  }


  // примените функцию из пункта (b) здесь, не изменяйте сигнатуру
  def testDouble(n: Option[Int]): Option[Int] = Double(n)

  // c) Напишите функцию, проверяющую является ли число типа Int четным. Если так, верните Right. В противном случае, верните Left("Нечетное число.").
  def IsEven(n: Int): Either[String, Int] = n match {
    case n => if (n % 2 == 0) Right(n)
    else Left("Нечетное число.")
  }


  // примените функцию из пункта (c) здесь, не изменяйте сигнатуру
  def testIsEven(n: Int): Either[String, Int] = IsEven(n)


  // d) Напишите функцию, реализующую безопасное деление целых чисел. Верните Right с результатом или Left("Вы не можете делить на ноль.").
  /*def Div (a:Int, b:Int):Int=a/b*/
  def safeDivide(a: Int, b: Int): Either[String, Int] = {
    if (b == 0) Left("Вы не можете делить на ноль.")
    else Right(a / b)
  }


  // примените функцию из пункта (d) здесь, не изменяйте сигнатуру
  def testSafeDivide(a: Int, b: Int): Either[String, Int] = safeDivide(a, b)

  // e) Обработайте исключения функции с побочным эффектом вернув 0.
  def goodOldJava(impure: String => Int, str: String): Try[Int] =
    Try(impure(str)).recover {
      case _ => 0
    }

  // примените функцию из пункта (e) здесь, не изменяйте сигнатуру
  def testGoodOldJava(impure: String => Int, str: String): Try[Int] = goodOldJava(impure, str)

}
