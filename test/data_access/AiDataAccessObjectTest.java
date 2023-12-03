package data_access;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class AiDataAccessObjectTest {

    private AiDataAccessObject aiDataAccessObject;
    @BeforeEach
    void setUp(){
        aiDataAccessObject = new AiDataAccessObject();
    }

    @Test
    void testGetAiExplanation(){
        String usersWord = "hello";
        String recommendedWord = "hi";
        String expectedPartialResponse = "hello";
        String actualResponse = aiDataAccessObject.getAiExplanation(usersWord, recommendedWord);
        assertTrue(actualResponse.toLowerCase().contains(expectedPartialResponse.toLowerCase()),
                "Tests that the expected partial response is present, this ensures that" +
                        " the API call is working");
    }

}
