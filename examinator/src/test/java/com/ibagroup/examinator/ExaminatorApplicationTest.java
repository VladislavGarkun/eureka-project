package com.ibagroup.examinator;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

//@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ExaminatorApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
//@ConfigurationProperties(prefix = "properties")
//@PropertySource(value = "classpath:application-test.properties")
@ActiveProfiles("test")
public class ExaminatorApplicationTest {

    @Autowired
    //private MockMvc mockMvc;
    private TestRestTemplate testRestTemplate;

    @Autowired
    private TicketRepo repo;

    private static final String MATH = "math";
    private static final String PHYSIC = "physic";

    @Value("${spring.datasource.username:}")
    private String userName;

    @Test
    public void examinatorTest() throws Exception {
//        this.mockMvc.perform(get("/examinator").param("subject", "math-3", "physic-2"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.length()").value(5));

        assertThat(this.testRestTemplate.getForObject("http://localhost:8081/examinator?subject=math-3&subject=physic-2", List.class).size()).isEqualTo(5);
    }

    @Test
    public void nameTest(){
        assertThat(userName).isEqualTo("Vladislav");
    }

    @Test
    public void h2DBTest(){
        assertThat(this.repo.findAll().size()).isEqualTo(20);
    }

}