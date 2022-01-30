def apply[A, B](oab: Option[A => B])(oa: Option[A]): Option[B] = {
	(oab, oa) match {
		case (Some(f), Some(a)) => Some(f(a))
		case _ => None
	}
}

apply[Int, String](Some(_.toString))(Some(5))
apply[Int, String](Some(_.toString))(None)

def double(x: Int): Int = 2 * x

val xs = Seq(1, 2, 3)

//double(xs)

def liftToSeq[A, B](f: A => B): (Seq[A] => Seq[B]) =
	(seq: Seq[A]) => seq.map(f)

liftToSeq(double)(xs)

trait Applicative[F[_]] {
	def map2[A, B, C](fa: F[A], fb: F[B])(f: (A, B) => C): F[C]

	def unit[A](a: => A): F[A]

	def isEmpty[A](a: F[A]): Boolean
}

class ApplicateImpl[F[_]](f: Applicative[F]) {
	def sequenceMap[K, V](ofa: Map[K, F[V]]): F[Map[K, V]] = {
		ofa.foldLeft(f.unit(Map.empty[K, V])) {
			case (fAcc, (k, fV)) =>
				if (f.isEmpty(fV)) fAcc
				else {
					f.map2(fAcc, fV) { (acc, v) =>
						acc + (k -> v)
					}
				}
		}
	}
}


class MyOption extends Applicative[Option] {
	override def map2[A, B, C](fa: Option[A], fb: Option[B])(f: (A, B) => C): Option[C] = {
		(fa, fb) match {
			case (Some(fa), Some(fb)) => Some(f(fa, fb))
			case _ => None
		}
	}

	override def unit[A](a: => A): Option[A] = if (a == null) None else Some(a)

	override def isEmpty[A](a: Option[A]) = a.isEmpty
}

val app = new ApplicateImpl[Option](new MyOption)

app.sequenceMap(Map(1 -> Some(5), 2 -> None, 3 -> Some(10)))