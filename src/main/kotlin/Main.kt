typealias CodeBlock<T> = () -> T

inline fun <reified T> hardcode(block: CodeBlock<T>): T {
    return block()
}

inline fun <reified T> comment(block: CodeBlock<T>): Unit {}

inline fun <reified T> dev(block: CodeBlock<T>): T {
    val result = block()
    runCatching {
        val st = Thread.currentThread().stackTrace[1]
        println("dev: $result In ${st.className}.${st.methodName}")
    }
    return result
}
