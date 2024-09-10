package com.fitness.cs.fitness_project_be.dto;

import lombok.Builder;

@Builder
public record MailBody(String to, String subject, String text) {
}
