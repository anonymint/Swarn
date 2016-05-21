package com.anonymint;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import java.util.Random;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class TheSwarnApplicationTests {

    @Value("${local.server.port}")
    private int port;

    private final RestTemplate template = new TestRestTemplate();
    private final Random random = new Random();
    private final String v2Url = "http://localhost:%s/api/v2/data/%d";


    @Test
    public void apiget() {
        Long testId = random.nextLong();
        ResponseEntity<Data> response = template.getForEntity(String.format(v2Url, port, testId), Data.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(response.getBody().getAction(), RequestMethod.GET.name());
        assertEquals(response.getBody().getId(), testId.longValue());
    }

    @Test
    public void apiPost() {
        Long testId = random.nextLong();
        ResponseEntity<Data> response = template.postForEntity(String.format(v2Url, port, testId), null, Data.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(response.getBody().getAction(), RequestMethod.POST.name());
        assertEquals(response.getBody().getId(), testId.longValue());
    }

}
