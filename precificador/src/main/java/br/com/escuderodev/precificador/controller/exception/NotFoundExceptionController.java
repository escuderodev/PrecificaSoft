package br.com.escuderodev.precificador.controller.exception;

public class NotFoundExceptionController extends RuntimeException{

    public NotFoundExceptionController(String message) {
        super(message);
    }
}
