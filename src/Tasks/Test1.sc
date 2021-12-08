import scala.math.BigInt
import BigInt.probablePrime
import scala.util.Random
import scala.language.postfixOps

//Ex1
println("Ex 1:")
var temp1 = 1
temp1+2
val temp2 = 2
temp2+2
//Ex2
println("Ex 2:")
"crazy"*3
//Ex3
println("Ex 3:")
10 max 2
//Ex4
println("Ex 4:")
BigInt(2) pow 1024
//Ex5
println("Ex 5:")
probablePrime(100, Random)
//Ex6
println("Ex 6:")
probablePrime(100, Random).toString(36)
//Ex7
println("Ex 7:")
val s = "String"
s.head
s(0)
s.last
s(s.length - 1)
//Ex8
println("Ex 8:")
// take: Selects the first n elements
s.take(2)
// drop: Selects all elements except first n ones
s.drop(2)
// takeRight: Selects the last n elements
s.takeRight(2)
// dropRight: Selects all elements except last n ones
s.dropRight(2)
//Ex9
println("Ex 9:")
def func9(n:Int): Int={ // can be done with some switch case variant?
  var s = 0
  if (n > 0) s = 1
  else if (n == 0) s = 0
  else s = -1
  s
}
println(func9(8))
println(func9(0))
println(func9(-4221))
//Ex10
println("Ex 10:")
val empty= {}
//Ex11
println("Ex 11:")
for(i<- 10 to 0 by -1) println(i)
//Ex12
println("Ex 12:")
def countdown(n:Int) = for(i <- n to 0 by -1) println(i)
countdown(10)
//Ex13
println("Ex 13:")
(for(i <- "Hello") yield i.toLong).product
//Ex14
println("Ex 14:")
def product(s:String) = s.map(c => c.toLong).product
println(product("Hello"))
//Мар представляет данные в виде структуры, продукт перемножение
//Ex15
println("Ex 15:")
def product(s:String, p:Long):Long = s.isEmpty match {
     case false => product(s.tail, p * s.head.toLong)
     case true => p
     }

def prod(s:String):Long = s.isEmpty match {
     case false => product(s, 1)
     case true => 0
     }
println(prod(""))
println(prod("Hello"))
//Ex16
println("Ex 16:")
def Sixteen(x: Double, n: Int): Double = {
  if(n==0) 1
  else if (n>0 && n%2 == 0) Sixteen(x,n/2) * Sixteen(x,n/2)
  else if (n>0 && n%2 == 1) x * Sixteen(x,n-1)
  else 1 / Sixteen(x, -n)
}
println(Sixteen(2,7))
//Ex17
println("Ex 17:")
def dub(number:Int): Int ={
  var num = number
  var s:Int = 0
  while(num>=10){
    if(num%10==((num/10)%10)){
      s=s+1
    }
    num=num/10
  }
  return s
}
def sum(m:Int, n:Int): Unit ={
  var summa:Int=0
  for(i<-m to n){
    if (dub(i)==0){
    summa=summa+i
    }
  }
  println(summa)
}
sum(10,20)
///
def listPrinter(n: List[Any]){
  for (i <- n){
    print(i + ", ")
  }
}
//Ex18
println("Ex 18:")
var func18_ans: List[Any] = List()
def func18(n: List[Any]): List[Any]={
  for (i <- n){
    if (i.isInstanceOf[Int]) func18_ans = func18_ans :+ i
    else (func18(i.asInstanceOf[List[Any]]))
  }
  func18_ans
}

def func18Printer(n: List[Any]){
  var printable = func18(n)
  println(printable)
}
func18Printer(List(List(1, 1), 2, List(3, List(5, 8))))


//Ex19
println("Ex 19:")
def compose(n: Int): Boolean = {
  var t_temp19:Boolean=true
  for (i <- 2 to n-1) {
    if(n%i==0){
      t_temp19= false
    }
  }
  return t_temp19
}
println(compose(3))
def divider(n:Int): Int ={
  var temp19 = 0
  for (i<-1 to n){
      if(n%i==0&&compose(i)==true){
        temp19=i
      }
  }
  return temp19
}
println(divider(15))
def sum19(n:Int): Unit ={
  var sub_sum19 = 0
  var sub_n=n
  while(sub_n>10){
    sub_sum19=sub_sum19+(sub_n%10)
    sub_n=sub_n/10
  }
  println(sub_sum19+sub_n)
}
sum19(divider(15))

