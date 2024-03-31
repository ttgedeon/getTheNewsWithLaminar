package getTheNewsWithLaminar.components

import com.raquo.laminar.api.L.{*, given}
import CustomHtmlAttrs.*
import ComponentsFactory.*

object PasswordInput:
  def apply(): Element =
    formControlInput(
      divClass = "form-floating",
      inputType = "password",
      inputClass = "form-control",
      inputId = "floatingPassword",
      inputPlaceholder = "Password",
      forLabel = "floatingPassword",
      labelContent = "Password"
    )
