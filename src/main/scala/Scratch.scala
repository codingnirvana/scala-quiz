import challenges.FileHelper
import scala.util.parsing.json.{JSONFormat, JSON}

object Scratch extends App{

  def solve(line: String): String = {
    val split: Array[String] = line.split(",\\[")
    val rowKey = split(0)
    try {
    val json = JSON.parseFull(split(1).dropRight(1)).get.asInstanceOf[Map[String,Any]]
    val s = """"%s","%s","%s","%s"""".format(rowKey, json.get("title").get, json.get("externalProductUrl").get, json.get("imageUrl").get)
    s
    } catch {
      case ex: Exception =>
        println(ex.getMessage)
        ""
    }
  }

  def run {
    val lines = FileHelper.readAllLines("/home/rajeshm/Downloads/www.beautante.com_attributes.json")
    val result = lines.take(3000).map(Scratch.solve)
    FileHelper.writeLines("/home/rajeshm/Downloads/beautante.csv", result)
  }

  run

}
