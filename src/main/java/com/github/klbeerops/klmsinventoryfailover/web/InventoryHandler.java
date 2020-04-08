package com.github.klbeerops.klmsinventoryfailover.web;

import com.github.klbeerops.klmsinventoryfailover.model.BeerInventoryDto;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

//This is an example of using Reactive, BUT:
//Note that we are using mono to return a list which is not an intended use of this reactive type.
//Flux should always be used, however, this is not compatible with the consuming service...

@Component
public class InventoryHandler {

    public Mono<ServerResponse> listInventory(ServerRequest serverRequest){

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(Mono.just(Arrays.asList(
                        BeerInventoryDto.builder()
                            .id(UUID.randomUUID())
                            .beerId(UUID.fromString("00000000-0000-0000-0000-000000000000"))
                            .quantityOnHand(999)
                            .createdDate(OffsetDateTime.now())
                            .lastModifiedDate(OffsetDateTime.now())
                            .build())), List.class);

    }
}
