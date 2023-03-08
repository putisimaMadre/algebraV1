package com.formatoweb.algebra.controllers;

import com.formatoweb.algebra.services.SumaService;
import com.formatoweb.algebra.tools.TerminoAlgebraico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class Operaciones {
    @Autowired
    private SumaService sumaService;
    @Autowired
    private TerminoAlgebraico terminoAlgebraico;

    @PostMapping("/sumaExp")
    public String suma(@RequestBody String expresion){
        String resultado = "";
        List<String> terminoList = terminoAlgebraico.divicionTerminoAlgebraico(expresion);
        Map<Integer, String> tAc = terminoAlgebraico.divicionTerminoAlgebraicoCompleto(terminoList);

        for (Map.Entry<Integer, String> entry : tAc.entrySet()) {
            System.out.println(entry.getValue()+":"+entry.getKey());
        }

        /*Map<Integer, String>valoresRepetidos = new HashMap<>();
        for (Map.Entry<Integer, String> entry : tAc.entrySet()) {
            for (Map.Entry<Integer, String> entryTwo : tAc.entrySet()) {
                //Aqui solo estan los terminos semejantes
                //FALTA AGREGAR LOS TERMINOS QUE NO SON SEMEJANTES!!!!! __AQUI!!!!
                if (entry.getValue().equals(entryTwo.getValue())){
                    valoresRepetidos.put(entry.getKey(), entryTwo.getValue());
                }
            }
        }
        for (Map.Entry<Integer, String> entry : valoresRepetidos.entrySet()) {
            System.out.println(entry.getValue()+":"+entry.getKey());
        }*/

        return resultado;
    }
}