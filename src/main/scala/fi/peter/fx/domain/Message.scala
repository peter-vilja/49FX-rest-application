package fi.peter.fx.domain

import org.joda.time.DateTime
import com.mongodb.casbah.Imports._
import com.mongodb.util.JSON

case class MessageAndId(id: Int, icon: String, day: Int, month: String, message: String)
case class Message(icon: String, message: String)

object MessageRepository {

  val mongoClient =  MongoClient()
  val messages = mongoClient("49")("FX")

//  var messages = List(MessageAndId(1, "", 5, "MAY", "The amount of logging is controlled by the logLevel setting, which takes values from the Level enumeration. Valid values are Error, Warn, Info, and Debug in order of increasing verbosity. The logging level may be configured globally, as described in the previous section, or it may be applied to a specific project, configuration, or task. For example, to change the logging level for compilation to only show warnings and errors:"),
//    MessageAndId(2, "", 20, "JUN", "Certain elements must be contained by an element that is defined as a block. This has nothing to do with the CSS display property, but with the semantics of HTML: The general idea is based on inlines being always children of blocks (which is, if you think of it, a good idea in general)"),
//    MessageAndId(3, "", 31, "MAY", "Every element in an HTML document can be either in front of or behind other element in the document. This is known as the stacking order. The rules to determine this order are pretty clearly defined in the spec, but as I've already stated, they're not fully understood by most developers."),
//    MessageAndId(4, "", 16, "SEP", "Affects the size of the element. Those scale values are \"unitless\" meaning it's essentially a multiplier. In the above syntax, if you apply one value it will stretch the element in both directions. So, scale(2) means \"make it twice as big as it just was.\" Giving it two values means to stretch it horizontally by the first value and vertically by the second."),
//    MessageAndId(5, "", 9, "NOV", "There are several different transform functions each that applies a different visual effect. Note that the actual space on the page that the element occupies remains the same as before transition."),
//    MessageAndId(6, "", 26, "JAN", "This value doesn't affect the element itself, but it affects the transforms of descendent elements 3D transforms, allowing them to all have a consistent depth perspective."))

  def fetch() = {
   messages.find().toList
  }

  def add(message: String) {
    def currentDay(): Int = DateTime.now().getDayOfMonth()
    def currentMonth(): String = {
      val months = Map((1, "JAN"), (2, "FEB"), (3, "MAR"), (4, "APR"), (5, "MAY"), (6, "JUN"), (7, "JUL"), (8, "AUG"), (9, "SEP"), (10, "OCT"), (11, "NOV"), (12, "DEC"))
      months(DateTime.now().getMonthOfYear())
    }

    val msg = JSON.parse(message).asInstanceOf[DBObject]
    msg += "day" -> currentDay().toString
    msg += "month" -> currentMonth()
    println(msg)
    messages.insert(msg)
  }
}
