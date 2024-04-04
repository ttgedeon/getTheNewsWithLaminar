import com.raquo.laminar.api.L._
import io.laminext.fetch._
import org.scalajs.dom.Response
import scala.concurrent.Future

case class Comment(id: "String", text: String, postId: String)

val commentReader: Response => Future[String] =
  (response: Response) =>
    Future.successful[String](response.body.text())