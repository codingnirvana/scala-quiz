package challenges

import scala.io.Source
import java.io.PrintWriter
import resource._


object FileHelper {

   def readLines(fileName: String): (Int, List[String]) = {
      for (source <- managed(Source.fromFile(fileName))) {
        val allLines = source.getLines().toList
        return (allLines.head.toInt, allLines.tail)
      }
      throw new RuntimeException()
   }

   def writeLines(fileName: String, data: List[String]) {
     for (writer <- managed(new PrintWriter(fileName))) {
       data.foreach(writer.println(_))
     }
   }
}
