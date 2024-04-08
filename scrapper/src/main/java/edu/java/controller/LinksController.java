package edu.java.controller;

import edu.java.controller.dto.AddLinkRequest;
import edu.java.controller.dto.LinkResponse;
import edu.java.controller.dto.ListLinksResponse;
import edu.java.controller.dto.RemoveLinkRequest;
import edu.java.controller.exception.ChatNotFoundException;
import edu.java.controller.exception.LinkAlreadyExistException;
import edu.java.controller.exception.LinkNotFoundException;
import edu.java.service.LinkService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.net.URI;
import java.net.URISyntaxException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LinksController {
    private final LinkService linkService;

    @GetMapping(path = "/links", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ListLinksResponse> getLinks(
        @RequestHeader(value = "Tg-Chat-Id") Long tgChatId
    ) throws ChatNotFoundException {
        ListLinksResponse response = linkService.listAll(tgChatId);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "/links", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<LinkResponse> deleteLink(
        @RequestHeader(value = "Tg-Chat-Id") @NotNull Long tgChatId, @RequestBody @Valid RemoveLinkRequest request
    ) throws URISyntaxException, ChatNotFoundException, LinkNotFoundException {
        URI uri = new URI(request.link());
        linkService.remove(tgChatId, uri);
        return ResponseEntity.ok(new LinkResponse(tgChatId, uri));
    }

    @PostMapping(path = "/links", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<LinkResponse> addLink(
        @RequestHeader(value = "Tg-Chat-Id") @NotNull Long tgChatId,
        @RequestBody @Valid AddLinkRequest request
    ) throws URISyntaxException, ChatNotFoundException, LinkAlreadyExistException {
        URI uri = new URI(request.link());
        linkService.add(tgChatId, uri);
        return ResponseEntity.ok(new LinkResponse(tgChatId, uri));
    }

}
