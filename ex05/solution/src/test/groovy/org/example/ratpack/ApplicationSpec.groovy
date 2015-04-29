package org.example.ratpack

import ratpack.groovy.test.GroovyRatpackMainApplicationUnderTest
import ratpack.test.ApplicationUnderTest
import ratpack.test.http.TestHttpClient
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class ApplicationSpec extends Specification {

    @Shared ApplicationUnderTest aut = new GroovyRatpackMainApplicationUnderTest()

    @Delegate TestHttpClient testClient = aut.httpClient

    void "it echoes the username when /api/foo is requested"() {
        expect:
        getText('api/foo') == 'foo'
    }

    @Unroll
    void "it renders a random age when /api/foo/age is requested"() {
        when:
        Integer.parseInt(getText("api/foo/age"))

        then:
        notThrown(NumberFormatException)
    }


}
