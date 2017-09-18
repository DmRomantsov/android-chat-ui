package co.intentservice.chatui.models;

import android.text.format.DateFormat;

import java.util.concurrent.TimeUnit;

public class ChatMessage {
    private Long id;
    private String message;
    private long timestamp;
    private Type type;
    private String additionalText;

    public ChatMessage(Long id, String message, long timestamp, Type type, String additionalText){
        this.id = id;
        this.message = message;
        this.timestamp = timestamp;
        this.type = type;
        this.additionalText = additionalText;
    }

    public ChatMessage(Long id, String message, long timestamp, Type type) {
       this(id, message, timestamp, type, null);
    }

    public ChatMessage(String message, long timestamp, Type type){
        this(null, message, timestamp, type, null);
    }

    public Long getId() {
        return id;
    }

    public ChatMessage(Long id) {
        this.id = id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getAdditionalText() {
        return additionalText;
    }

    public void setAdditionalText(String additionalText) {
        this.additionalText = additionalText;
    }

    public void clearAdditionalText() {
        this.additionalText = null;
    }

    public String getFormattedTime(){

        long oneDayInMillis = TimeUnit.DAYS.toMillis(1); // 24 * 60 * 60 * 1000;

        long timeDifference = System.currentTimeMillis() - timestamp;

        return timeDifference < oneDayInMillis
                ? DateFormat.format("hh:mm a", timestamp).toString()
                : DateFormat.format("dd MMM - hh:mm a", timestamp).toString();
    }

    public enum Type {
        SENT, RECEIVED
    }
}
