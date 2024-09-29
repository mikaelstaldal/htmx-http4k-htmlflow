package nu.staldal.htmxhttp4khtmlflow

import htmlflow.HtmlView
import org.http4k.core.ContentType.Companion.TEXT_HTML
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.core.with
import org.http4k.lens.Header

fun <T>htmlResponse(status: Status = Status.OK, htmlView: HtmlView<T>, model: T): Response = Response(status)
    .with(Header.CONTENT_TYPE of TEXT_HTML)
    .body(htmlView.render(model))
