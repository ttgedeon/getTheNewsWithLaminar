package getTheNewsWithLaminar

import com.raquo.laminar.api.L.{*, given}
import scala.scalajs.js
import scala.scalajs.js.annotation.*
import org.scalajs.dom

// import javascriptLogo from "/javascript.svg"
@js.native @JSImport("/javascript.svg", JSImport.Default)
val javascriptLogo: String = js.native

@main
def GetTheNews(): Unit =
//  import scala.scalajs.js as Js
//  import scala.scalajs.js.UndefOr
//  val f = Js.Dynamic.global.process.env.NODE_ENV.asInstanceOf[Js.UndefOr[String]]

  import getTheNewsWithLaminar.components.*
  import frontroute.LinkHandler

  val app: Element = div(
    Router()
  )
  app.amend(LinkHandler.bind)

  windowEvents(_.onLoad).foreach { _ =>
    val appContainer: dom.Element = dom.document.getElementById(elementId = "app")
    val appElement: Element = app
    render(container = appContainer, rootNode = appElement)
  }(unsafeWindowOwner)

end GetTheNews

