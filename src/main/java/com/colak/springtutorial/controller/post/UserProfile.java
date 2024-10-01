package com.colak.springtutorial.controller.post;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfile {

    @Schema(example = "John", description = "First name")
    @NotEmpty
    private String firstName;

    @Schema(example = "Doe", description = "Last name")
    @NotEmpty
    private String lastName;

    @Schema(example = "16/07/2024", description = "Effective date")
    private String effectiveDate;

    @Schema(example = "24", description = "Age(year)")
    @Min(0)
    private long age;

    public UserProfile(String firstName,String lastName, int age, String effectiveDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.effectiveDate =  effectiveDate;
        this.age = age;
    }
}
