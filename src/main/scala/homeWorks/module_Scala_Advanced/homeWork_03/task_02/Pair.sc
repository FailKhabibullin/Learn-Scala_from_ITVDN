final class Pair[T, S](val _1: T, val _2: T) {
	def swap(that: Pair[T, S]) = {
		new Pair[T, S](that._2, that._1)
	}
}


val pair1 = new Pair(1, 2)
val pair2 = new Pair(3, 4)

val swappedPair = pair1.swap(pair2)

println(s"Before\n_1: ${swappedPair._1}, _2: ${swappedPair._2}")