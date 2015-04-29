import org.example.ratpack.User
import org.example.ratpack.UsernameHandler
import ratpack.jackson.JacksonModule

import static ratpack.registry.Registries.just
import static ratpack.jackson.Jackson.json


import static ratpack.groovy.Groovy.ratpack

ratpack {

  bindings {
    add new JacksonModule()
  }

  handlers {

    prefix('api/:username') {

      handler {
        String username = pathTokens.username
        User user = new User(username: username, age: new Random().nextInt(100))
        next(just(user))
      }

      handler("age", new UsernameHandler())

      handler { User user ->
        render json(user)
      }


    }



  }
}
