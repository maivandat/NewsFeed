package vn.hueic.student.maivan.dat.newsfeed.ui.base;

public interface BaseView {
    void showLoadingIndicator();

    void hideLoadingIndicator();

    void showLoginError(Throwable throwable);
}
