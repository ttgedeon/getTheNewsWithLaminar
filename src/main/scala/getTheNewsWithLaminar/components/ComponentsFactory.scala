package getTheNewsWithLaminar.components

import com.raquo.laminar.api.L.{*, given}
import com.raquo.laminar.modifiers.Modifier
import com.raquo.laminar.nodes.ReactiveHtmlElement
import com.raquo.laminar.DomApi
import com.raquo.laminar.codecs.StringAsIsCodec
import com.raquo.laminar.defs.complex.ComplexHtmlKeys.CompositeHtmlAttr
import com.raquo.laminar.keys.{CompositeKey, HtmlAttr}
import com.raquo.laminar.nodes.ReactiveHtmlElement.Base
import org.scalajs.dom
import org.scalajs.dom.MouseEvent

import scala.scalajs.js
import scala.scalajs.js.annotation.*


object ComponentsFactory:
  
  def formControlInput(divClass : String, inputType: String, inputClass: String,
   inputId: String, inputPlaceholder: String, forLabel: String, labelContent: String
   ) : Element =
    div(
      className := divClass,
      input(
        `type` := inputType, className := inputClass, idAttr := inputId,
        placeholder := inputPlaceholder
      ),
      label(labelAttr := forLabel, labelContent)
    )

  def buttonInfoX(buttonType: String, buttonClass: String, buttonContent: String)
  : Element =
    button(
      `type` := buttonType, className := buttonClass, onClick --> {(_: MouseEvent) => import getTheNewsWithLaminar.XMain
        XMain.manga()},
       buttonContent, idAttr := "buttonx"
    )

  def buttonInfo(buttonType: String, buttonClass: String, buttonContent: String): Element =
    button(
      `type` := buttonType, className := buttonClass,
      onClick --> {(_: MouseEvent) => ()},
      buttonContent, idAttr := "button"
    )

  def customStringCompositeHtmlAttr(name: String, separator: String = "")
  : CompositeHtmlAttr = {
    val attr = new HtmlAttr(name, StringAsIsCodec)
    new CompositeKey(
      name = attr.name,
      getRawDomValue = (el: Base) => DomApi.getHtmlAttribute(el, attr).getOrElse(""),
      setRawDomValue = (el: Base, value: String) => DomApi.setHtmlAttribute(el, attr, value),
      separator = separator
    )
  }
  
end ComponentsFactory

