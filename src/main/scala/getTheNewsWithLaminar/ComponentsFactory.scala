package getTheNewsWithLaminar

import com.raquo.laminar.api.L.{*, given}
import scala.scalajs.js
import scala.scalajs.js.annotation.*
import com.raquo.laminar.modifiers.Modifier
import com.raquo.laminar.nodes.ReactiveHtmlElement

import com.raquo.laminar.DomApi
import com.raquo.laminar.codecs.StringAsIsCodec
import com.raquo.laminar.defs.complex.ComplexHtmlKeys.CompositeHtmlAttr
import com.raquo.laminar.keys.{CompositeKey, HtmlAttr}
import com.raquo.laminar.nodes.ReactiveHtmlElement.Base


import org.scalajs.dom


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
      label(labelAttr := forLabel, child.text <-- Var(labelContent).signal)
    )

  def buttonInfo(buttonType: String, buttonClass: String, buttonContent: String): Element =
    button(
      `type` := buttonType, className := buttonClass,
      child.text <-- Var(buttonContent).signal
    )

  def customStringCompositeHtmlAttr(name: String, separator: String) : CompositeHtmlAttr = {
    val attr = new HtmlAttr(name, StringAsIsCodec)
    new CompositeKey(
      name = attr.name,
      getRawDomValue = (el: Base) => DomApi.getHtmlAttribute(el, attr).getOrElse(""),
      setRawDomValue = (el: Base, value: String) => DomApi.setHtmlAttribute(el, attr, value),
      separator = separator
    )
  }
  
end ComponentsFactory

