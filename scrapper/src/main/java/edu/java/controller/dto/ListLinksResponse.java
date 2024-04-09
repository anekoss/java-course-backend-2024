package edu.java.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.experimental.Accessors;

@Accessors(chain = true)
public record ListLinksResponse(
    @NotNull @Valid @JsonProperty("links") LinkResponse[] linkResponses,
    @Min(0) @NotNull Long size
) {

}
