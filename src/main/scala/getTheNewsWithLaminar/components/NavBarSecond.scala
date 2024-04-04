package getTheNewsWithLaminar.components

import com.raquo.laminar.api.L.{*, given}
import CustomHtmlAttrs.*

object NavBarSecond:
  def apply(elt1: Option[String]=None, elt2: Option[String]=None, elt3: Option[String]=None,
            elt4: Option[String]=None, elt5: Option[String]=None, elt6: Option[String]=None,
            elt7: Option[String]=None, elt8: Option[String]=None): Element =

    navTag(className := "navbar navbar-expand-lg navbar-light bg-light",
      div(className := "container-fluid",
        a(className := "navbar-brand", href := "/home",
          img(
            src :=
              "https://i.pinimg.com/736x/0f/51/43/0f514348930957803d557f6f825aa36b.jpg",
            className := "m-auto newsLogo")
        ),
        button(className := "navbar-toggler", `type` := "button",
          dataBsToggle := "collapse", dataBsTarget := "#navbarScroll",
          ariaControls := "navbarScroll", ariaExpanded := "false",
          ariaLabel := "Toggle navigation",
          span(className := "navbar-toggler-icon")
        ),
        div(className := "collapse navbar-collapse", idAttr := "navbarScroll",
          ul(className := "navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll",
            styleAttr := "--bs-scroll-height: 100px;",
            li(className := "nav-item dropdown",
              a(className := "nav-link dropdown-toggle", href := "#",
                idAttr := "navbarScrollingDropdown", role := "button",
                dataBsToggle := "dropdown", ariaExpanded := "false",
                "My news"
              ),
              ul(className := "dropdown-menu",
                ariaLabelledBy := "navbarScrollingDropdown",
                li(a(className := "dropdown-item", href := "/savedNews",
                  "Saved news")
                ),
                li(a(className := "dropdown-item", href := "/likedNews",
                  "Liked news")
                ),

              )
            ),
            li(className := "nav-item",
              a( className := "nav-link", href := "/history",
                "History")
            ),
          ),

            div(className := "nav-item dropdown me-5",
              a(className := "nav-link", href := "#",
                idAttr := "navbarScrollingDropdown", role := "button",
                dataBsToggle := "dropdown",
                ariaExpanded := "false",
                div(
                  img(
                    className:="userPicContainer",
                    src :=
                      "https://www.tenforums.com/geek/gars/images/2/types/thumb_15951118880user.png",
                    className := "m-auto newsLogo")
                )
              ),
              ul(className := "dropdown-menu",
                ariaLabelledBy := "navbarScrollingDropdown",
                li(a(className := "dropdown-item", href := "/dashboard",
                  "Dashboard")
                ),
                li(a(className := "dropdown-item", href := "/settings",
                  "Settings")
                ),
                li(a(className := "dropdown-item", href := "/profile",
                  "Profile")
                ),
                li(hr(className := "dropdown-divider")
                ),
                li(a(className := "dropdown-item", href := "/logout",
                  "Logout")
                )
              )
//            )
          )
        )
      )

    )