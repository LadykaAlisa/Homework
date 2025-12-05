package Homework13;

import io.cucumber.java.Before;
import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestStepStarted;

public class CucumberHooks implements EventListener {

    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestStepStarted.class,
                testStepStarted -> {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>TestStepStarted<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
                });
    }
}
