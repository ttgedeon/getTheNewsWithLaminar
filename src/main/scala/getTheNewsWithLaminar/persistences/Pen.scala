package getTheNewsWithLaminar.persistences

import io.circe.{Decoder, Encoder}
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}

case class Pen(name: String)

object Pen:
  implicit def decoderForA: Decoder[Pen] = deriveDecoder
  implicit def encoderForA: Encoder[Pen] = deriveEncoder
