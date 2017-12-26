package com.my.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.webflow.mvc.servlet.FlowHandlerAdapter;
import org.springframework.webflow.mvc.servlet.FlowHandlerMapping;

//@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

//    @Autowired
//    private WebFlowConfig webFlowConfig;
//
//
//
//    @Bean
//    public FlowHandlerMapping flowHandlerMapping() {
//        FlowHandlerMapping handlerMapping = new FlowHandlerMapping();
//        handlerMapping.setOrder(-1);
//        handlerMapping.setFlowRegistry(this.webFlowConfig.flowRegistry());
//        return handlerMapping;
//    }
//
//    @Bean
//    public FlowHandlerAdapter flowHandlerAdapter() {
//        FlowHandlerAdapter handlerAdapter = new FlowHandlerAdapter();
//        handlerAdapter.setFlowExecutor(this.webFlowConfig.flowExecutor());
//        handlerAdapter.setSaveOutputToFlashScopeOnRedirect(true);
//        return handlerAdapter;
//    }


}