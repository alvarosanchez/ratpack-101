package org.example.ratpack

import ratpack.test.handling.HandlingResult
import ratpack.test.handling.RequestFixture
import spock.lang.Specification
import spock.lang.Unroll

class UsernameHandlerSpec extends Specification {

    @Unroll
    void "it renders \"#response\" when the username is \"#pathToken\""() {
        when:
        HandlingResult result = RequestFixture.handle(new UsernameHandler()) { RequestFixture fixture ->
            fixture.pathBinding([username: pathToken])
        }

        then:
        result.rendered(String) == response

        where:
        pathToken   | response
        'Homer'     | 'Hello, Homer!'
        ''          | 'Hello World!'
    }

}