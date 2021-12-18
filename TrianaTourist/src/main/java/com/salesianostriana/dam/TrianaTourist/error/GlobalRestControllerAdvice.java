package com.salesianostriana.dam.TrianaTourist.error;

import com.salesianostriana.dam.TrianaTourist.error.config.model.ApiError;
import com.salesianostriana.dam.TrianaTourist.error.config.model.ApiSubError;
import com.salesianostriana.dam.TrianaTourist.error.config.model.ValidationError;
import com.salesianostriana.dam.TrianaTourist.error.excepciones.EntidadNotFoundException;
import com.salesianostriana.dam.TrianaTourist.error.excepciones.ListEntityNotFound;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalRestControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ListEntityNotFound.class})
    public ResponseEntity<ApiError> handleListEntityNotFound (ListEntityNotFound ex, WebRequest request){
        ApiError apiError = ApiError.builder()
                .mensaje(ex.getLocalizedMessage())
                .codigo(HttpStatus.NOT_FOUND.value())
                .status(HttpStatus.NOT_FOUND)
                .fecha(LocalDateTime.now())
                .ruta(((ServletWebRequest) request).getRequest().getRequestURI())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }
    @ExceptionHandler({EntidadNotFoundException.class})
    public ResponseEntity<ApiError> handleEntityNotFound (EntidadNotFoundException ex, WebRequest request){
        ApiError apiError = ApiError.builder()
                .mensaje(ex.getLocalizedMessage())
                .codigo(HttpStatus.NOT_FOUND.value())
                .status(HttpStatus.NOT_FOUND)
                .fecha(LocalDateTime.now())
                .ruta(((ServletWebRequest) request).getRequest().getRequestURI())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ApiSubError> subErrors = new ArrayList<>();

        ex.getAllErrors().forEach(error -> {
            if (error instanceof FieldError){
                FieldError fieldError = (FieldError) error;
                subErrors.add(ValidationError.builder()
                                .objeto(fieldError.getObjectName())
                                .campo(fieldError.getField())
                                .mensaje(fieldError.getDefaultMessage())
                                .valorRechazado(fieldError.getRejectedValue())
                        .build());
            }else {
                ObjectError objectError = error;
                subErrors.add(ValidationError.builder()
                                .objeto(objectError.getObjectName())
                                .mensaje(objectError.getDefaultMessage())
                        .build());
            }
        });
        return buildApiError(status,ex,request,subErrors.isEmpty() ? null: subErrors);
    }

    private ResponseEntity<Object> buildApiError(HttpStatus status,Exception ex, WebRequest request, List<ApiSubError> subErrors){
        return ResponseEntity.status(status).body(new ApiError(status,status.value(),ex.getLocalizedMessage(),((ServletWebRequest) request).getRequest().getRequestURI(),subErrors,LocalDateTime.now()));
    }

}
