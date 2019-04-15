package vn.hueic.student.maivan.dat.newsfeed.data.model;

public class News {
    private String name;
    private String commentTotal;
    private String time;

    public News(String name, String commentTotal, String time) {
        this.name = name;
        this.commentTotal = commentTotal;
        this.time = time;
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
}
