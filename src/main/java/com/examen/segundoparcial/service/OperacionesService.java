package com.examen.segundoparcial.service;

import org.springframework.stereotype.Service;

@Service
public class OperacionesService {

    public double suma(double a, double b){
        return a+b;
    }

    public double resta(double a, double b){
        return a-b;
    }

    public double division(double a,double b) throws Exception{
        if(b==0){
            throw new Exception();
        }
        return a/b;
    }
    public double multiplicacion(double a,double b){
        return a*b;
    }


}
