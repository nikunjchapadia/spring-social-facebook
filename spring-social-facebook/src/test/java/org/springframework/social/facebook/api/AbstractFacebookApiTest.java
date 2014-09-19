/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.facebook.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.test.web.client.MockRestServiceServer;

import java.io.IOException;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AbstractFacebookApiTest {
	protected static final String ACCESS_TOKEN = "CAAUsYG6fa4MBAIqKVW7FJk6NNqXSEfYoHY4OuEcwsLQEZAhtWgjnUlAH7aGQVh710zv2uO0e4UYge2rJ0O7r8HBSdWQqG8TXX42mpUuiE7ZB0RZCrAENZCm9BOCfbSEMq1ZB2zRTRDiCbc1APa9TZAtoWki5IjXvsrWObZAeG11AGI67fSJnQkgao7kqWEazR17mjARbRH32LEkOKukZBFKJ";
	protected static final String APP_ACCESS_TOKEN = "8d3092f3760f630f660610e84e8a21be";

	protected FacebookTemplate facebook;
	protected FacebookTemplate unauthorizedFacebook;
	protected FacebookTemplate appFacebook;
	protected MockRestServiceServer mockServer;
	protected MockRestServiceServer unauthorizedMockServer;
	protected MockRestServiceServer appFacebookMockServer;

    private ObjectMapper objectMapper;
	@Before
	public void setup() {
		facebook = createFacebookTemplate();
		mockServer = MockRestServiceServer.createServer(facebook.getRestTemplate());
		
		unauthorizedFacebook = new FacebookTemplate();
		unauthorizedMockServer = MockRestServiceServer.createServer(unauthorizedFacebook.getRestTemplate());
		
		appFacebook = new FacebookTemplate(APP_ACCESS_TOKEN);
		appFacebookMockServer = MockRestServiceServer.createServer(appFacebook.getRestTemplate());

        objectMapper = facebook.getObjectMapper();
	}

	protected FacebookTemplate createFacebookTemplate() {
		return new FacebookTemplate(ACCESS_TOKEN);
	}

	protected Resource jsonResource(String filename) {
		return new ClassPathResource(filename + ".json", getClass());
	}

	protected Date toDate(String dateString) {
		try {
			return FB_DATE_FORMAT.parse(dateString);
		} catch (ParseException e) {
			return null;
		}
	}

	private static final DateFormat FB_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.ENGLISH);

    public void assertPrintable(Object object) throws IOException {
        Assert.assertNotNull(object);
        StringWriter sw = new StringWriter();
        objectMapper.writeValue(sw, object);
        sw.close();
        System.out.println("--------------------------------------------------");
        System.out.println(object.getClass().getCanonicalName() + ":");
        System.out.println(sw.getBuffer().toString());
        System.out.println("--------------------------------------------------");
    }

}
