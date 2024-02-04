package br.com.escuderodev.vendas.controller.exception;
public class NotFoundExceptionController extends RuntimeException{

    public NotFoundExceptionController(String message) {
        super(message);
    }
}