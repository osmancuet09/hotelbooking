package com.example.hotelbooking;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ReservationControllerTest {

    @Value(value="${server.port}")
    private int port;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getApiFailureTest() throws Exception {
        this.mockMvc.perform(get("http://localhost:8080/booking/ef07c50c-61ff-494b-937a-a01e60a082e")).andDo(print()).andExpect(status().isNotFound());
    }

//    @Test
//    public void getApiSuccessTest() throws Exception {
//        this.mockMvc.perform(get("http://localhost:8080/booking/ef07c50c-61ff-494b-937a-a01e60a082ef")).andDo(print()).andExpect(status().isOk());
//    }

}
