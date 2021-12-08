package Lab1

/*
 * 
 a) Создать класс Animal, который имеет следующие поля:
 *      - name: String (название)
 *      - species: String (вид)
 *      - food: String
 * class Animal (val name: String,val species: String,val food: String)
 *    Синтаксис: class MyClass(val publicField: Int, privateField: String) {
 *              // остальные поля и методы
 *            }
 *   d) Переопределите ваш класс Animal как трейт и создайте объекты класса-образца для Mammals, Birds и Fishs.
 *    Вам все еще нужно поле `species`?
 */
trait Animal {
  val name: String
  val food: Food

  /*
 * c) Добавьте следующие метод в Animals:
 *      def eats(food: String): Boolean
 *
 *     который проверяет ест ли животное определенную пищу
 *
 */
  def eats(food: Food): Boolean = food == this.food
}
case class Mammal(name: String, food: Food, weight: Int) extends Animal
case class Fish(name: String, food: Food)                extends Animal
case class Bird(name: String, food: Food)                extends Animal
 /*
 * b) Создайте объект-компаньон для класса Animal и добавьте следующие сущности как поля:
 *      - cat, mammal, meat
 *      - parrot, bird, vegetables
 *      - goldfish, fish, plants
 * 
 *    Синтаксис: object MyClass {
 *              // статические поля и методы
 *            }
 */
 object Animal{
   /* e) Добавьте следующие функции в объект-компаньон Animal:
*      def knownAnimal(name: String): Boolean  // true если это имя одного из трех животных из (b)
*      def apply(name: String): Option[Animal] // возвращает одно из трех животных в соответствии с именем (Some) или ничего (None), см. ниже
*/
   def knownAnimal(name: String): Boolean = name == "cat" | name ==  "parrot"| name == "goldfish"
   def apply(name: String): Option[Animal] = name match{
     case "cat" => Some(Mammal("cat", Meat, 4))
     case "parrot" => Some(Bird("parrot", Vegetables))
     case "goldfish" => Some(Fish("goldfish", Plants))
     case _ => None
   }
 }




 /* f) Создайте трейт Food со следующими классами-образцами:
 *      - Meat
 *      - Vegetables
 *      - Plants
 *   и добавьте это в определение Animal. Так же добавьте объект-компаньон с методом apply():
 *      def apply(food: String): Option[Food]
 */
 trait Food
case object Meat       extends Food
case object Vegetables extends Food
case object Plants     extends Food
object Food{
  def apply(food: String): Option[Food] = food match{
    case "Meat" => Some(Meat)
    case "Vegetables" => Some(Vegetables)
    case "Plants" => Some(Plants)
    case _ => None
  }

  def main(args: Array[String]): Unit = {
    println(Animal.knownAnimal("cat"))
    println(Animal.knownAnimal("caty"))

    println(Animal.apply("cat"))
    println(Animal.apply("Caty"))

    println(Food.apply("Meat"))
    println(Food.apply("Korm"))
  }
}

