package com.webapplication.controller;

import com.Application;
import com.google.gson.Gson;
import com.webapplication.authentication.Authenticator;
import com.webapplication.dto.user.SessionInfo;
import com.webapplication.dto.user.UserLogInRequestDto;
import com.webapplication.dto.user.UserLogInResponseDto;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class UserControllerTest {
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private Authenticator authenticator;

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
                .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
                .findAny()
                .orElse(null);

        assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }
    @Test
    public void userValidUserShouldLogin() throws Exception {
        UserLogInRequestDto logInRequestDto = new UserLogInRequestDto();
        logInRequestDto.setEmail("jimseinta@gmail.com");
        logInRequestDto.setPassword("seinta");
        Gson gson = new Gson();
        String json = gson.toJson(logInRequestDto);
        mockMvc.perform(post("/api/login/")
                .content(json)
                .contentType(contentType))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId", is(5)))
                .andExpect(jsonPath("$.role", is("parent")));

    }



    @Test
    public void userUserShouldBeReturned() throws Exception {
        SessionInfo session = new SessionInfo(1, DateTime.now().plusMinutes(Authenticator.SESSION_TIME_OUT_MINUTES), "parent");
        UUID authToken = authenticator.createSession(session);

        mockMvc.perform(get("/api/user/1")
                .header("authToken", authToken))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email", is("a@a.com")))
                .andExpect(jsonPath("$.name", is("Jack")))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.surname", is("Bauer")))
                .andExpect(jsonPath("$.validated", is(true)))
                .andExpect(jsonPath("$.parentDto.points", is(20)));

    }

    @Test
    public void userInvalidTokenRequestShouldBeIgnored() throws Exception {
        UUID invalidAuthToken = new UUID(0, 0);

        mockMvc.perform(get("/api/user/1")
                .header("authToken", invalidAuthToken))
                .andDo(print())
                .andExpect(status().isUnauthorized());

    }
}

