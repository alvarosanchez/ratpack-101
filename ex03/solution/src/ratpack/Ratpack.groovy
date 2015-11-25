import static ratpack.groovy.Groovy.ratpack

import org.example.ratpack.NowHandler

ratpack {
  handlers {

    all {
      println request.uri
      next()
    }

    path('foo') {
      render "bar"
    }

    prefix('api') {
      path('methods') {
        byMethod {
          get {
            render "GET /api/methods"
          }
          post {
            render "POST /api/methods"
          }
        }
      }

      path('now', new NowHandler())

      path(':username') {
        render "Hello $pathTokens.username"
      }
    }

  }
}
