package br.com.escuderodev.precifica.controller.exception;
public class NotFoundExceptionController extends RuntimeException{

    public NotFoundExceptionController(String message) {
        super(message);
    }
}