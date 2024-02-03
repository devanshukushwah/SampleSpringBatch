package com.dev.app.config;


import com.dev.app.model.EmailContent;
import com.dev.app.process.*;
import org.springframework.batch.core.ItemProcessListener;
import org.springframework.batch.core.ItemReadListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    JobBuilderFactory jobBuilderFactory;

    @Autowired
    StepBuilderFactory stepBuilderFactory;


    @Bean
    public Job emailJob(){
        return jobBuilderFactory.get("emailJob")
                .start(emailStep())
                .build();
    }

    @Bean
    public Step emailStep() {
        return stepBuilderFactory.get("emailStep")
                .<List<EmailContent>, List<EmailContent>>chunk(5)
                .reader(emailReader())
                .listener(emailReadListener())
                .processor(emailProcessor())
                .listener(emailProcessorListner())
                .writer(emailWriter())
                .build();
    }

    public ItemWriter<List<EmailContent>> emailWriter() {
        return new EmailWriter();
    }

    public ItemProcessor<List<EmailContent>, List<EmailContent>> emailProcessor() {
        return new EmailProcessor();
    }

    @Bean
    public ItemReader<List<EmailContent>> emailReader() {
        return new EmailReader();
    }

    @Bean
    public ItemReadListener<EmailContent> emailReadListener(){
        return new EmailReadListner();
    }

    @Bean
    public ItemProcessListener<List<EmailContent>, List<EmailContent>> emailProcessorListner() {
        return new EmailProcessorListener();
    }

//    @Bean
//    public CompositeItemWriter<EmailContent> writer() {
//        List<ItemWriter<List<EmailContent>>> itemWriter = new ArrayList<>();
//        itemWriter.add(emailWriterOne());
//
//        CompositeItemWriter<EmailContent> writer = new CompositeItemWriter<>();
//        writer.setDelegates(itemWriter);
//        return writer;
//    }
//
//    @Bean
//    public ItemWriter<List<EmailContent>> emailWriterOne() {
//        return new EmailWriterOne();
//    }

}
