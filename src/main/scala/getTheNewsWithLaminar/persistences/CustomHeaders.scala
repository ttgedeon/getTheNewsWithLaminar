package getTheNewsWithLaminar.persistences

import org.scalajs.dom.Headers

trait CustomHeaders {
  lazy val defaultHeaders: Map[String, String]
  lazy val initialHeaders: Headers = computeHeaders(defaultHeaders)
  def computeHeaders(_headers: Map[String, String]): Headers =
    val _heads: Headers = Headers()
    for ((a, b) <- _headers)
        _heads.set(name = a, value = b)
    _heads
}
