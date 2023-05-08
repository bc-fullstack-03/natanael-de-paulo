package io.github.natanaeldepaulo.api.infrastructure;

public interface IEventService {
    void send(String topic, String event);
}
