package edu.java.scrapper.client;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import edu.java.client.StackOverflowClient;
import edu.java.client.dto.StackOverflowResponse;
import edu.java.client.exception.CustomWebClientException;
import edu.java.scrapper.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.OffsetDateTime;
import java.util.List;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StackOverflowClientTest extends IntegrationTest {
    @RegisterExtension
    static WireMockExtension wireMockServer = WireMockExtension.newInstance()
                                                               .options(wireMockConfig().dynamicPort())
                                                               .build();
    private final Path okResponsePath =
            Path.of("src/test/java/edu/java/scrapper/client/stackOverflow/stackOverflow_ok.json");

    @Autowired
    private StackOverflowClient stackOverflowClient;

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("app.client.stackOverflow.base-url", wireMockServer::baseUrl);
    }

    @Test
    void testFetchQuestion_shouldReturnCorrectResponse() throws IOException, CustomWebClientException {
        String response =
                String.join("", Files.readAllLines(okResponsePath));
        wireMockServer.stubFor(WireMock.get(WireMock.urlPathTemplate("/2.3/questions/{id}"))
                                       .withPathParam("id", WireMock.equalTo("78056352"))
                                       .withQueryParam("sort", WireMock.equalTo("activity"))
                                       .withQueryParam("site", WireMock.equalTo("stackoverflow"))
                                       .willReturn(WireMock.aResponse()
                                                           .withStatus(200)
                                                           .withHeader("Content-Type", "application/json")
                                                           .withBody(response)));
        StackOverflowResponse stackOverflowResponse =
                new StackOverflowResponse(List.of(new StackOverflowResponse.StackOverflowItem(78056352L,
                        "React Leaflet map not Re-rendering",
                        "https://stackoverflow.com/questions/78056352/react-leaflet-map-not-re-rendering",
                        OffsetDateTime.parse("2024-02-25T14:38:10Z"), OffsetDateTime.parse("2024-02-25T14:38:10Z")
                )));
        assertThat(stackOverflowClient.fetchQuestion(78056352L)).isEqualTo(stackOverflowResponse);
    }

    @Test
    void testFetchQuestion_shouldReturnWebClientExceptionIfClientError() {
        wireMockServer.stubFor(WireMock.get(WireMock.urlPathTemplate("/2.3/questions/{id}"))
                                       .withPathParam("id", WireMock.equalTo("78056352"))
                                       .withQueryParam("sort", WireMock.equalTo("activity"))
                                       .withQueryParam("site", WireMock.equalTo("stackoverflow"))
                                       .willReturn(WireMock.aResponse().withStatus(404)));
        assertThrows(CustomWebClientException.class, () -> stackOverflowClient.fetchQuestion(78056353L));
    }

    @Test
    void testFetchQuestionShouldReturnWebClientExceptionIfServerError() {
        wireMockServer.stubFor(WireMock.get(WireMock.urlPathTemplate("/2.3/questions/{id}"))
                                       .withPathParam("id", WireMock.equalTo("78056352"))
                                       .withQueryParam("sort", WireMock.equalTo("activity"))
                                       .withQueryParam("site", WireMock.equalTo("stackoverflow"))
                                       .willReturn(WireMock.aResponse().withStatus(500)));
        assertThrows(CustomWebClientException.class, () -> stackOverflowClient.fetchQuestion(78056352L));
    }

    @Test
    void testFetchQuestion_shouldReturnBadResponseExceptionIfBadBody() {
        wireMockServer.stubFor(WireMock.get(WireMock.urlPathTemplate("/2.3/questions/{id}"))
                                       .withPathParam("id", WireMock.equalTo("78056352"))
                                       .withQueryParam("sort", WireMock.equalTo("activity"))
                                       .withQueryParam("site", WireMock.equalTo("stackoverflow"))
                                       .willReturn(WireMock.aResponse()
                                                           .withStatus(200)
                                                           .withHeader("Content-Type", "application/json")
                                                           .withBody("{id:mew}")));
        assertThrows(CustomWebClientException.class, () -> stackOverflowClient.fetchQuestion(78056352L));
    }

}
