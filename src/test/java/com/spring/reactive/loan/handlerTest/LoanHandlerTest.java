package com.spring.reactive.loan.handlerTest;

import com.spring.reactive.loan.entity.LoanDetails;
import com.spring.reactive.loan.repository.LoanRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureWebTestClient
public class LoanHandlerTest {

    @Autowired
    WebTestClient webTestClient;

    @Autowired
    LoanRepository loanRepository;


    @Test
    public void createLoan(){
        LocalDate ld4=LocalDate.of(2016,12,30);
        LoanDetails newLoan = new LoanDetails("4","3","Personal",100000.0,ld4,11.99,3.0);

        webTestClient.post().uri("/v1/functional/applyloan").contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(newLoan), LoanDetails.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.userId").isEqualTo("3")
                .jsonPath("$.loanType").isEqualTo("Personal");

    }
}
