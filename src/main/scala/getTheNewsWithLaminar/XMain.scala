package getTheNewsWithLaminar

object XMain:
  import upickle.default.*
  case class Comments(id: String, text: String, postId: String) derives ReadWriter
  case class Resources(id: String, title: String, description: String,
                      resource_remote_id: String, program: String)
  case class Domains(id: String, domain: String, is_primary: Boolean,
                     created: String, modified: String, tenant: String)

  def manga(): Unit =
    import cats.effect.*
    import cats.effect.unsafe.implicits.*
    import io.circe.generic.auto.*
    import io.circe.literal.*
    import io.circe.syntax.*
    import org.http4s.circe.CirceEntityCodec.*
    import org.http4s.circe.*
    import org.http4s.client
    import org.http4s.Request
    import org.http4s.Headers.*
    import org.http4s.implicits.*
    import org.http4s.Method
    import org.http4s.dom.*
    import org.http4s.client.dsl.io.*
    import org.scalajs.dom.*


    val client = FetchClientBuilder[IO].create

//    val repoName: HTMLInputElement = document.getElementById("repo").asInstanceOf[HTMLInputElement]
    val repoStars: Element = document.getElementById("comments")
//      .asInstanceOf[HTMLElement]

//    case class Repo(stargazers_count: Int)
    val comment: Comments = Comments("2", "text: String", "postId: String")

//    val getRequest: Request[IO] = Request[IO](
//      method = Method.GET,
//      uri = uri"http://localhost:3000/comments/2",
//    )

    val postRequest: Request[IO] = Request[IO](
      method=Method.POST,
      uri=uri"http://localhost:3000/comments",
    )
      .withEntity(Comments("4", "text: 4", "postId4").asJson)

//    val getRequest: Request[IO] = Request[IO](
//      method = Method.POST,
//      uri = uri"http://localhost:3000/comments",
//    )

    val fetchRepo: IO[Unit] = for {

      repo <- client.expect[Comments](postRequest).attempt
      _ <- IO {
        repo match {
          case Right(Comments(id, text, postId)) => repoStars.innerHTML =
            s"$id =|= $text  =|= $postId★"
          case Left(_) => repoStars.innerHTML = s"Not found :("
        }
      }
    } yield ()

    val button: HTMLButtonElement = document.getElementById("buttonx").asInstanceOf[HTMLButtonElement]

    button.onclick = (_: MouseEvent) => fetchRepo.unsafeRunAndForget()

