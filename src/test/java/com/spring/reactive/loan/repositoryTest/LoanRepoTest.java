package com.spring.reactive.loan.repositoryTest;

import com.spring.reactive.loan.entity.LoanDetails;
import com.spring.reactive.loan.repository.LoanRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@DataMongoTest
@ExtendWith(SpringExtension.class)
public class LoanRepoTest {

    @Autowired
    private LoanRepository loanRepository;
/*
    LocalDate ld1=LocalDate.of(2016,06,10);
    LocalDate ld2=LocalDate.of(2017,10,30);
    LocalDate ld3=LocalDate.of(2014,04,20);

    List<LoanDetails> loanList =  Arrays.asList(
            new LoanDetails("1","1","Education",300000.0,ld1,11.9,2.0),
            new LoanDetails("2","1","Home",3000000.0,ld2,7.9,20.0),
            new LoanDetails("3","2","Vehicle",1000000.0,ld3,12.0,5.0)
    );*/


    @Test
    public void saveLoandetails(){
        LocalDate ld4=LocalDate.of(2016,12,30);
        LoanDetails newLoan = new LoanDetails("4","3","Personal",100000.0,ld4,11.99,3.0);
        Mono<LoanDetails> insertedLoanItem=loanRepository.save(newLoan);

        StepVerifier.create(insertedLoanItem)
                .expectSubscription()
                .expectNextMatches(loan->loan.getLoanType().equalsIgnoreCase("personal"))
                .verifyComplete();
    }
}
