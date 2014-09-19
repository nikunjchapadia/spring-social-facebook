package org.springframework.social.facebook.api;

import org.junit.Test;

/**
 * <code>TestFacebookApi</code>
 *
 * @author Nikunj Chapadia
 * @version 9/18/14 4:43 PM (18 Sep 2014)
 */
public class TestFacebookApi extends AbstractFacebookApiTest {

    @Test
    public void testUserAccount() throws Exception{
        assertPrintable(facebook.userOperations().getUserProfile());
    }
}
