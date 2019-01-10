package com.stackroute.MovieService.config;

import com.mongodb.MongoClient;
//import cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.IOException;


//import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//public class WebConfiguration {
//        private static final String MONGO_DB_URL = "localhost";
//        private static final String MONGO_DB_NAME = "embeded_db";
//        @Bean
//        public MongoTemplate mongoTemplate() throws IOException {
//            EmbeddedMongoFactoryBean mongo = new EmbeddedMongoFactoryBean();
//            mongo.setBindIp(MONGO_DB_URL);
//            MongoClient mongoClient = mongo.getObject();
//            MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, MONGO_DB_NAME);
//            return mongoTemplate;
//        }
//    @Bean
//    ServletRegistrationBean h2servletRegistration() {
//        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
//        registrationBean.addUrlMappings("/console/*");
//        return registrationBean;
//
//}
