import org.example.ratpack.User
import org.example.ratpack.UsernameHandler

import static ratpack.jackson.Jackson.json

import static ratpack.groovy.Groovy.ratpack

ratpack {

  bindings {
  }

  handlers {

    prefix('api/:username') {

      all {
        String username = pathTokens.username
        User user = new User(username: username, age: new Random().nextInt(100))
        next(single(user))
      }

      path ("age", new UsernameHandler())

      path { User user ->
        render json(user)
      }


    }



  }
}
