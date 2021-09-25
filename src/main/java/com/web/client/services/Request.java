package com.web.client.services;

import com.web.client.models.DataResult;
import com.web.client.models.Product;
import com.web.client.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static com.web.client.constants.ProductConstants.*;

@Service
@AllArgsConstructor
public class Request {


    private final WebClient webClient;

    public List<Product> getAllListProduct() {
        var result = webClient.get()
                .uri(GET_ALL_PRODUCT)
                .retrieve()
                .bodyToFlux(Product.class).collectList().block();
        return result;

    }

    public Product getByProductNeme(String productName) {
        var result = webClient.get()
                .uri(GET_BY_PRODUCTNAME, productName)
                .retrieve()
                .bodyToMono(Product.class)
                .block();
        return result;

    }

    public Flux<Product> getAllFlux() {
        return webClient.get()
                .uri(GET_ALL_PRODUCT)
                .retrieve()
                .bodyToFlux(Product.class);
    }

    public Mono<Product> getByName(String productName) {
        return webClient.get()
                .uri(GET_BY_PRODUCTNAME, productName)
                .retrieve()
                /*.onStatus(httpStatus -> HttpStatus.NOT_FOUND.equals(httpStatus),
                        clientResponse -> Mono.empty())*/
                .bodyToMono(Product.class);
    }


    public Mono<DataResult> save(User user) {
        return webClient.post()
                .uri(POST_USER)
                .body(Mono.just(user), User.class)
                .retrieve()
                .bodyToMono(DataResult.class);
    }

}
