package com.zim.posapatterns.pattern.gof.builder;

/**
 * Created by martin.zangl on 7/25/14.
 */
public class EmailMessage {

    private String from;
    private String to;
    private String subject;
    private String content;
    private String mimeType;

    private EmailMessage() {
    }


    /** builder interfaces */

    public interface ITo{
        ISubject to(String to);
    }

    public interface ISubject{
        IContent subject(String subject);
    }

    public interface IContent{
        IBuild content(String content);
    }
    public interface IBuild{
        IBuild mimeType(String mimeType);

        EmailMessage build();
    }

    private static ITo from(String from){
        return new Builder(from);
    }

    private static class Builder implements ITo, ISubject, IContent, IBuild{
        private EmailMessage instance = new EmailMessage();

        public Builder(String from){
            instance.from = from;
        }

        @Override
        public IBuild mimeType(String mimeType) {
            instance.mimeType = mimeType;
            return this;
        }

        @Override
        public EmailMessage build() {
            return instance;
        }

        @Override
        public IBuild content(String content) {
            instance.content = content;
            return this;
        }

        @Override
        public IContent subject(String subject) {
            instance.subject = subject;
            return this;
        }

        @Override
        public ISubject to(String to) {
            instance.to = to;
            return this;
        }
    }

    public static void main(String[] args) {
        EmailMessage emailMessage = EmailMessage
                .from("some from@asd.com")
                .to("to@asd.com")
                .subject("some subject")
                .content("some content")
                .build();
    }
}
