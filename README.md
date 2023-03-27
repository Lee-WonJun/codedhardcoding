# codedhardcoding
**// comment is not enough**

Inspired by the functionality of Clojure's comment [macro](https://clojuredocs.org/clojure.core/comment), CodedHardcoding brings a similar concept to the Kotlin ecosystem, enabling developers to easily manage their code blocks for various purposes.


Comments are useful, but sometimes they fall short. When it comes to temporary code modifications, comments tend to be overlooked and become harder to find as time passes.

# Components
### hardcode
Use the hardcode function to execute a block of code and return its result:

```kotlin
val hardcodedValue = hardcode {
    "Hardcoded String"
}
println(hardcodedValue) // Output: Hardcoded String
```

### comment
Use the comment function to ignore a block of code and not execute it:

```kotlin
comment {
    println("This code will not be executed.")
}
```


### dev
Use the dev function to execute a block of code and print the result along with the calling class and method information:

```kotlin
class Example {
    fun test() {
        val result = dev {
            "Development String"
        }  // Output: dev: Development String In Example.test
        
        println(result) // Output: Development String
    }
}
```


### Comparison
```kotlin 
fun before() {
    // urls is hardcode
    val urls = listOf("https://www.google.com", "https://www.bing.com")

    //  urls.map { it.toInt() }  // temporary comment out

    val googleUrl = urls.first()
    println(googleUrl) // temporary print out
}

fun after() {
    val urls = hardcode { listOf("https://www.google.com", "https://www.bing.com") }
    
    comment { urls.map { it.toInt() } }
    
    val googleUrl = dev { urls.first() }
}
```


### Benefit
- You can benefit from rich IDE assistance.
![image](https://user-images.githubusercontent.com/10369528/228009845-88589e80-a6a7-49fa-8a8e-328d81f10bfb.png)


- You can manage comments in a compilable form.
![image](https://user-images.githubusercontent.com/10369528/228010051-5dc36509-04ad-4585-af93-13f22b5bd225.png)
![image](https://user-images.githubusercontent.com/10369528/228010530-881f6e1a-972d-4856-b12d-378ba330347d.png)



