package org.example.ratpack

import ratpack.handling.Context
import ratpack.handling.Handler

import java.text.SimpleDateFormat

class NowHandler implements Handler {

    @Override
    void handle(Context ctx) throws Exception {
        ctx.response.send new SimpleDateFormat().format(new Date())
    }


}
