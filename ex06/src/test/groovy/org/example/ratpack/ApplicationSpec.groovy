package org.example.ratpack

import groovy.json.JsonSlurper
import ratpack.groovy.test.GroovyRatpackMainApplicationUnderTest
import ratpack.test.ApplicationUnderTest
import ratpack.test.http.TestHttpClient
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class ApplicationSpec extends Specification {

    @Shared ApplicationUnderTest aut = new GroovyRatpackMainApplicationUnderTest()

    @Delegate TestHttpClient testClient = aut.httpClient

    void "it renders the User in JSON format when /api/foo is requested"() {
        when:
        def json = new JsonSlurper().parseText(getText('api/foo'))

        then:
        json.username == 'foo'
        json.age instanceof Integer
    }

    @Unroll
    void "it renders a random age when /api/foo/age is requested"() {
        when:
        Integer.parseInt(getText("api/foo/age"))

        then:
        notThrown(NumberFormatException)
    }


}
