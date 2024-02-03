package com.dev.app.process;

import com.dev.app.model.EmailContent;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class EmailWriterTwo implements ItemWriter<List<EmailContent>> {

    @Override
    public void write(List<? extends List<EmailContent>> list) throws Exception {
        System.out.println("writer two " + list);
    }
}
