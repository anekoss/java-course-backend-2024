package edu.java.bot.client;

import edu.java.bot.client.exception.CustomClientErrorException;
import edu.java.bot.client.exception.CustomServerErrorException;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.codec.CodecException;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.util.retry.Retry;

@Slf4j
@Component
public class TgChatClient {

    private final String pathId = "/{id}";
    private final WebClient webCLient;
    private final Retry retry;

    public TgChatClient(
        @Value("${app.client.tg-сhat.base-url}")
        @NotBlank @URL String url,
        @NotNull Retry retry
    ) {
        this.webCLient = WebClient.builder().baseUrl(url).build();
        this.retry = retry;
    }

    public Void registerChat(Long id) throws CustomClientErrorException, CustomServerErrorException {
        try {
            return webCLient.post()
                .uri(pathId, id)
                .retrieve()
                .bodyToMono(Void.class)
                .retryWhen(retry)
                .block();
        } catch (WebClientResponseException | CodecException e) {
            log.error(e.getMessage());
            throw new CustomClientErrorException();
        } catch (Exception e) {
            throw new CustomServerErrorException();
        }
    }

    public Void deleteChat(Long id) throws CustomClientErrorException, CustomServerErrorException {
        try {
            return webCLient.delete()
                .uri(pathId, id)
                .retrieve()
                .bodyToMono(Void.class)
                .retryWhen(retry)
                .block();
        } catch (WebClientResponseException | CodecException e) {
            log.error(e.getMessage());
            throw new CustomClientErrorException();
        } catch (Exception e) {
            throw new CustomServerErrorException();
        }
    }

}
