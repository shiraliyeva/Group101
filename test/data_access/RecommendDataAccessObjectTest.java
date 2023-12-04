package data_access;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RecommendDataAccessObjectTest {
    private RecommendDataAccessObject recommendDataAccessObject;
    @BeforeEach
    void init() {
        recommendDataAccessObject = new RecommendDataAccessObject();
    }
    @Test
    void notNullTest() {
        String response = recommendDataAccessObject.getRecommendation("hello");
        Assertions.assertNotNull(response);
    }
    @Test
    void NullTest() {
        String response = recommendDataAccessObject.getRecommendation("");
        Assertions.assertNull(response);
    }


}
