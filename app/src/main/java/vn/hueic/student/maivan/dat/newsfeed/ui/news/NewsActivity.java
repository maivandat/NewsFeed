package vn.hueic.student.maivan.dat.newsfeed.ui.news;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Toast;

import java.util.List;

import vn.hueic.student.maivan.dat.newsfeed.R;
import vn.hueic.student.maivan.dat.newsfeed.data.model.News;
import vn.hueic.student.maivan.dat.newsfeed.ui.adapter.NewsAdapter;
import vn.hueic.student.maivan.dat.newsfeed.ui.base.BaseActivity;

public class NewsActivity extends BaseActivity implements NewsContact.View {
    RecyclerView recyclerView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        NewsPresenter newsPresenter = new NewsPresenter(this);
        newsPresenter.setView(this);
        newsPresenter.news();
    }

    @Override
    public void updateNews(List<News> list) {
        NewsAdapter adapter = new NewsAdapter(this, list);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_app, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public void showLoadingIndicator() {
        Toast.makeText(this, "Bắt đầu quá trình cập nhập", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideLoadingIndicator() {
        Toast.makeText(this, "Cập nhập thành công", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginError(Throwable throwable) {

    }
}
