package main.story;

import main.story.objects.Address;
import main.story.objects.Story;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
    @Ignore
    public void noParamShouldReturnAllStories() throws Exception {

        Story aStory = new Story("description", new Address("test add"), Date.from(Instant.now()));
        this.mockMvc.perform(get("/stories")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value(aStory));
    }

    @Test
    public void testMyReduce() {

        List<Story> stories = Arrays.asList(
                new Story("desc", new Address("Paris"), new Date()),
                new Story("desc", new Address("Strasbourg"), new Date())
        );
    }

     @Test
    public  void test() {
        /* Create an object of `Item` and set values */
        Item itemSamsungGalaxy6 = new Item();
        itemSamsungGalaxy6.setName("Samsung Galaxy 6");
        itemSamsungGalaxy6.setQuantity(20);

        Item itemNexus = new Item();
        itemNexus.setName("Nexus 5");
        itemNexus.setQuantity(12);

        /**
         * - Create `List` of `Item`
         * - Add `itemSamsungGalaxy6` and `itemNexus` to List.
         */
        List<Item> listItems = new ArrayList<>();
        listItems.add(itemSamsungGalaxy6);
        listItems.add(itemNexus);

        /**
         * JavaDoc: `mapToInt` method
         * Returns an IntStream consisting of the results of applying the given function to the elements of this stream.
         *
         * Explanation: `.mapToInt(Item::getQuantity)` / `.mapToInt(item -> item.getQuantity())`
         * In this operation we are calling method `getQuantity()` on each object of `Item` in List.
         * That returns the `IntStream` of value(Quantity) of all object in List.
         * And we are doing summation of all quantity
         */
        int totalQuantity = listItems.stream()
                .mapToInt(Item::getQuantity)
                .sum();

        // avec mapToInt
        System.out.println("Total Quantity: " + totalQuantity);

        // avec reduce
         totalQuantity = listItems.stream()
                 .map(Item::getQuantity)
                 .reduce((a,b) -> a+b).get();

         System.out.println("Total Quantity: " + totalQuantity);
    }
}

class Item {
    private String Name;
    private int Quantity;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }
}
