package edu.java.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

public record StackOverflowResponse(Long id,
                                    String name,
                                    @JsonProperty("full_name") String fullName,
                                    @JsonProperty("created_at") OffsetDateTime createdAt,
                                    @JsonProperty("pushed_at") OffsetDateTime pushedAt,
                                    @JsonProperty("updated_at") OffsetDateTime updatedAt) {
}
