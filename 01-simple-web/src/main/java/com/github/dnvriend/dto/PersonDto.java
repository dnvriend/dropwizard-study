package com.github.dnvriend.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@Builder(toBuilder = true)
public class PersonDto {

    private Long id;

    @NotEmpty
    private String name;

    @Max(100)
    @Min(0)
    private int age;
}
