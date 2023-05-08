package io.github.natanaeldepaulo.api.infrastructure;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface IEventService{
    void send(String topic, String event);
    void consume(ConsumerRecord<String, String> event);
}
