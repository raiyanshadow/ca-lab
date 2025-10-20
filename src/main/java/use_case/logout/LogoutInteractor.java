package use_case.logout;

import data_access.DBUserDataAccessObject;

/**
 * The Logout Interactor.
 */
public class LogoutInteractor implements LogoutInputBoundary {
    private LogoutUserDataAccessInterface userDataAccessObject;
    private LogoutOutputBoundary logoutPresenter;

    public LogoutInteractor(LogoutUserDataAccessInterface userDataAccessInterface,
                            LogoutOutputBoundary logoutOutputBoundary) {
        userDataAccessObject = userDataAccessInterface;
        logoutPresenter = logoutOutputBoundary;
    }

    @Override
    public void execute() {
        String currName = userDataAccessObject.getCurrentUsername();
        userDataAccessObject.setCurrentUsername(null);
        LogoutOutputData outputData = new LogoutOutputData(currName);
        logoutPresenter.prepareSuccessView(outputData);
    }
}

