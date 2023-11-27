package interface_adapter.recommend_word;

import app.RecommendWordUseCaseFactory;
import entity.Text;
import interface_adapter.ViewManagerModel;
import interface_adapter.recommend_word.RecommendState;
import interface_adapter.recommend_word.RecommendViewModel;
import use_case.recommend_word.RecommendInteractor;
import use_case.recommend_word.RecommendOutputBoundary;
import view.TextAreaView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RecommendPresenter implements RecommendOutputBoundary {
    private final RecommendViewModel recommendViewModel;


    private ViewManagerModel viewManagerModel;


    public RecommendPresenter(ViewManagerModel viewManagerModel,
                              RecommendViewModel recommendViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.recommendViewModel = recommendViewModel;

    }

    public StringBuilder getRecommendation(String text) {
        String apiUrl = "https://www.stands4.com/services/v2/syno.php?uid=12086&tokenid=CdUkpotEswlcqlbU&word=" + text;

        try {

            URL url = new URL(apiUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");


            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            connection.disconnect();
            int start=response.indexOf("<synonyms>");
            int end=response.indexOf("</synonyms>");
            System.out.println(response);

            response.delete(end,response.length());
            response.delete(0,start);
            start=response.indexOf(">");
            response.delete(0,start+1);
            System.out.println(response);
            end=response.indexOf(",");
            response.delete(end,response.length());


            return response;



        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public void prepareRecommendView(StringBuilder recommendation, TextAreaView textAreaView) {
        RecommendState recommendState = recommendViewModel.getState();
        recommendState.setRecommendText(recommendation);
        this.recommendViewModel.setState(recommendState);
        recommendViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(recommendViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        RecommendWordUseCaseFactory.createRecommendView(recommendViewModel, recommendation, textAreaView);

    }

}



