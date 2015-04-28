package org.example.ratpack

import ratpack.groovy.test.GroovyRatpackMainApplicationUnderTest
import ratpack.test.ApplicationUnderTest
import ratpack.test.http.TestHttpClient
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

import java.text.ParseException
import java.text.SimpleDateFormat

class ApplicationSpec extends Specification {

    @Shared ApplicationUnderTest aut = new GroovyRatpackMainApplicationUnderTest()

    @Delegate TestHttpClient testClient = aut.httpClient

    void "it renders foo when /bar is requested"() {
        when:
        get('foo')

        then:
        response.body.text == 'bar'
    }

    @Unroll
    void "it renders the correct output when a #method.toUpperCase() request is sent to /api/methods"() {
        when:
        "${method}"("api/methods")

        then:
        response.body.text == "${method.toUpperCase()} /api/methods".toString()

        where:
        method << ['get', 'post']
    }

    void "it returns a date when /api/now is requested"() {
        when:
        String response = getText("api/now")
        new SimpleDateFormat().parse(response)

        then:
        notThrown(ParseException)
    }


}
