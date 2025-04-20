package com.selivanov.dto;

public record PersonPassportRequest(
        PersonDto personDto,
        PassportDto passportDto
) {
}
