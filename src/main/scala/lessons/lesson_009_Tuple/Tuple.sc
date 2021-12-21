import scala.language.postfixOps

val tuple: (String, Int, Boolean) = ("Cat", 10, true)
val tuple3: Tuple3[String, Boolean, Int] = ("Cat", true, 10)


//val tuple2 = (1 -> "One", 2 -> "Two")
val t: Tuple2[Tuple2[Int, String], Boolean] = ((1 -> "One"), true)
val tuple2: ((Int, String), Boolean) = (1 -> "One", true)


tuple == tuple3

tuple2 == t

val animal = tuple._1
val weight = tuple._2
val vaccination = tuple._3


val (animal1, weight1, vaccination1) = tuple

// ** Распаковать не все компоненты Кортежа, пропустить не нужные
val (animal2, _, x) = tuple

// ** Сделать кортеж _1 при удовлетворении условия и
// ** второй компоненты _2 не удовлетворяющих
"Hello, World!".partition(_.isUpper)._2

// Упаковать два массива в одни массив с двумя кортежами
val symbols = Array('a, 'b, 'c)

val counts = Array(1, 14, 7, 8)

//?? Array((Symbol(a),1), (Symbol(b),14), (Symbol(c),7))
symbols zip counts

// Собрать в один массив и преобразовать в Map
symbols zip (counts) toMap

// Собрать массив в Tuple с автоматическим ИНДЕКСОМ
val days = Array(
	"Sunday",
	"Monday",
	"Tuesday",
	"Wednesday",
	"Thursday",
	"Friday",
	"Saturday"
)

days.zipWithIndex

for ((day, index) <- days.zipWithIndex) {
	println(s"$index is $day")
}