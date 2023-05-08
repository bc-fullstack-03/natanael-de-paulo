package io.github.natanaeldepaulo.api.infrastructure;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventService implements IEventService{

    @Autowired
    private KafkaTemplate<String, String> _kafkaTemplate;

    @Value("${topic.name}")
    private String topic;

    @Override
    public void send(String topic, String event){
        _kafkaTemplate.send(topic, event);
    }

    public String consume(ConsumerRecord<String, String> event){
        return event.value();
    }

}
