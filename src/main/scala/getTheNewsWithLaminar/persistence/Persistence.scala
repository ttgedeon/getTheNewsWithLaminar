package getTheNewsWithLaminar.persistence

import io.circe.parser.decode
import io.circe.syntax._
import io.circe.{Decoder, Encoder}
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import concurrent.ExecutionContext.Implicits.global
import org.scalajs.dom.BodyInit
import org.scalajs.dom.HttpMethod
import org.scalajs.dom.RequestInit
import org.scalajs.dom.Response
import scala.concurrent.Future

import org.scalajs.dom.Headers

trait Persistence { this: APIFetch =>

//  implicit def decoderForA: Decoder[Pen]
//  implicit def encoderForA: Encoder[Pen]

//  def getObjects(_url: String, _body: BodyInit, _headers: Map[String, String])
//  =
//    this.get(_url=_url, _body=_body, _headers=_headers)
//      .flatMap{ (response: Response) =>
//        response.status match
//          case 200 => response.
//          case _ =>
//      }
}
