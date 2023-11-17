package use_case.clear_text;

public class ClearInteractor implements ClearInputBoundary{
    final ClearOutputBoundary clearPresenter;

    public ClearInteractor(ClearOutputBoundary clearPresenter) {
        this.clearPresenter = clearPresenter;
    }

    public void ClearData() {
        ClearOutputData clearOutputData = new ClearOutputData();
        clearPresenter.prepareSuccessView(clearOutputData);
    }
}
