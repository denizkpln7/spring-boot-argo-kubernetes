package com.denizkpln.basketservice.client;



import com.denizkpln.basketservice.dto.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "product-service", path = "/product")
public interface ProductServiceClient {

    Logger logger = LoggerFactory.getLogger(ProductServiceClient.class);


    @GetMapping("/{productId}")
    public ResponseEntity<Product> findbyId(@PathVariable Long productId);


//    @GetMapping("/{id}")
//    @CircuitBreaker(name = "getTransactionByIsbnCircuitBreaker", fallbackMethod = "getBookFallback")
//    ResponseEntity<TransactionDto> findById(@PathVariable Long id);
//
//    default ResponseEntity<TransactionDto> getBookFallback(Long id) {
//        logger.info("Transaction not found by id " + id + ", returning default TransactionDto object");
//        return ResponseEntity.ok(new TransactionDto());
//    }

}
