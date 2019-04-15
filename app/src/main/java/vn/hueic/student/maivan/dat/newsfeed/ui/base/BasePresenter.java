package vn.hueic.student.maivan.dat.newsfeed.ui.base;

public interface BasePresenter<T> {
    void setView(T view);

    void onStart();

    void onStop();
}
