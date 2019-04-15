package vn.hueic.student.maivan.dat.newsfeed.data.model;

public class News {
    private String name;
    private String commentTotal;
    private String time;
    private String link;

    public News(String name, String commentTotal, String time, String link) {
        this.name = name;
        this.commentTotal = commentTotal;
        this.time = time;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommentTotal() {
        return commentTotal;
    }

    public void setCommentTotal(String commentTotal) {
        this.commentTotal = commentTotal;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
