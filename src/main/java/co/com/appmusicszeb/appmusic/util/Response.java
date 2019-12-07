package co.com.appmusicszeb.appmusic.util;

public class Response<A> {
    private A messageBody;
    private int codeMessage;
    private String message;
    private Boolean state;

    public Response() {
    }

    public A getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(A messageBody) {
        this.messageBody = messageBody;
    }

    public int getCodeMessage() {
        return codeMessage;
    }

    public void setCodeMessage(int codeMessage) {
        this.codeMessage = codeMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
