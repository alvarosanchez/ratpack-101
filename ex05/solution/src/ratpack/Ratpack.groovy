import org.example.ratpack.User
import org.example.ratpack.UsernameHandler

import static ratpack.registry.Registries.just

import static ratpack.groovy.Groovy.ratpack

ratpack {
  handlers {

    prefix('api/:username') {

      handler {
        String username = pathTokens.username
        User user = new User(username: username, age: new Random().nextInt(100))
        next(just(user))
      }

      handler("age", new UsernameHandler())

      handler { User user ->
        response.send user.username
      }


    }



  }
}
