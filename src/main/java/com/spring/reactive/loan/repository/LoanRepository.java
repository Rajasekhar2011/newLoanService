package com.spring.reactive.loan.repository;

import com.spring.reactive.loan.entity.LoanDetails;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface LoanRepository extends ReactiveMongoRepository<LoanDetails,String> {

    Flux<LoanDetails> findByUserId(String userId);

}
