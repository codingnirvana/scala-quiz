package api

object Api extends App{

  import dispatch._, Defaults._
  val svc =
    ( url("http://api.indix.com/api/beta/stores/")
      <<? Map("query" -> "s") <<? Map("app_id" -> "e3a00b36" ) <<? Map("app_key" -> "2dd05ba6dd9697b1051fcb7123b25c34")
      )

  println(svc.toRequest.getUrl)

  val ans = Http(svc OK as.String)

  Thread.sleep(1000)

  println(ans.print)

  System.exit(0)

}
