package com.example.workflow.delegates;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class ValidateUserData implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        try {
            String username = (String) execution.getVariable("username");
            String email = (String) execution.getVariable("email");
            if (email == null) {
                throw new RuntimeException("Email is null");
            }

            boolean isValid = (username != null && !username.isEmpty()) && email.contains("@");
            boolean requiresManualReview = email.toLowerCase().contains("review");
            execution.setVariable("isValid", isValid);
            execution.setVariable("requiresManualReview", requiresManualReview);

            System.out.println("Validation result: isValid = " + isValid);
            System.out.println("Requires Manual Review: " + requiresManualReview);

        } catch (Exception e) {
            throw new BpmnError("TECHNICAL_ERROR", "An unexpected technical error occurred: " + e.getMessage());
        }
    }
}
