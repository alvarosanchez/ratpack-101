@Grab('io.ratpack:ratpack-groovy:1.0.0')
import static ratpack.groovy.Groovy.ratpack

ratpack {
    handlers {
        get(":name") {
            render "Hello $pathTokens.name!"
        }
        get {
            render "Hello World!"
        }
    }
}
