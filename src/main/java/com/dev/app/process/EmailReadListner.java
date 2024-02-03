package com.dev.app.process;

import com.dev.app.model.EmailContent;
import org.springframework.batch.core.ItemReadListener;

public class EmailReadListner implements ItemReadListener<EmailContent> {
    @Override
    public void beforeRead() {

    }

    @Override
    public void afterRead(EmailContent emailContent) {

    }

    @Override
    public void onReadError(Exception e) {
        System.out.println("error");
    }
}
