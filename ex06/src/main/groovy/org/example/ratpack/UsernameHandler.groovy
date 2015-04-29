package org.example.ratpack

import ratpack.handling.Context
import ratpack.handling.Handler

class UsernameHandler implements Handler {

    @Override
    void handle(Context ctx) throws Exception {
        User user = ctx.get(User)
        ctx.response.send user.age.toString()
    }

}
