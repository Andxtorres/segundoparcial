package com.examen.segundoparcial.controller;

import com.examen.segundoparcial.models.Circulo;
import com.examen.segundoparcial.models.Cuadrado;
import com.examen.segundoparcial.models.OperacionRequest;
import com.examen.segundoparcial.service.FigurasService;
import com.examen.segundoparcial.service.OperacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class MainController {
    @Autowired
    FigurasService figurasService;
    @Autowired
    OperacionesService operacionesService;

    @PostMapping("/circulo/area")
    public double calcularAreaDelCirculo(@RequestBody Circulo circulo){
        return figurasService.calcularArea(circulo);
    }
    @PostMapping("/cuadrado/area")
    public double calcularAreaDelCuadrado(@RequestBody Cuadrado cuadrado){
        return figurasService.calcularArea(cuadrado);
    }

    @PostMapping("/suma")
    public double suma(@RequestBody OperacionRequest operacionRequest){
        return operacionesService.suma(operacionRequest.getA(),operacionRequest.getB());
    }
    @PostMapping("/resta")
    public double resta(@RequestBody OperacionRequest operacionRequest){
        return operacionesService.resta(operacionRequest.getA(),operacionRequest.getB());
    }
    @PostMapping("/multiplicacion")
    public double multiplicacion(@RequestBody OperacionRequest operacionRequest){
        return operacionesService.multiplicacion(operacionRequest.getA(),operacionRequest.getB());
    }
    @PostMapping("/division")
    public ResponseEntity<?> division(@RequestBody OperacionRequest operacionRequest) throws Exception{
        try {
            Double respuesta = operacionesService.division(operacionRequest.getA(), operacionRequest.getB());
            return new ResponseEntity<Double>(respuesta, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
