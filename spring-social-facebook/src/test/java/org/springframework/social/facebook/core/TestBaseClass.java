package org.springframework.social.facebook.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.springframework.social.facebook.api.impl.FacebookTemplate;

import java.io.IOException;
import java.io.StringWriter;

/**
 * <code>TestBaseClass</code>
 *
 * @author Nikunj Chapadia
 * @version 9/18/14 5:36 PM (18 Sep 2014)
 */
public class TestBaseClass {

    protected static final String ACCESS_TOKEN = "CAAUsYG6fa4MBAA3LdT22Bc5yq0bVWrwhFmFKZBlDZA1cAefamSMIXLAxE8YPA7RiLI4ejsgBvt8xG63JL7m1TEWGNr4XwVBkSXeQwIaWte0S8mX9NkUtp2PFy0yYyUmsFkBWccXZCNagyMPAHW3uR5P1EepF4pmvmm3jEAAP1z1QhhGIN37kQkCCTU4zMgeoBZAtP4i2smPas40njDbJ";
    protected static final String APP_ACCESS_TOKEN = "8d3092f3760f630f660610e84e8a21be";

    public ObjectMapper mapper;
    protected FacebookTemplate template;

    @Before
    public void setUp() {
        this.template = createFacebookTemplate();
        this.mapper = this.template.getObjectMapper();
    }

    protected FacebookTemplate createFacebookTemplate() {
        return new FacebookTemplate(ACCESS_TOKEN);
    }

    public void assertPrintable(Object object) throws IOException {
        Assert.assertNotNull(object);
        StringWriter sw = new StringWriter();
        mapper.writeValue(sw, object);
        sw.close();
        System.out.println("--------------------------------------------------");
        System.out.println(object.getClass().getCanonicalName() + ":");
        System.out.println(sw.getBuffer().toString());
        System.out.println("--------------------------------------------------");
    }

    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////

}
