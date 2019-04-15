package vn.hueic.student.maivan.dat.newsfeed.ui.news;


import android.content.Context;
import android.os.AsyncTask;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import vn.hueic.student.maivan.dat.newsfeed.AppContacts;
import vn.hueic.student.maivan.dat.newsfeed.data.XMLDOMParser;
import vn.hueic.student.maivan.dat.newsfeed.data.model.News;

public class NewsPresenter implements NewsContact.Presenter {
    private Context mContext;
    private NewsContact.View mView;

    public NewsPresenter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void setView(NewsContact.View view) {
        this.mView = view;
    }

    @Override
    public void news() {
        ReadRSS readRSS = new ReadRSS();
        readRSS.execute(AppContacts.HOST_RSS);
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    public class ReadRSS extends AsyncTask<String, Void, String> {
        List<News> list;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mView.showLoadingIndicator();
            list = new ArrayList<>();
        }

        @Override
        protected String doInBackground(String... strings) {
            StringBuilder content = new StringBuilder();
            try {
                URL url = new URL(strings[0]);

                InputStreamReader isr = new InputStreamReader(url.openConnection().getInputStream());

                BufferedReader bfr = new BufferedReader(isr);
                String line = "";
                while ((line = bfr.readLine()) != null) {
                    content.append(line);
                }

                bfr.close();
                isr.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return content.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            mView.hideLoadingIndicator();
            XMLDOMParser parser = new XMLDOMParser();
            Document document = parser.getDocument(s);
            // Lấy từng item vào nodelist
            String name;
            String comment;
            String time;
            NodeList nodeList = document.getElementsByTagName("item");
            for (int i = 0; i < nodeList.getLength(); i++){
                Element element = (Element) nodeList.item(i);
                name = parser.getValue(element, "title");
                comment = parser.getValue(element, "slash:comments");
                time = parser.getValue(element, "pubDate");
                News news = new News(name, comment, time);
                list.add(news);
            }
            mView.updateNews(list);
        }

    }
}
