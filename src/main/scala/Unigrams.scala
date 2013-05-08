import challenges.FileHelper
import java.io.{FileOutputStream, DataOutputStream}

object Unigrams extends App {

  case class Feature(id: Int, token: String, frequency: Int)
  case class Product(id: Int, title: String, tokens : Array[String])
  case class Record(recordNumber: Int, title: String, noOfFeatures: Int, featureVector: Int*)

  def lines =  io.Source.fromFile("/home/rajeshm/Downloads/apparel.out").getLines()

  def tokenize(s: String) : Array[String] = {
    clean(s).split(' ')
       .map(_.trim.toLowerCase)
  }

  def clean(s: String) : String = {
    s.filterNot(c => ("()_-").contains(c))
  }

  def swapIndian(b: Array[Int]) = {
    val b3 : Int = (b(3)<<24)
    val b2 : Int = (b(2)<<16)
    val b1: Int = (b(1)<<8)
    val b0: Int = (b(0))
    val y = b3 | b2 | b1 | b0
    y
  }

  def toInt(chars: Seq[Char]) : Int = {
    swapIndian(chars.map(_.toInt).toArray)
  }

  def toSwappedInt(i: Int) : Array[Byte] = {
    val x = Array[Int](i >> 24, i >> 16, i >> 8, i).map(_.toByte).reverse
    x
  }

  def write(v: Record, writer: DataOutputStream) = {
    val a = toSwappedInt(v.recordNumber)
    writer.write(a)

    val b = toSwappedInt(v.noOfFeatures)
    writer.write(b)
    v.featureVector.foreach {
      (x) => writer.write(toSwappedInt(x))
    }
  }

  def printResults(products: Map[Int,Product]) {
    val source = io.Source.fromFile("/tmp/sim.txt")

    val results = source.getLines()
      .map(_.split(','))
      .map(a => (a(0), products(a(0).toInt).title, a(1), products(a(1).toInt).title, a(2)))

    FileHelper.writeLines("/tmp/results.csv", results.toList.map(f => s"${f._1},${f._2},${f._3},${f._4},${f._5}"))

    source.close()
  }

  def run() {

    val products: List[Product] = lines.drop(1)
      //.take(50)
      .map(_.split(',')(0))
      .zipWithIndex.map {case (element,index) => Product(index, element, tokenize(element))}
      .toList

    val tokenizedTitles: List[Array[String]] = products
        .map(_.tokens)

    val wordFrequency: Seq[(String, Int)] = tokenizedTitles
      .flatten.toList
      .groupBy(identity)
      .mapValues(_.size).toSeq
      .sortBy(_._2)
      .reverse

    val featureList: Seq[Feature] = wordFrequency
      .zipWithIndex.map {case (element, index) => Feature(index, element._1, element._2)}

    val invertedIndex: Map[String, Feature] = featureList
      .map { f => (f.token, f)} toMap

    def toFeatureVector(tokens: Array[String]) = {
      tokens.map {(t) => invertedIndex(t).id}
    }

    val vectors: List[Record] = products
      .sortBy(_.tokens.size)
      .map(p => Record(p.id, p.title, p.tokens.size, toFeatureVector(p.tokens) : _*))

    val writer = new DataOutputStream(new FileOutputStream("/tmp/vectors.bin"))

    val binaryVectors = vectors
      .foreach (write(_,writer))

    writer.close()

    FileHelper.writeLines("/tmp/features.csv", featureList.map(f => s"${f.id},${f.token},${f.frequency}"))
    FileHelper.writeLines("/tmp/products.csv", products.map(p => s"${p.id},${p.title}"))
    FileHelper.writeLines("/tmp/vectors.csv", vectors.map(v => s"${v.recordNumber},${v.noOfFeatures},${v.featureVector.mkString(",")}"))

    val productsMap: Map[Int, Product] = products
      .map { f => (f.id, f)} toMap

    printResults(productsMap)

  }

  run()

  //read()

}
