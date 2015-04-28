import org.example.ratpack.NowHandler
import org.example.ratpack.UsernameHandler

import static ratpack.groovy.Groovy.ratpack

ratpack {
  handlers {

    handler {
      println request.uri
      next()
    }

    handler('foo') {
      render 'bar'
    }

    prefix('api') {

      handler('methods') {

        byMethod {

          get {
            render "GET /api/methods"
          }

          post {
            render "POST /api/methods"
          }

        }
      }

      handler('now', new NowHandler())

      handler(':username', new UsernameHandler())

    }



  }
}
