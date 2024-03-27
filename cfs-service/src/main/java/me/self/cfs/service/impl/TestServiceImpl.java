package me.self.cfs.service.impl;

import me.self.cfs.service.TestService;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Resource
    private RepositoryService repositoryService;

    @Override
    public List<ProcessDefinition> getProcessDefinitions() {
        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().list();
        return list;
    }

}
