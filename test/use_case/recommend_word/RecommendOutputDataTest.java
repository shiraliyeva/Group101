package use_case.recommend_word;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class RecommendOutputDataTest {
    RecommendOutputData recommendOutputData;

    @BeforeEach
    void createRecommendOutputData() {
        RecommendOutputData recommendOutputData= new RecommendOutputData("");
        this.recommendOutputData=recommendOutputData;
    }

    @Test
    void getRecommendationTest() {
        assert(Objects.equals(recommendOutputData.getRecommendation(), ""));
        RecommendOutputData recommendOutputData1= new RecommendOutputData("test");
        assertEquals("test",recommendOutputData1.getRecommendation());
    }

    @Test
    void setRecommendationTest() {;
        recommendOutputData.setRecommendation("test1");
        assertEquals("test1",recommendOutputData.getRecommendation());
        recommendOutputData.setRecommendation("");
        assertEquals("", recommendOutputData.getRecommendation());
    }
}