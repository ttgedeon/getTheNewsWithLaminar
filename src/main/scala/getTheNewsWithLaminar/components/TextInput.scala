package getTheNewsWithLaminar.components

import com.raquo.laminar.api.L.{*, given}
import CustomHtmlAttrs.*
import ComponentsFactory.*

object TextInput
def apply(): Element =
  formControlInput(
    divClass = "form-floating",
    inputType = "text",
    inputClass = "form-control",
    inputId = "repo",
    inputPlaceholder = "Comment id",
    forLabel = "Comment id",
    labelContent = "idComment"
  )

