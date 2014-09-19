package org.springframework.social.facebook.core;

import org.junit.Test;

/**
 * <code>TestFacebookAccount</code>
 *
 * @author Nikunj Chapadia
 * @version 9/18/14 5:36 PM (18 Sep 2014)
 */
public class TestFacebookAccount extends TestBaseClass {

    @Test
    public void testFacebookAccount() throws Exception{
        assertPrintable(template.userOperations().getUserProfile());
    }
}
