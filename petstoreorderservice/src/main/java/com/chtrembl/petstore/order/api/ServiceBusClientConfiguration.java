package com.chtrembl.petstore.order.api;

import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusSenderClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class ServiceBusClientConfiguration {

    @Value("${spring.cloud.azure.servicebus.url}")
    private String connectionString;
    @Value("${spring.cloud.azure.servicebus.queue}")
    private String queueName;

    @Bean
    public ServiceBusClientBuilder serviceBusClientBuilder() {
        return new ServiceBusClientBuilder()
            .connectionString(connectionString);
    }

    @Bean
    public ServiceBusSenderClient serviceBusSenderClient(ServiceBusClientBuilder builder) {
        return builder
            .sender()
            .queueName(queueName)
            .buildClient();
    }
}