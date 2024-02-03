package com.dev.app.process;

import com.dev.app.model.EmailContent;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class EmailWriter implements ItemWriter<List<EmailContent>> {

    @Override
    public void write(List<? extends List<EmailContent>> list) throws Exception {
        if (list != null) {
            System.out.println("write!" + list);
        }
    }
}
