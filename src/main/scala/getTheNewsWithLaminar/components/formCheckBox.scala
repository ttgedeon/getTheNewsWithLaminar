package getTheNewsWithLaminar.components

import com.raquo.laminar.api.L.{*, given}
import CustomHtmlAttrs.*

object formCheckBox:
  def apply(title: Option[String], checkStatus: Option[Boolean]): Element =
    div(className := "form-check",
      input(className := "form-check-input", `type` := "checkbox",
        idAttr := "flexCheckChecked", checked := checkStatus.getOrElse(false)
      ),
      label(className := "form-check-label", forAttr := "flexCheckChecked",
        title.getOrElse("Checked box")
      )
    )
