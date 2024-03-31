package getTheNewsWithLaminar.components

import com.raquo.laminar.api.L.{*, given}
import CustomHtmlAttrs.*
import ComponentsFactory.*

object InfoButton:
  def apply(content: String = "Info"): Element =
    buttonInfo(
      buttonType = "button", buttonClass = "btn btn-info",
      buttonContent = content
    )
