package getTheNewsWithLaminar.components

import com.raquo.laminar.api.L.{*, given}
import ComponentsFactory.{buttonInfo, buttonInfoX, customStringCompositeHtmlAttr, formControlInput}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

// import javascriptLogo from "/javascript.svg"
@js.native @JSImport("/remix.png", JSImport.Default)
val remix: String = js.native

object CustomHtmlAttrs:

  val dataBsToggle : CompositeHtmlAttr =
    customStringCompositeHtmlAttr("data-bs-toggle", separator = " ")

  val dataBsTarget : CompositeHtmlAttr =
    customStringCompositeHtmlAttr("data-bs-target", separator = " ")

  val ariaControls : CompositeHtmlAttr =
    customStringCompositeHtmlAttr("aria-controls", separator = " ")

  val ariaExpanded: CompositeHtmlAttr =
    customStringCompositeHtmlAttr("aria-expanded", separator = " ")

  val ariaLabel: CompositeHtmlAttr =
    customStringCompositeHtmlAttr("aria-label", separator = " ")

  val ariaCurrent: CompositeHtmlAttr =
    customStringCompositeHtmlAttr("aria-current", separator = " ")

  val ariaDisabled: CompositeHtmlAttr =
    customStringCompositeHtmlAttr("aria-disabled", separator = " ")

  val forAttr: CompositeHtmlAttr =
    customStringCompositeHtmlAttr("for", separator = " ")

  val dataToggle: CompositeHtmlAttr =
    customStringCompositeHtmlAttr("data-toggle", separator = " ")

  val dataTarget: CompositeHtmlAttr =
    customStringCompositeHtmlAttr("data-target", separator = " ")

  val ariaLabelledBy: CompositeHtmlAttr =
    customStringCompositeHtmlAttr("aria-labelledby", separator = " ")

  val onClicked: CompositeHtmlAttr =
    customStringCompositeHtmlAttr("onclick", separator = " ")
