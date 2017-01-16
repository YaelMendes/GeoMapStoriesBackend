package main.story;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by YME on 09.01.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StoryControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void noParamShouldReturnAllStories() throws Exception {

        Story aStory = new Story("description", LocalDate.of(2010, 5, 5));
        this.mockMvc.perform(get("/stories")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value(aStory));
    }

}

