sealed class Pair[T](val _1: T, val _2: T) {
	def swap: Pair[T] = new Pair(_2, _1)
}

val pair = new Pair(1, 2)

println(s"Before\n_1: ${pair._1}, _2: ${pair._2}")

val pairSwapped = pair.swap

println(s"After\n_1: ${pairSwapped._1}, _2: ${pairSwapped._2}")

