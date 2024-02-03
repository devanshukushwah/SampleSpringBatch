package com.dev.app.process;

import com.dev.app.model.EmailContent;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.batch.core.annotation.BeforeJob;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class EmailReader implements ItemReader<List<EmailContent>> {

    private List<List<EmailContent>> list;

    @Override
    public synchronized List<EmailContent> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if(list != null && !list.isEmpty()) {
            System.out.println("reader!");
            return list.remove(0);
        }
        return null;
    }


    @BeforeStep
    public void preReq(){
        List<EmailContent> emails = new ArrayList<>();

        emails.add(EmailContent.builder().primaryKey(1).emailAddress("test1@gmail.com").roomId(1).build());
        emails.add(EmailContent.builder().primaryKey(2).emailAddress("test2@gmail.com").roomId(1).build());
        emails.add(EmailContent.builder().primaryKey(3).emailAddress("test3@gmail.com").roomId(2).build());
        emails.add(EmailContent.builder().primaryKey(4).emailAddress("test4@gmail.com").roomId(3).build());
        emails.add(EmailContent.builder().primaryKey(5).emailAddress("test5@gmail.com").roomId(3).build());
        emails.add(EmailContent.builder().primaryKey(6).emailAddress("test6@gmail.com").roomId(4).build());
        emails.add(EmailContent.builder().primaryKey(7).emailAddress("test7@gmail.com").roomId(4).build());

        Map<Long, List<EmailContent>> collect = emails.stream().collect(Collectors.groupingBy(EmailContent::getRoomId));

        this.list = new ArrayList<>(collect.values());
        System.out.println("before read step");
    }
}
