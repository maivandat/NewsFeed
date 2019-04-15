package vn.hueic.student.maivan.dat.newsfeed.ui.news;

import java.util.List;

import vn.hueic.student.maivan.dat.newsfeed.data.model.News;
import vn.hueic.student.maivan.dat.newsfeed.ui.base.BasePresenter;
import vn.hueic.student.maivan.dat.newsfeed.ui.base.BaseView;

public interface NewsContact {
    interface View extends BaseView {
        void updateNews(List<News> list);
    }
    interface Presenter extends BasePresenter<View> {
        void news();
    }
}
