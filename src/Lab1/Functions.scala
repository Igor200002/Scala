package Lab1

/** Напишите отдельные функции, решающие поставленную задачу.
 *
 * Синтаксис:
 * // метод
 * def myFunction(param0: Int, param1: String): Double = // тело
 *
 * // значение
 * val myFunction: (Int, String) => Double (param0, param1) => // тело
 */

object Functions {

  /* a) Напишите функцию, которая рассчитывает площадь окружности
   *    r^2 * Math.PI
   */
  val fA: (Double) => Double = r => {
    r * r * Math.PI
  }


  // примените вашу функцию из пункта (a) здесь, не изменяя сигнатуру
  def testCircle(r: Double): Double = fA(r)


  /* b) Напишите карированную функцию которая рассчитывает площадь прямоугольника a * b.
   */
  def fB(a: Double)(b: Double): Double = a * b


  // примените вашу функцию из пукта (b) здесь, не изменяя сигнатуру
  def testRectangleCurried(a: Double, b: Double): Double = fB(a)(b)


  // c) Напишите не карированную функцию для расчета площади прямоугольника.
  def fC(a: Double, b: Double): Double = a * b


  // примените вашу функцию из пункта (c) здесь, не изменяя сигнатуру
  def testRectangleUc(a: Double, b: Double): Double = fC(a, b)

  def main(args: Array[String]): Unit = {
    println("testCircle = " + testCircle(7))
    println("testRectangleCurried = " + testRectangleCurried(4, 3.5))
    println("testRectangleUc = " + testRectangleUc(3.5, 8))

  }
}
