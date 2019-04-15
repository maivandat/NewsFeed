package vn.hueic.student.maivan.dat.newsfeed.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import vn.hueic.student.maivan.dat.newsfeed.AppContacts;
import vn.hueic.student.maivan.dat.newsfeed.R;
import vn.hueic.student.maivan.dat.newsfeed.data.model.News;
import vn.hueic.student.maivan.dat.newsfeed.ui.newsdetail.NewsDetailActivity;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {
    Context mContext;
    List<News> newsList;

    public NewsAdapter(Context mContext, List<News> newsList) {
        this.mContext = mContext;
        this.newsList = newsList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvCommentTotal;
        TextView tvTime;
        TextView tvView;
        News item;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvTime = itemView.findViewById(R.id.tv_time);
            tvCommentTotal = itemView.findViewById(R.id.tv_commentTotal);
            tvView = itemView.findViewById(R.id.tv_view);

        }

        public void setData(News news){
            this.item = news;

            tvName.setText(news.getName());
            tvCommentTotal.setText("Comment: " + news.getCommentTotal());
            tvTime.setText(news.getTime());

        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_news, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        myViewHolder.setData(newsList.get(i));
        myViewHolder.tvView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, NewsDetailActivity.class);
                intent.putExtra(AppContacts.KEY_LINK, newsList.get(i).getLink());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }


}
