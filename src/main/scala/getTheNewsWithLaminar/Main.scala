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
  windowEvents(_.onLoad).foreach { _ =>
    val appContainer: dom.Element = dom.document.getElementById(elementId = "app")
    val appElement: Element = Main.appElement()
    render(container = appContainer, rootNode = appElement)
  }(unsafeWindowOwner)

end GetTheNews

object Main:
  def appElement(): Element =
    div(
      h1("The news")
    )
