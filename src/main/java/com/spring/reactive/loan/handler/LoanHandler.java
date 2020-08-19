package com.spring.reactive.loan.handler;


import com.spring.reactive.loan.entity.LoanDetails;
import com.spring.reactive.loan.exception.NoLoanAvailableException;
import com.spring.reactive.loan.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class LoanHandler {

    @Autowired
    LoanRepository loanRepository;


  public Mono<ServerResponse> applyLoan(ServerRequest serverRequest) {
        Mono<LoanDetails> loanDetails = serverRequest.bodyToMono(LoanDetails.class);

        return loanDetails.flatMap(loan -> ServerResponse.ok()
                                            .contentType(MediaType.APPLICATION_JSON)
                                            .body(loanRepository.save(loan), LoanDetails.class));


    }


    public Mono<ServerResponse> getLoanDetails(ServerRequest serverRequest) {
        String userId = serverRequest.pathVariable("userId");
        Flux<LoanDetails> getloanDetails = loanRepository.findByUserId(userId);
        return  ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(getloanDetails, LoanDetails.class);

    }
}
