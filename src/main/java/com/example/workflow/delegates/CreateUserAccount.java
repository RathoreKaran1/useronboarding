package com.example.workflow.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import java.util.Map;

public class CreateUserAccount implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Map<String, Object> variables = execution.getVariables();
        System.out.println("Process Variables:");
        variables.forEach((key, value) -> System.out.println(key + " = " + value));
    }
}
