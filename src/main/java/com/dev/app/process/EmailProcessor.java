package com.dev.app.process;

import com.dev.app.model.EmailContent;
import org.springframework.batch.core.annotation.BeforeJob;
import org.springframework.batch.item.ItemProcessor;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class EmailProcessor implements ItemProcessor<List<EmailContent>, List<EmailContent>> {

    @Override
    public List<EmailContent> process(List<EmailContent> emailContents) throws Exception {
        System.out.print("processor ");
        if(emailContents != null) {
            List<Long> collect = emailContents.stream().map(m -> m.getRoomId()).collect(Collectors.toList());
            boolean contains = collect.contains(4L);
            if (contains) {
                System.out.println(emailContents);
                return emailContents;
            }
        }
        System.out.println();
        return null;
    }
}
