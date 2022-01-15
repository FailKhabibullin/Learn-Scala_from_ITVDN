import java.awt.image.BufferedImage
import java.io.{File, Serializable}
import java.awt.{Point, Rectangle, Shape}
import javax.imageio.ImageIO
import scala.collection.mutable.ArrayBuffer
import scala.io.Source
import scala.language.{existentials, postfixOps}
import scala.util.{Failure, Success, Using}

class User1 {
	def setName(name: String): this.type = {
		// some code
		this
	}

	def setAge(age: Int): this.type = {
		// some code
		this
	}

}

val user1 = new User1

user1.setName("Ivan").setAge(25)

class Admin extends User1 {
	def setPassword(password: String) = {
		// some code
		this
	}
}

val admin = new Admin

admin.setName("Max").setAge(40).setPassword("qwerty")


object Name

class User2 {
	private var useNextArgs: Any = _

	var name = " "

	def set(obj: Name.type): this.type = {
		useNextArgs = obj
		this
	}

	def to(arg: String): Unit = if (useNextArgs == Name) name = arg
}

val user2 = new User2

user2 set Name to "Anna"

class Network {
	class Member

	def makeMember = new Member

	val members: ArrayBuffer[Member] = ArrayBuffer.empty[Member]
	val membersTypeProjection: ArrayBuffer[Network#Member] = ArrayBuffer.empty[Network#Member]
}

val network1 = new Network
val network2 = new Network


val member1: network1.Member = network1.makeMember
val member2: network2.Member = network2.makeMember


network1.members += member1
//network1.members += member2

// Type projection
network1.membersTypeProjection += member1
network1.membersTypeProjection += member2

// Compound type (Любой тип который использует оба Trait)

val img = new ArrayBuffer[Shape with Serializable]()

val rect = new Rectangle(1, 2, 3, 4)

img += rect
//img += new Area(rect)

// Экземпляр данного типа должен быть подтипом Trait'ов (обеих), а также иметь метод contains который принимает тип Point и возвращает Boolean
val a: Shape with Serializable {
	def contains(p: Point): Boolean
}


//? _ подходит любой Generic Type, главное чтобы был Generic'овый как в Java, Array[?]
val arr: Array[_]

// Любой тип потомка Int
val arr1: Array[_ <: Int]

//& Экзистенциональные типы forSome {}

val arr2: Array[T] forSome {type T}

val map1: Map[_ <: Int, _]
val map2: Map[T, U] forSome {type T; type U}
val map3: Map[T, U] forSome {type T; type U <: T}

val network: n1.Member forSome {val n1: Network}

def process[M <: n1.Member forSome {val n1: Network}](m1: M, m2: M) = (m1, m2)

//process(network1, network2) // Should be error
//process(member1, member2)

trait Reader {
	type Contents

	def read(fileName: String): Contents
}

class StringReader extends Reader {
	override type Contents = String

	override def read(fileName: String): Contents = {
		Using(Source.fromFile(fileName))(source => source.mkString) match {
			case Failure(exception) => "Error"
			case Success(value) => value
		}
	}
}

class ImageReader extends Reader {
	override type Contents = BufferedImage

	override def read(fileName: String) = ImageIO.read(new File(fileName))
}

trait Reader1[Contents] {
	def read(fileName: String): Contents
}

class StringReader1 extends Reader1[String] {
	override def read(fileName: String): String = {
		Using(Source.fromFile(fileName))(source => source.mkString) match {
			case Failure(exception) => "Error"
			case Success(value) => value
		}
	}
}

class ImageReader1 extends Reader1[BufferedImage] {
	override def read(fileName: String) =
		ImageIO.read(new File(fileName))
}

trait MyIterable[E] {
	def iterator(): Iterator[E]

	def map[F](f: E => F): Iterator[F]
}

class Buffer[E] extends Iterable[E] {
	override def iterator(): Iterator[E] = ???

	override def map[F](f: E => F): Buffer[F] = ???
}


// Higher-kinded type
trait MyIterableConst[E, C[_]] {
	def iterator(): Iterator[E]

	def build[F](): C[F]

	def map[F](f: (E) => F): C[F]
}

class MeRange extends MyIterableConst[Int, List] {
	override def iterator() = ???

	override def build[F]() = ???

	override def map[F](f: Int => F) = ???
}

val meRange = new MeRange

//meRange.iterator()