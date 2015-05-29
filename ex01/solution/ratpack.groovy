@Grab('io.ratpack:ratpack-groovy:0.9.16')
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
