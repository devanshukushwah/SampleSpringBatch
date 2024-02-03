package com.dev.app.process;

import com.dev.app.model.EmailContent;
import org.springframework.batch.core.ItemWriteListener;

import java.util.List;

public class EmailWriterListner implements ItemWriteListener<List<EmailContent>> {
    @Override
    public void beforeWrite(List<? extends List<EmailContent>> list) {

    }

    @Override
    public void afterWrite(List<? extends List<EmailContent>> list) {

    }

    @Override
    public void onWriteError(Exception e, List<? extends List<EmailContent>> list) {
        System.out.println("error" + e);
    }
}
