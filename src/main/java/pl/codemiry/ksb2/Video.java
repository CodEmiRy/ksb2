package pl.codemiry.ksb2;

public class Video {
    private Long id;
    private String title;

    public Video(Long id, String title, String url) {
        this.id = id;
        this.title = title;
        this.url = url;
    }

    public Video() {
    }

    private String url;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
