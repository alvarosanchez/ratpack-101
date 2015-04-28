package org.example.ratpack

import ratpack.handling.Context
import ratpack.handling.Handler

class UsernameHandler implements Handler {

    @Override
    void handle(Context ctx) throws Exception {
        String username = ctx.pathTokens.username
        if (username) {
            ctx.render "Hello, ${username}!".toString()
        } else {
            ctx.render "Hello World!"
        }
    }

}
