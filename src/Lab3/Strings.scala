package Lab3

/** Напишите ваши решения в тестовых функциях.
 *
 * https://www.scala-lang.org/api/2.12.3/scala/collection/immutable/StringOps.html
 */
object Strings {
  def main(args: Array[String]): Unit = {
    println(Uppercase("dungeon"))
    println(Interpolation("Igor", 21))
    println(Computation(5, 3))
    println(TakeTwo("Blue"))
  }


  /* a) Преобразуйте все символы типа Char в верхний регистр (не используйте заглавные буквы).
   *
   */
  def Uppercase(s: String): String = s.toUpperCase()

  def testUppercase(str: String): String = Uppercase(str)

  /* b) Вставьте следующие значения в строку:
   *       Hi my name is <name> and I am <age> years old.
   *
   */
  def Interpolation(name: String, age: Int): String = {
    return s"Hi my name is $name and I am $age years old."
  }

  def testInterpolations(name: String, age: Int): String = Interpolation(name, age)

  /* c) Добавьте два числа в следующую строку:
   *       Hi,
   *       now follows a quite hard calculation. We try to add:
   *         a := <value of a>
   *         b := <value of b>
   *
   *         result is <a + b>
   *
   *
   */
  def Computation(a: Int, b: Int): String = {
    val c = a + b
    return s"Hi,\n now follows a quite hard calculation. We try to add:\n a := $a\n b := $b\n result is $c"
  }

  def testComputation(a: Int, b: Int): String = Computation(a, b)

  /* d) Если длина строки равна 2, верните всю строку, иначе верните первые два символа строки.
   */
  def TakeTwo(s: String): String = {
    val l = s.length
    if (s == 2) {
      return s
    } else return s.take(2)
  }

  def testTakeTwo(str: String): String = TakeTwo(str)
}
