package com.example.api.web.rest.controlleradvice;

import com.example.api.client.rest.viacep.exception.ViaCepIntegrationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler(ViaCepIntegrationException.class)
    public void handleViaCepIntegrationException(
            ViaCepIntegrationException viaCepIntegrationException, HttpServletResponse httpServletResponse
    ) throws IOException {
        httpServletResponse.sendError(HttpStatus.BAD_REQUEST.value(), viaCepIntegrationException.getMessage());
    }


}
