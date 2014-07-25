package com.zim.posapatterns.pattern.gof.builder;

import com.fluentinterface.ReflectionBuilder;
import com.fluentinterface.builder.Builder;

/**
 * Created by martin.zangl on 7/25/14.
 */
public class EmailMessageFluent {

    private String from;
    private String to;
    private String subject;
    private String content;
    private String mimeType;

    private EmailMessageFluent() {
    }

    public interface EmailBuilder extends Builder<EmailMessage>{
        EmailBuilder from(String from);
        EmailBuilder to(String to);
        EmailBuilder subject(String to);
        EmailBuilder content(String to);
    }

    public static EmailBuilder create(){
        return ReflectionBuilder.implementationFor(EmailBuilder.class).create();
    }

}
