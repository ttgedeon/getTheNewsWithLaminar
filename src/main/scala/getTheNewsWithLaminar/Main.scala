package getTheNewsWithLaminar

import com.raquo.laminar.api.L.{*, given}
import scala.scalajs.js
import scala.scalajs.js.annotation.*
import typings.dotenv.mod
import typings.dotenv.mod.configDotenv
import org.scalajs.dom

// import javascriptLogo from "/javascript.svg"
@js.native @JSImport("/javascript.svg", JSImport.Default)
val javascriptLogo: String = js.native

@main
def GetTheNews(): Unit =
  import scala.scalajs.js as Js
  import scala.scalajs.js.UndefOr
  val f = Js.Dynamic.global.process.env.NODE_ENV.asInstanceOf[Js.UndefOr[String]]
  windowEvents(_.onLoad).foreach { _ =>
    val appContainer: dom.Element = dom.document.getElementById(elementId = "app")
    val appElement: Element = Main.appElement()
    render(container = appContainer, rootNode = appElement)
  }(unsafeWindowOwner)

end GetTheNews

object Main:

  def appElement(): Element =
    import Components.*

    div(
      secondaryNavBar(None, None, None, None, None, None, None, None),
      p("===================================="),
      passwordControlInput,
      p("===================================="),
      infoButton,
      p("===================================="),
      primaryCard,
      p("====================================="),
      mainNavBar,
      p("====================================="),
      p("====================================="),
      formCheckBox(None, None),
      p("====================================="),
    )
