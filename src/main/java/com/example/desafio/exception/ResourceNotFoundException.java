package com.example.desafio.exception;

//Manejo de excepcion en caso de no existir lo solicitado
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message){
        super(message);
    }

}
