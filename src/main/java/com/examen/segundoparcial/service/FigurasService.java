package com.examen.segundoparcial.service;

import com.examen.segundoparcial.models.Circulo;
import com.examen.segundoparcial.models.Cuadrado;
import org.springframework.stereotype.Service;

@Service
public class FigurasService {

    public double calcularArea(Cuadrado cuadrado){
        return cuadrado.getLado()*cuadrado.getLado();
    }

    public double calcularArea(Circulo circulo){
        return Math.pow(2,circulo.getRadio())*Math.PI;
    }
}
