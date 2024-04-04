package getTheNewsWithLaminar

object YMain:
  def mental() =
    import getTheNewsWithLaminar.domain.apiDomain.NewsResponse
    import getTheNewsWithLaminar.domain.localDomain.User
    import getTheNewsWithLaminar.XMain.Comments
    import getTheNewsWithLaminar.services.generics.ServiceError
    import getTheNewsWithLaminar.services.localServices.UserService
    import sttp.client4.quick.*
    import sttp.client4.Response
    import upickle.default.*

    import scala.concurrent.{Await, Future, Promise}
    import scala.concurrent.ExecutionContext.Implicits.global
    import scala.concurrent.duration.Duration

//    val response =
//      quickRequest
//        .header("X-Origin", "https://scala-lang.org")
//        .get(uri"https://httpbin.org/get")
//        .send()
//
//    val p: Promise[String] = Promise[String]()
//    val f: Future[String] = p.future
//
//    val s: String = System.getenv("Make")

//    val rs: Future[Response[String]] = quickRequest
//      .post(uri"http://localhost:3000/comments")
//      .header("Content-Type", "application/json")
//      .body(write(Comments("25", "25Text-e", "postId25-edited")))
//      .send()

//    for (r <- rs)
//      println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>")
//      println(r.body)
//      println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>")
//      print(r.code.code)
//      println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>")
    println("aaaaaaaaaaas")
    val s: Future[ServiceError | User] = UserService.retrieve("a")
    for (r <- s)
      println(r)

    println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>")
    val response: Future[Response[String]] =
      quickRequest
        .header("X-Api-Key", "63b223ccd5ad44368c4acb95f7af2f96")
        .get(uri"https://newsapi.org/v2/everything?q=bitcoin")
        .send()

//    val s: String = System.getenv("Make")

    for (r <- response)
      println(r.code)

//      println(r.body)

      println("---------------------------------")
      val articles: NewsResponse = read[NewsResponse](r.body)

      println(articles)

      println("---------------------------------")

      println(r.headers)
//      p.success(r.body)

//    /**
//    import sttp.client4.quick.*
//    import sttp.client4.Response
//    import sttp.model.Uri
//    import ujson.Obj
//
//    import scala.concurrent.{Await, Future, Promise}
//    import scala.concurrent.ExecutionContext.Implicits.global
//    import scala.concurrent.duration.Duration
//
//    val json: Obj = ujson.Obj(
//        "title" -> "readable PLUS",
//        "description" -> "readable description PLUS",
//        "program" -> "57882fd7-48b2-47ad-9b53-8279515f2aff",
//        "resource_remote_id" -> "57882fd7-48b2-47ad-9b53-8279515f2aff"
//    )
//    val jsonB: Obj = ujson.Obj(
//      "id" -> "19", "text" -> "text: 19", "postId" -> "postId19"
//    )
//
//    val response = quickRequest
//      .header("X-Origin", "https://scala-lang.org")
//      .header("Tenant", "ac58454155d8f3f993dfaddfe09fab7304849f95")
//      .header("Content-Type", "application/json")
//      .header("Access-Control-Allow-Origin", "*")
//      .body(ujson.write(json))
//      .post(Uri("localhost:8000/navigation/api/v1/resources"))
//      .post(Uri("localhost:3000/comments"))
//      .send()

//    val p: Promise[Any] = Promise[Any]()
//    val f: Future[Any] = p.future
//    for (r <- response)
//      println(r.code)
//      println(r.body)
//
//      println(r.headers)
//
//      p.success(r.body)
//     */


end YMain

