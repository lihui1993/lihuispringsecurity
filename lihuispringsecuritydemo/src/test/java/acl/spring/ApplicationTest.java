package acl.spring;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.net.URI;
import java.net.URL;

/**
 * Unit test for simple Application.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class ApplicationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void getMockMvc() {
        mockMvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void saySomething() throws Exception {
        URI uri=URI.create("http://127.0.0.1:8088/saySomething");
        String string = mockMvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_UTF8))
             .andExpect(MockMvcResultMatchers.status().isOk())
             .andReturn().getResponse().getContentAsString();
        log.info(string);
    }
}
