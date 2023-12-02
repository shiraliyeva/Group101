package use_case.recommend_word;
import org.junit.jupiter.api.Test;
import use_case.recommend_word.RecommendInputData;

import static org.junit.jupiter.api.Assertions.*;

class RecommendInputDataTest {

    @Test
    public void getTest() {
        RecommendInputData recommendInputData= new RecommendInputData("test");
        assertEquals("test",recommendInputData.getText());
    }
    @Test
    public void setTest() {
        RecommendInputData recommendInputData = new RecommendInputData("");
        recommendInputData.setText("bread");
        assertEquals("bread", recommendInputData.getText());
        recommendInputData.setText("");
        assertEquals("",recommendInputData.getText());
    }
}