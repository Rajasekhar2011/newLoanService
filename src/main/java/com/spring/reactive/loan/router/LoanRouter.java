package com.spring.reactive.loan.router;

import com.spring.reactive.loan.handler.LoanHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class LoanRouter {

    @Bean
    public RouterFunction<ServerResponse> loansRouter(LoanHandler loanHandler){
        return RouterFunctions
                .route(POST("/v1/functional/applyloan").and(accept(MediaType.APPLICATION_JSON)),loanHandler::applyLoan)
                .andRoute(GET("/v1/functional/getLoanOfUser/{userId}").and(accept(MediaType.APPLICATION_JSON)),loanHandler::getLoanDetails);
    }
}
