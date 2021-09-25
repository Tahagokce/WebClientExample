package com.web.client.controller;

import com.web.client.models.DataResult;
import com.web.client.models.Product;
import com.web.client.models.User;
import com.web.client.services.Request;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static com.web.client.constants.ProductConstants.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ProductRestClient {

    private final Request request;

    @GetMapping("/getallproduct")
    public ResponseEntity<List<Product>> getAllListProduct() {
        var result = this.request.getAllListProduct();
        return ResponseEntity.ok(result);

    }

    @GetMapping("/getbyproductname")
    public ResponseEntity<Product> getByProductNeme(@RequestParam String productName) {
        var result = this.request.getByProductNeme(productName);
        return ResponseEntity.ok(result);

    }

    @GetMapping("/getallflux")
    public ResponseEntity<Flux<Product>> getAllFlux() {
        var result = this.request.getAllFlux();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getbynamemono")
    public ResponseEntity<Mono<Product>> getByName(@RequestParam String productName) {
        var result = this.request.getByName(productName);
        return ResponseEntity.ok(result);
    }


    @PostMapping("/save")
    public ResponseEntity<Mono<DataResult>> save(@RequestBody User user) {
        var result = this.request.save(user);
        return ResponseEntity.ok(result);
    }


}
