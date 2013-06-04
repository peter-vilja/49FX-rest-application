package fi.peter.fx.domain

import org.joda.time.DateTime

case class MessageAndId(id: Int, icon: String, day: Int, month: String, message: String)
case class Message(icon: String, message: String)

object MessageRepository {

  var messages = List(MessageAndId(1, "", 5, "May", "The amount of logging is controlled by the logLevel setting, which takes values from the Level enumeration. Valid values are Error, Warn, Info, and Debug in order of increasing verbosity. The logging level may be configured globally, as described in the previous section, or it may be applied to a specific project, configuration, or task. For example, to change the logging level for compilation to only show warnings and errors:"),
    MessageAndId(2, "", 20, "Jun", "Certain elements must be contained by an element that is defined as a block. This has nothing to do with the CSS display property, but with the semantics of HTML: The general idea is based on inlines being always children of blocks (which is, if you think of it, a good idea in general)"),
    MessageAndId(3, "", 31, "May", "Every element in an HTML document can be either in front of or behind other element in the document. This is known as the stacking order. The rules to determine this order are pretty clearly defined in the spec, but as I've already stated, they're not fully understood by most developers."))

  def fetch() = messages

  def add(message: Message) {
    def currentDay(): Int = DateTime.now().getDayOfMonth()
    def currentMonth(): String = {
      val months = Map((1, "Jan"), (2, "Feb"), (3, "Mar"), (4, "Apr"), (5, "May"), (6, "Jun"), (7, "Jul"), (8, "Aug"), (9, "Sep"), (10, "Oct"), (11, "Nov"), (12, "Dec"))
      months(DateTime.now().getMonthOfYear())
    }

    val id = messages.last.id + 1
    val test = MessageAndId(id, message.icon, currentDay(), currentMonth(), message.message)
    messages = messages :+ test
  }
}
