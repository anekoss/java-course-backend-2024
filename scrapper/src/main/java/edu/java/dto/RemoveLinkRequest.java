package edu.java.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record RemoveLinkRequest(@NotBlank @JsonProperty("link") String link) {
}
