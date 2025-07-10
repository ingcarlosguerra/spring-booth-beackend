// src/main/java/pruebatecnica/server/api/exception/ValidationExceptionHandler.java
package pruebatecnica.server.api.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,Object>> handleValidation(
            MethodArgumentNotValidException ex,
            HttpServletRequest req) {


        String mensajes = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fe -> fe.getField() + ": " + fe.getDefaultMessage())
                .collect(Collectors.joining("; "));

        Map<String,Object> body = new LinkedHashMap<>();
        body.put("timestamp", Instant.now());
        body.put("status",    HttpStatus.BAD_REQUEST.value());
        body.put("error",     HttpStatus.BAD_REQUEST.getReasonPhrase());
        body.put("message",   mensajes);
        body.put("path",      req.getRequestURI());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
