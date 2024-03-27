package me.self.cfs.controller;

import me.self.cfs.service.TestService;
import me.self.cfs.vo.ProcessDefinitionVO;
import org.camunda.bpm.engine.impl.util.CollectionUtil;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TestController {

    @Resource
    private TestService testService;

    @GetMapping("/testGetProcessDefinitions")
    public List<ProcessDefinitionVO> testGetProcessDefinitions() {
        List<ProcessDefinition> processDefinitions = testService.getProcessDefinitions();
        if (CollectionUtil.isEmpty(processDefinitions)) {
            return new ArrayList<>();
        }
        return processDefinitions.stream().map(processDefinition -> {
            ProcessDefinitionVO processDefinitionVO = new ProcessDefinitionVO();
            processDefinitionVO.setId(processDefinition.getId());
            processDefinitionVO.setName(processDefinition.getName());
            return processDefinitionVO;
        }).collect(Collectors.toList());
    }

}
