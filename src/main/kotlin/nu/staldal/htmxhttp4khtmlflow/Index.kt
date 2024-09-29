package nu.staldal.htmxhttp4khtmlflow

import htmlflow.*
import org.xmlet.htmlapifaster.Ul

fun index() =
    page<Unit>("Examples") {
        h3 { text("htmx UI") }
        ul {
            menuItem("/click-to-edit", "Click to edit")
            menuItem("/bulk-update", "Bulk update")
            menuItem("/click-to-load", "Click to load")
            menuItem("/infinite-scroll", "Infinite scroll")
            menuItem("/value-select", "Value select")
            menuItem("/modal-dialog", "Modal dialog using Bootstrap")
        }
        h3 { text("Complete use cases") }
        ul {
            menuItem("/todo-list", "To do list")
        }
    }

fun Ul<*>.menuItem(url: String, text: String) {
    li {
        a {
            attrHref(url)
            text(text)
        }
    }
}
