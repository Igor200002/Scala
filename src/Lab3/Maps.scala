package Lab3

/** Напишите вашу реализацию в тестовые функции.
 *
 * https://docs.scala-lang.org/overviews/collections/maps.html
 */
object Maps {


  case class User(name: String, age: Int)

  def main(arg: Array[String]): Unit = {
    println("USERS:")
    val users: Seq[User] = Seq(User("Jack", 12), User("Bob", 15), User("Jack", 10), User("Ann", 13), User("Ann", 15))
    println(testGroupUsers(users))
    println("ADAMS:")
    val adams = Map("A" -> User("Adam", 35), "B" -> User("Adam", 40), "C" -> User("Ann", 38), "D" -> User("Ally", 30), "E" -> User("Adam", 20))
    println(testNumberFrodos(adams))
    println(testUnderaged(adams))

  }

  /* a) В данной Seq[User] сгруппируйте пользователей по имени (`groupBy`) и вычислите средний возраст: `name -> averageAge`
   *    Вы можете реализовать ваше решение в теле тестовой функции. Не изменяйте сигнатуру.
   */
  //def testGroupUsers(users: Seq[User]): Map[String, Int] = users.map(User=>(User.name,User.age)).toMap//обращаем в карту
  // averageAge (users: Map[String, Int]) : Int = users.values.sum/users.size//получаем среднее значение
  def testGroupUsers(users: Seq[User]): Map[String, Int] = {
    def avg(xs: Seq[Int]) = xs.sum / xs.length //получаем  средний возраст

    users.groupBy(_.name).map { //группируем по имени и преобразуем в карту
      kv => (kv._1, avg(kv._2.map(_.age))) //определяем ключ и значение
    }
  }

  /* b) Дана `Map[String, User]` состоящая из имен пользователей `User`, сколько имен пользователей, содержащихся в Map, содержат подстроку "Adam"?
   *    Вы можете реализовать ваше решение в теле тестовой функции. Не изменяйте сигнатуру.
   */
  def testNumberFrodos(map: Map[String, User]): Int = map.count(_._2.name.contains("Adam"))

  /* c) Удалите всех пользователей возраст которых менее 35 лет.
   *    Вы можете реализовать ваше решение в теле тестовой функции. Не изменяйте сигнатуру.
   */
  def testUnderaged(map: Map[String, User]): Map[String, User] = map.filter(_._2.age >= 35)
}
