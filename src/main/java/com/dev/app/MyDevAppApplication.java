package com.dev.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.swing.*;
import java.awt.*;
import java.net.URI;

import static javax.swing.BorderFactory.createEmptyBorder;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MyDevAppApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(MyDevAppApplication.class, args);
	}

}
