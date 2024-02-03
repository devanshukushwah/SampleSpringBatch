package com.dev.app.process;

import com.dev.app.model.EmailContent;
import org.springframework.batch.item.ItemWriter;

import java.io.Serializable;
import java.util.List;

public class EmailWriterOne implements ItemWriter<List<EmailContent>> {

    @Override
    public void write(List<? extends List<EmailContent>> list) throws Exception {
        System.out.println("writer one " + list);
    }
}
