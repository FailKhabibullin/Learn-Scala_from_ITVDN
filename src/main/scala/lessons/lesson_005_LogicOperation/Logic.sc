var ticket = true // Пропуск
var hands = false // Дезинфекция рук
var feet = true // Дезинфекция ног

var entry = ticket && hands && feet // Проверка полей для захода

var nightTime = false // Тёмное время суток
var closeBlinds = true // Жалюзи закрыты


if (ticket && hands && feet) "You can come in" else "Get out"

val turnOnTheLight = nightTime || closeBlinds

if (turnOnTheLight) {
  "Turn on the light"
} else "Turn off the light"

var activeUse = true // Активное использование монитора

val turnOffTheScreen = !activeUse ||  nightTime //