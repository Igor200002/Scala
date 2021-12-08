package Lab3

import scala.annotation.tailrec

/** Напишите свои решения в тестовых функциях.
 *
 * Seq(1, 2) match {
 * case head +: tail => ???
 * case Nil          => ???
 * case s            => ???
 * }
 *
 * https://www.scala-lang.org/api/2.12.0/scala/collection/Seq.html
 */
// Примечание: напишите функции с хвостовой рекурсией

object Sequence {
  def main(arg: Array[String]): Unit = {
    println("a")
    println(testLastElement(Seq(1, 2, 3, 4)))
    println(testLastElement(Seq()))
    println(testLastElement(Seq(1)))
    println("b")
    println(testZip(Seq(1, 2), Seq(3, 4)))
    println(testZip(Seq(1), Seq(3, 4)))
    println(testZip(Seq(1, 2), Seq(3, 4, 5)))
    println("c")

    def f(n: Int): Boolean = n % 2 == 0

    println(testForAll(Seq(8, 2, 4, 6))(f))
    println(testForAll(Seq(1, 3, 5))(f))
    println("d")
    println(testPalindrome(Seq("a","b","a")))
    println(testPalindrome(Seq("a", "b", "b")))
    println("e")
    val n = Seq("One", "Two", "Three")

    def nf(in: String): Seq[Char] = in.toUpperCase.toSeq

    println(testFlatMap(n)(nf))


  }

  /* a) Найдите последний элемент Seq.
   *
   */
  @tailrec
  def LastElement[A](seq: Seq[A]): Option[A] = seq match {
    case last +: Nil => Some(last) //Если 1 элемент
    case _ +: tail => LastElement(tail) //Если много элементов
    case Nil => None //Если пустой
  }

  def testLastElement[A](seq: Seq[A]): Option[A] = LastElement(seq)

  /* b) Объедините две Seqs (то есть Seq(1, 2) и Seq(3, 4) образуют Seq((1, 3), (2, 4))) - если Seq длиннее игнорируйте оставшиеся элементы.
   *
   */
  def testZip[A](a: Seq[A], b: Seq[A]): Seq[(A, A)] = a.zip(b)

  /* c) Проверьте, выполняется ли условие для всех элементов в Seq.
   *
   */
  def testForAll[A](seq: Seq[A])(cond: A => Boolean): Boolean = seq.forall(cond)

  /* d) Проверьте, является ли Seq палиндромом
   *
   */
  def Palindrome[A](seq: Seq[A]): Boolean = seq.reverse == seq

  def testPalindrome[A](seq: Seq[A]): Boolean = Palindrome(seq)

  /* e) Реализуйте flatMap используя foldLeft.
   * flatMap преобразует каждый элемент коллекции по оределенному правилу
   * foldLeft
   */
  def testFlatMap[A, B](seq: Seq[A])(f: A => Seq[B]): Seq[B] = {
    def operation(out: Seq[B], in: A): Seq[B] = {
      var result = f(in)

      @tailrec
      def loop(output: Seq[B], input: Seq[B]): Seq[B] = input.length match {
        case 0 => output
        case _ => loop(output :+ input.head, input.tail)
      }

      loop(out, result)
    }

    seq.foldLeft(Seq.empty[B])(operation)
  }
}
