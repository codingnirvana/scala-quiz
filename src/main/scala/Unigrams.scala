import challenges.FileHelper

object Unigrams extends App {

  case class Feature(id: Int, token: String, frequency: Int)
  case class Product(id: Int, title: String, tokens : Array[String])
  case class Record(recordNumber: Int, title: String, noOfFeatures: Int, featureVector: Int*)

  def lines =  io.Source.fromFile("/home/rajeshm/Downloads/mobiles/data/indix/Mobiles-Master-Data.csv").getLines()

  def tokenize(s: String) : Array[String] = {
    clean(s).split(' ')
       .map(_.trim.toLowerCase)
  }

  def clean(s: String) : String = {
    s.filterNot(c => ("()_-").contains(c))
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
      .reverse
      .map(p => Record(p.id, p.title, p.tokens.size, toFeatureVector(p.tokens) : _*))

    FileHelper.writeLines("/tmp/features.csv", featureList.map(f => s"${f.id},${f.token},${f.frequency}"))
    FileHelper.writeLines("/tmp/products.csv", products.map(p => s"${p.id},${p.title}"))
    FileHelper.writeLines("/tmp/vectors.csv", vectors.map(v => s"${v.recordNumber},${v.noOfFeatures},${v.featureVector.mkString(",")}"))

  }

  run()
}
