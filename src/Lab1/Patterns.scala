package Lab1

/** Напишите решение в виде функции.
  * 
  * Синтаксис:
  *   val a: Int = ???
  * 
  *   a match {
  *     case 0 => true
  *     case _ => false
  *   }
  */
object PatternMatching {

  sealed trait Hand
  case object Rock    extends Hand
  case object Paper   extends Hand
  case object Scissor extends Hand

  sealed trait Result
  case object Win  extends Result
  case object Lose extends Result
  case object Draw extends Result

  sealed trait Food
  case object Meat       extends Food
  case object Vegetables extends Food
  case object Plants     extends Food

   trait Animal {

    val name: String
    var food: Food
  }
  case class Mammal(name: String, var food: Food, weight: Int) extends Animal
  case class Fish(name: String, var food: Food)                extends Animal
  case class Bird(name: String, var food: Food)                extends Animal


  def main(args: Array[String]): Unit = {
    println("a")
    println(testIntToString(1))
    println(testIntToString(4))

    println("b")
    println(testIsMaxAndMoritz("max"))
    println(testIsMaxAndMoritz("Moritz"))
    println(testIsMaxAndMoritz("notMaxOrMortiz"))

    println("c")
    //println(testIsEven(1))
    //println(testIsEven(4))
    println(testIsEvenC(1))
    println(testIsEvenC(4))

    println("d")
    println(testWinsA(Rock, Paper))
    println(testWinsA(Scissor, Scissor))
    println(testWinsA(Paper, Rock))

    println("e")
    val mammal = Mammal("Human", Meat, 35)
    val leFishe = Fish("Carp", Vegetables)
    println(testExtractMammalWeight(mammal))
    println(testExtractMammalWeight(leFishe))

    println("f")
    println(testUpdateFood(leFishe).food)
    println(testUpdateFood(mammal).food)

  }

  /* a) Напишите функцию, которая ставит в соответствие числу строку слудеющим образом:
   * Если:
   *     1 => "it is one"
   *     2 => "it is two"
   *     3 => "it is three"
   *     иначе => "what's that"
   */
  def intToString(n: Int): String = n match {
    case 1 => "it is one"
    case 2 => "it is two"
    case 3 => "it is three"
    case _ => "what's that"
  }


  // примените вашу функцию из пункта (a) здесь, не изменяя сигнатуру
  def testIntToString(value: Int): String = intToString(value)

  /* b) Напишите функцию которая возвращает true если переменная `value` принимает значение:
   *     "max" или "Max
   *     "moritz" или "Moritz"
   */
  def isMaxAndMoritz(s: String): Boolean = s match {
    case "moritz" | "Moritz" | "max" | "Max"  => true
    case _ => false
  }


  // примените функции из пункта (b) здесь, не изменяя сигнатуру
  def testIsMaxAndMoritz(value: String): Boolean = isMaxAndMoritz(value)

  // c) Напишите функцию проверки является ли `value` четным 
  // def isEven(n: Int): Boolean = n % 2 == 0
  def isEvenC(n: Int): Boolean = n match {
    case n => n%2 == 0
    case _ => false
  }

  // примените функции из пункта (c) здесь, не изменяя сигнатуру
  // def testIsEven(value: Int): Boolean = isEven(value)
  def testIsEvenC(value: Int): Boolean = isEvenC(value)

  
  /* d) Напишите функцию, моделирующую игру в Камень ножницы бумага 
   *     1. камень побеждает ножницы
   *     2. ножницы побеждают бумагу
   *     3. бумага побеждает камень
   *    Выиграет ли игрок `a`?
   */
  def winsA(a: Hand, b: Hand): Result = (a, b) match {
    case (Scissor, Paper) | (Paper, Rock) | (Rock, Scissor) => Win
    case (Rock, Rock) | (Scissor, Scissor) | (Paper, Paper) => Draw
    case _ => Lose
  }

  // примените вашу функцию из пункта (d) здесь, не изменяя сигнатуру
  def testWinsA(a: Hand, b: Hand): Result = winsA(a,b)



  // Примечание: используйте определение Animals

  // e) Верните вес (weight: Int) объекта Mammal, иначе верните -1.
  def extractMammalWeight(animal: Animal): Int = animal match {
    case animal : Mammal => animal.weight
    case _ => -1
  }


  // примените функцию из пункта (e) здесь, не изменяйте сигнатуру
  def testExtractMammalWeight(animal: Animal): Int = extractMammalWeight(animal)


  // f) Измените поле еда объектов классов Fishes и Birds на Plants, класс Mammels оставьте неизмененным.
  def updateFood(animal: Animal): Animal = animal match{
    case animal : Mammal => animal
    case _ =>
      animal.food = Plants
      animal
  }


  // примените функцию из пункта (f) здесь, не изменяйте сигнатуру
  def testUpdateFood(animal: Animal): Animal = updateFood(animal)

}
