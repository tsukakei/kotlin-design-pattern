package creationalPatterns

data class Mail(val to: String,
                var title: String = "",
                var message: String = "",
                val cc: List<String> = listOf(),
                val bcc: List<String> = listOf()) {
}

class MailBuilder(val to: String) {
    private var mail: Mail = Mail(to)
    fun title(title: String) : MailBuilder {
        mail.title = title
        return this
    }

    fun build() : Mail {
        return mail
    }
}

fun main(args: Array<String>) {
    val mail = MailBuilder("hello@mail.com").title("Title").build()
}