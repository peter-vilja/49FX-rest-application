package fi.peter.fx.rest

import org.json4s.{DefaultFormats, Formats}
import org.scalatra.json._
import org.scalatra._
import fi.peter.fx.domain.{MessageAndId, Message}
import fi.peter.fx.domain.MessageRepository._
import com.mongodb.util.JSON

class FxResource() extends ScalatraServlet with ScalatraBase with CorsSupport with JacksonJsonSupport {

  protected implicit val jsonFormats: Formats = DefaultFormats

  options("/*"){
    response.setHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"));
  }

//  before() {
//    contentType = formats("json")
//  }

  get("/message") {
    JSON.serialize(fetch())
  }

  post("/message") {
    add(request.body)
  }

}