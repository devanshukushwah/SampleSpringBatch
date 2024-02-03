package com.dev.app.process;

import com.dev.app.model.EmailContent;
import org.springframework.batch.core.ItemProcessListener;

import java.util.List;

public class EmailProcessorListener implements ItemProcessListener<List<EmailContent>, List<EmailContent>> {

    @Override
    public void beforeProcess(List<EmailContent> emailContents) {

    }

    @Override
    public void afterProcess(List<EmailContent> emailContents, List<EmailContent> emailContents2) {

    }

    @Override
    public void onProcessError(List<EmailContent> emailContents, Exception e) {
        System.out.println("processor error" + e.getMessage());
    }
}
