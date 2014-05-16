
case class Person() {
  def name = "name"
}

def getPerson(a: String) : Option[Person] = {
  a match {
    case "1234" => Some(Person())
    case _ => None
  }
}
val x =  getPerson("1234")
val y = getPerson("foo")

val z = x match {
  case Some(p) => p.name
  //case None => "no-name"
}





