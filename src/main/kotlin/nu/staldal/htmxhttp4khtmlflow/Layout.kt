package nu.staldal.htmxhttp4khtmlflow

import htmlflow.HtmlView
import htmlflow.body
import htmlflow.div
import htmlflow.h1
import htmlflow.h2
import htmlflow.head
import htmlflow.html
import htmlflow.link
import htmlflow.meta
import htmlflow.script
import htmlflow.title
import htmlflow.view
import org.xmlet.htmlapifaster.Div
import org.xmlet.htmlapifaster.EnumRelType
import org.xmlet.htmlapifaster.EnumTypeScriptType
import org.xmlet.htmlapifaster.Head

private const val mainTitle = "htmx with http4k and HtmlFlow"

fun <T>page(subtitle: String, headExtra: (Head<*>) -> Unit = {}, block: Div<*>.() -> Unit): HtmlView<T> =
    view<T> {
        html {
            attrLang("en")
            head {
                meta {
                    attrCharset("UTF-8")
                }
                meta {
                    attrName("viewport")
                    attrContent("width=device-width, initial-scale=1")
                }
                script {
                    attrType(EnumTypeScriptType.TEXT_JAVASCRIPT)
                    attrSrc("/htmx.min.js")
                }
                script {
                    attrType(EnumTypeScriptType.TEXT_JAVASCRIPT)
                    attrSrc("/_hyperscript.min.js")
                }
                link {
                    attrRel(EnumRelType.STYLESHEET)
                    attrHref("/css/bootstrap.css")
                }
                headExtra(this)
                title { text(mainTitle) }
            }
            body {
                div {
                    attrClass("container")
                    h1 { text(mainTitle) }
                    h2 { text(subtitle) }
                    block(this)
                }
            }
        }
    }
