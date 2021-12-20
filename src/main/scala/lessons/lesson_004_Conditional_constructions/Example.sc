var lightOn = true

val turnOnTheLight = "Turn on the light"
val takeFeed = "Take feed"
val feelTrough = "Feel trough"

if (lightOn) {
  println(takeFeed)
  println(feelTrough)
}

val ifInstruction: Unit = if (lightOn) {
  println(takeFeed)
  println(feelTrough)
}

if (lightOn) {
  s"$takeFeed, $feelTrough"
} else {
  s"$turnOnTheLight, $takeFeed, $feelTrough"
}

lightOn match {
  case true => s"$takeFeed, $feelTrough"
  case false => s"$turnOnTheLight, $takeFeed, $feelTrough"
}

var lightOnString = "light-On"

lightOnString match {
  case "light-On" => s"$takeFeed, $feelTrough"
  case "light-Off" => s"$turnOnTheLight, $takeFeed, $feelTrough"
  case _ => s"We don't know what to do"
}