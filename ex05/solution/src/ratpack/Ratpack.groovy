import static ratpack.groovy.Groovy.ratpack

import org.example.ratpack.UsernameHandler
import org.example.ratpack.User

ratpack {
  handlers {

    prefix('api/:username') {
      all {
        String username = pathTokens.username
        User user = new User(username: username, age: new Random().nextInt(100))
        next(single(user))
      }
      path("age", new UsernameHandler())

      all { User user ->
        render user.username
      }
    }

  }
}