//Ex20
println("Ex 20:")
def func20(n: List[Any], k: Int){
  var ans: List[Any] = List()
  for (i <- n){
    for (reps <- 1 to k){
      ans = ans :+ i
    }
  }
  println(ans)
}
func20(List(1,2,5,7,9),3)
//Ex21
println("Ex 21:")
def gcd(m: Long, n: Long): Long ={//наибольший общий делитель, которое делится на m и n без остатка.
  if (n == 0) m
  else gcd(n, m % n)
}
def func21(m: Long, n: Long): Long ={//наименшее общее кратное по формуле
  m / gcd(m,n) * n
}
println(func21(35,21))
//Ex22
println("Ex 22:")
def func22(n: List[Any], delets: Int){
  var ans: List[Any] = List()
  var counter = 0
  for (i <- n){
    counter += 1
    if (counter < delets) ans = ans :+ i
    else counter = 0

  }
  println(ans)
}
func22(List(1,3,4,5,2,3), 3)
//Ex23
println("Ex 23:")
def fact(n:Int): Int ={
  var ans = 1
  for (i <- 1 to n){
    ans *= i
  }
  ans
}
def func23(n: Int, k: Int): Int ={
  if (k > n) -1
  else {
    fact(n) / fact(n-k)
  }
}
func23(4,2)
//Ex24
println("Ex 24:")
def ex24(arr: List[Any], n: Int): Unit = {
  //var arr:List[Any] = List(1,2,3,4,5,6,7,8,9,0)
  //var n: Int = readLine("Get a number: ").toInt
  if(n>0) {
    def left(l: List[Any]): List[Any] = {
      l.takeRight(l.length - n) ++ l.take(n)
    }
    println(left(arr))
  }else {
    def right(r: List[Any]): List[Any] = {
      r.takeRight(-n) ++ r.take(r.length + n)
    }

    println(right(arr))
  }
}
ex24(List(1,2,3,4,5,6,7,8,9,0), 3)
//Ex25
println("Ex 25:")
def perfect(n: Int): Boolean ={//проверка на совершенность
  var summa = 0
  for (i <- 1 until n){
    if(n % i == 0) summa += i
  }
  summa == n
}
def func25(n: Int): Int ={//провчеряем все числа от 1 до н
  for (i <- 1 to n reverse){
    if (perfect(i)) return i
  }
  1
}
println(func25(7))
//Ex26
println("Ex 26:")
def Ex26(n: List[Any]){
  val indexlength = n.length - 1

  var even: List[Any] = List()
  var odd: List[Any] = List()

  for (i <- 0 to indexlength){
    if (i % 2 == 0) even = even :+ n(i)
    else odd = odd :+ n(i)
  }
  print("Chet:")
  listPrinter(even)
  print("Nechet:")
  listPrinter(odd)
}
Ex26(List(0,1,2,3,4,5,6,7,8,9))
//Ex27
println("Ex 27:")
def sumDigits(n: Int): Int ={//получаем сумму цифр числа
  var result = 0
  var num = n
  while (num > 0){
    result += num % 10
    num /= 10
  }
  result
}
def isPow(n: Int): Boolean ={//умножаем сумму цифр на себя до получения исходного числа
  var result = 1
  while (result < n && sumDigits(n) != 1){
    result *= sumDigits(n)
  }
  result == n
}
def func27(n: Int): Int ={
  for (i <- 1 until n reverse){
    if (isPow(i)) return i
  }
  -1
}
println(func27(81))

//Ex28
println("Ex 28:")
def func28(nn: List[Any]){
  val indexlength = nn.length - 1

  var n, s: List[Any] = List()

  for (i <- 0 to indexlength){
    n = n :+ nn(i).asInstanceOf[List[Any]](0)
    s = s :+ nn(i).asInstanceOf[List[Any]](1)
  }
  listPrinter(n)
  listPrinter(s)

}
func28(List(List(1,"one"), List(2,"two"), List(3,"three")))




