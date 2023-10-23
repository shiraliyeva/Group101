package entity;
import java.time.LocalDateTime;

public class InputText {
    private String title;
    private StringBuilder content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public StringBuilder getContent() {
        return content;
    }

    public void setContent(StringBuilder content) {
        this.content = content;
    }

    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(LocalDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    private LocalDateTime modifiedTime;

    public InputText(String title, StringBuilder content, LocalDateTime modifiedTime) {
        this.title = title;
        this.content = content;
        this.modifiedTime = modifiedTime;
    }
}
