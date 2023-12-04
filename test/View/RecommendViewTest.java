package view;
import app.ClearUseCaseFactory;
import app.RecommendWordUseCaseFactory;
import app.SaveUseCaseFactory;
import data_access.AiDataAccessObject;
import data_access.SaveDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.ai_explanation.AiPresenter;
import interface_adapter.ai_explanation.AiViewModel;
import interface_adapter.clear_text.ClearController;
import interface_adapter.clear_text.ClearViewModel;
import interface_adapter.recommend_word.RecommendController;
import interface_adapter.recommend_word.RecommendViewModel;
import interface_adapter.save_text.SaveController;
import interface_adapter.save_text.SaveViewModel;
import interface_adapter.text_area.TextAreaViewModel;
import org.junit.jupiter.api.Assertions;
import interface_adapter.ai_explanation.AiController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.ai_explanation.*;
import javax.swing.*;

public class RecommendViewTest {
    AiController aiController;
    RecommendViewModel recommendViewModel;
    TextAreaView textAreaView;

    @BeforeEach
    public void init() {
        AiViewModel aiViewModel = new AiViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        AiDataAccessObject aiDataAccessObject= new AiDataAccessObject();
        AiOutputBoundary aiPresenter = new AiPresenter(viewManagerModel,aiViewModel);

        AiInteractor aiInteractor= new AiInteractor(aiDataAccessObject, aiPresenter);
        AiController aiController = new AiController(aiInteractor);
        RecommendViewModel recommendViewModel = new RecommendViewModel();
        RecommendController recommendController = RecommendWordUseCaseFactory.createRecommendController(viewManagerModel,recommendViewModel);
        SaveViewModel saveViewModel = new SaveViewModel();
        SaveDataAccessObject saveDataAccessObject = new SaveDataAccessObject();
        SaveController saveController= SaveUseCaseFactory.create(viewManagerModel,saveViewModel, saveDataAccessObject);
        TextAreaViewModel textAreaViewModel= new TextAreaViewModel();
        ClearViewModel clearViewModel = new ClearViewModel();
        ClearController clearController= ClearUseCaseFactory.create(viewManagerModel,clearViewModel,textAreaViewModel);


        TextAreaView textAreaView= new TextAreaView(aiController,recommendController,clearController,saveController,textAreaViewModel);

        this.aiController=aiController;
        this.recommendViewModel = recommendViewModel;
        this.textAreaView=textAreaView;
    }
    @Test
    public void recommendationTestGeneral() {
        RecommendView recommendView=new RecommendView(aiController, recommendViewModel,textAreaView, "Test");
        Assertions.assertEquals(recommendView.getTest().getText(),recommendView.getRecommendation());
    }
    @Test
    public void recommendationTestEmpty() {
        RecommendView recommendView=new RecommendView(aiController, recommendViewModel,textAreaView, "");
        Assertions.assertEquals(recommendView.getTest().getText(),recommendView.getRecommendation());
    }
    @Test
    public void recommendationTestSpace() {
        RecommendView recommendView=new RecommendView(aiController, recommendViewModel,textAreaView,
                "bread grass");
        Assertions.assertEquals(recommendView.getTest().getText(),recommendView.getRecommendation());
    }
    @Test
    public void replaceButtonTest() {
        RecommendView recommendView = new RecommendView(aiController, recommendViewModel,textAreaView,"Test");
        Assertions.assertTrue(recommendView.getReplaceButtonTest().isOpaque());
    }
    @Test
    public void aiButtonTest() {
        RecommendView recommendView = new RecommendView(aiController, recommendViewModel,textAreaView,"Test");
        Assertions.assertTrue(recommendView.getAiButtonTest().isOpaque());
    }


}
