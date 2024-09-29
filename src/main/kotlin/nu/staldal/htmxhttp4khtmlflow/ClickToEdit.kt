package nu.staldal.htmxhttp4khtmlflow

import htmlflow.*
import org.xmlet.htmlapifaster.Div
import org.xmlet.htmlapifaster.EnumTypeInputType
import org.xmlet.htmlapifaster.Form

fun clickToEdit() =
    page<Person>("Click to edit") {
        viewPerson()
    }

fun Div<*>.viewPerson() {
    div {
        addAttr("hx-target", "this")
        addAttr("hx-swap", "outerHTML")
        dyn { person: Person ->
            viewControl("First Name", "firstName", person.firstName)
            viewControl("Last Name", "lastName", person.lastName)
            viewControl("Email", "email", person.email)
        }
        div {
            button {
                attrClass("btn btn-primary")
                addAttr("hx-get", "/person/edit")
                text("Click To Edit")
            }
        }
    }
}

fun Form<*>.editPerson() {
    form {
        addAttr("hx-put", "/person")
        addAttr("hx-target", "this")
        addAttr("hx-swap", "outerHTML")
        dyn { person: Person ->
            editControl("First Name", "firstName", person.firstName)
            editControl("Last Name", "lastName", person.lastName)
            editControl("Email", "email", person.email)
        }
        div {
            button {
                attrClass("btn btn-primary me-1")
                text("Submit")
            }
            button {
                attrClass("btn btn-secondary")
                addAttr("hx-get","/person")
                text("Cancel")
            }
        }
    }
}

fun Div<*>.viewControl(label: String, id: String, value: String) {
    div {
        attrClass("row mb-1")
        label {
            attrClass("col-sm-1 col-form-label")
            attrFor(id)
            text(label)
        }
        div {
            attrClass("col-sm-4")
            input {
                attrClass("form-control-plaintext")
                attrType(EnumTypeInputType.TEXT)
                attrReadonly(true)
                attrName(id)
                attrValue(value)
            }
        }
    }
}

fun Form<*>.editControl(label: String, id: String, value: String) {
    div {
        attrClass("row mb-1")
        label {
            attrClass("col-sm-1 col-form-label")
            attrFor(id)
            text(label)
        }
        div {
            attrClass("col-sm-4")
            input {
                attrClass("form-control")
                attrType(EnumTypeInputType.TEXT)
                attrName(id)
                attrValue(value)
            }
        }
    }
}
