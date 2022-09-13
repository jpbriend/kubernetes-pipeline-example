package com.cloudbees.example.mobile.deposit.api;

import com.cloudbees.example.mobile.deposit.api.model.Deposit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = MobileDepositApplication.class, webEnvironment=RANDOM_PORT)
public class DepositEndpointTests {

    @Value("${local.server.port}")
    private int port;

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void testGetDepositAccount() {
        ResponseEntity<Deposit> entity = this.restTemplate.getForEntity(
                "http://localhost:" + this.port + "/account/deposit", Deposit.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());


        Deposit deposit = entity.getBody();
        assertEquals("Free Checking", deposit.getName());

    }

}
