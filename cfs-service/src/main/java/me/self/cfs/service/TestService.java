package me.self.cfs.service;

import org.camunda.bpm.engine.repository.ProcessDefinition;

import java.util.List;

public interface TestService {
    List<ProcessDefinition> getProcessDefinitions();
}
