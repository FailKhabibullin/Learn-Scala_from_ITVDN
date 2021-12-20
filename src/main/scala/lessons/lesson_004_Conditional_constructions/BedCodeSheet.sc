// Before refactoring

val day = "Sunday"

val result = if (day == "Monday") {
  println("It is Monday")
  false
} else if (day != "Tuesday") {
  if (day != "Wednesday") {
    if (day != "Tuesday") {
      if (day != "Friday") {
        if (day == "Saturday") {
          println("It is Saturday")
        } else true
      } else {
        if (day == "Thursday") {
          println("It is Thursday")
          false
        }
        else if (day == "Wednesday") {
          println("It is Wednesday")
          false
        }
        else true
      }
    } else true
  } else if (day == "Sunday") true else false
} else true

result

// After refactoring
val result1 = if (day == "Monday") {
  println("it is Monday")
  false
} else if (day == "Tuesday") {
  println("It is Tuesday")
  false
} else if (day == "Wednesday") {
  println("It is Wednesday")
  false
} else if (day == "Thursday") {
  println("It is Thursday")
  false
} else if (day == "Friday") {
  println("It is Friday")
  false
} else if (day == "Saturday") {
  println("It is Saturday")
  false
} else true

result1

val result2 = day match {
  case "Monday" => println("It is Monday"); false
  case "Tuesday" => println("It is Tuesday"); false
  case "Wednesday" => println("It is Wednesday"); false
  case "Thursday" => println("It is Thursday"); false
  case "Friday" => println("It is Friday"); false
  case "Saturday" => println("It is Saturday"); false
  case "Sunday" => true
  case _ => println("Error, illegal day")
}

result2