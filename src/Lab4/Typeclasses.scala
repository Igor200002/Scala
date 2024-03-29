package Lab4

object Typeclasses {

  // a) Определите тайп-класс Reversable, который представляет в обратном порядке значения.

  trait Reversable[T]{
    def reverse (a:T):T//шаблон
  }

  object Reversable {
    def reverse[T: Reversable](a: T): T = implicitly[Reversable[T]].reverse(a) //неявный параметр


    // b) Реализуйте функцию Reverse для String.
    implicit object ReversableForString extends Reversable[String] {//указываем, какой неявный параметр брать
      def reverse(a: String): String = a.reverse
    }
  }
  // примените тайп-класс-решение из пункта (a) здесь
  def testReversableString(str: String): String = Reversable.reverse(str)//Класс.метод класса(объект)
  // c) Определите тайп-класс Smash таким образом чтобы в нем была функция smash, которая выполняет операцию со значениями одного типа.

  trait Smash[T]{
    def smash (a:T,b:T):T//шаблон
  }

  object Smash {
    def smash[T: Smash](a: T, b: T): T = implicitly[Smash[T]].smash(a, b)//неявный параметр

    // d) Реализуйте  функции Smash для типа Int и Double.
    //    Используйте сложение для типа Int у умножение для типа Double.
    implicit object SmashForInt extends Smash[Int] {//указываем неявный параметр
      def smash(a: Int, b: Int): Int = a + b
    }

    implicit object SmashForDouble extends Smash[Double] {//указываем неявный параметр
      def smash(a: Double, b: Double): Double = a * b
    }

    // e) Реализуйте функцию Smash для типа String. Необходимо выполнить конкатенацию строк, которые будут получены в качестве параметра.
    implicit object SmashForString extends Smash[String] {//указываем неявный параметр
      def smash(a: String, b: String): String = a + b
    }

  }
  // примените тайп-класс-решение из пункта (d) здесь
  def testSmashInt(a: Int, b: Int): Int = Smash.smash(a, b)//Класс.метод класса(объект)
  def testSmashDouble(a: Double, b: Double): Double = Smash.smash(a, b)//Класс.метод класса(объект)
  def testSmashString(a: String, b: String): String = Smash.smash(a, b)//Класс.метод класса(объект)

  // Реализуйте тестовые функции с выводом на экран проверки разработанных функций.
  def main(args: Array[String]): Unit = {
    println("Reverse")
    println("Abcde:" + testReversableString("Abcde"))
    println("Smash")
    println("Int (7+21): " + testSmashInt(7, 21))
    println("Double (1.3*2.5): " + testSmashDouble(1.3, 2.5))
    println("Dungeon (\"Dun\"+\"geon\"): " + testSmashString("Dun","geon"))
  }
}
