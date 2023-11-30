package use_case.clear_text;

public class ClearInteractor implements ClearInputBoundary{
    final ClearOutputBoundary userPresenter;


    public ClearInteractor(ClearOutputBoundary userPresenter) {
        this.userPresenter = userPresenter;
    }


    @Override
    public void execute(ClearInputData clearInputData) {
        ClearOutputData clearOutputData = new ClearOutputData();
        userPresenter.prepareClearView(clearOutputData);

    }
}
