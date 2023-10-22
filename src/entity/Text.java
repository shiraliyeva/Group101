package entity;
import java.time.LocalDateTime;

public class Text {
    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(LocalDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    private LocalDateTime modifiedTime;

    public Text(String title, String content, LocalDateTime modifiedTime) {
        this.title = title;
        this.content = content;
        this.modifiedTime = modifiedTime;
    }
}
