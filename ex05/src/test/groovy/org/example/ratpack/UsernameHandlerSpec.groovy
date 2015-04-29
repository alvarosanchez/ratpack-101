package org.example.ratpack

import ratpack.test.handling.HandlingResult
import ratpack.test.handling.RequestFixture
import spock.lang.Specification

class UsernameHandlerSpec extends Specification {

    void "it renders a random age when /user/foo/age is called"() {
        when:
        HandlingResult result = RequestFixture.handle(new UsernameHandler()) { RequestFixture fixture ->
            fixture.pathBinding([username: 'foo']).registry.add(User, new User(username: 'foo', age: 50))
        }

        then:
        result.bodyText == '50'

    }

}