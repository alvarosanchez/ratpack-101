@Grab('org.slf4j:slf4j-simple:1.7.12')
@Grab('io.ratpack:ratpack-groovy:1.1.1')
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
