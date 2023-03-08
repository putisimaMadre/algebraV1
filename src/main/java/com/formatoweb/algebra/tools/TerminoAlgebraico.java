package com.formatoweb.algebra.tools;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TerminoAlgebraico {

    public List<String> divicionTerminoAlgebraico(String expresion){
        String termino = "";
        List<String> terminoList = new ArrayList<>();
        char [] caracteres = expresion.toCharArray();
        for (int i = 0; i < caracteres.length; i++) {
            termino = termino + caracteres[i];
            //para agregar el primer termino
            if (caracteres[i] == '+' || caracteres[i] == '-' && i != 0){
                //elimina el ultimo signo
                String ultimoSigno = termino.substring(termino.length() - 1);
                termino = termino.substring(0, termino.length() - 1);
                terminoList.add(termino);
                termino = ultimoSigno;
            }
            //para agregar el ultimo termino
            if(i == caracteres.length-1){
                terminoList.add(termino);
            }
        }
        return terminoList;
    }

    public Map<Integer, String> divicionTerminoAlgebraicoCompleto(List<String> terminoList){
        char[] caracteres;
        String terminoNumSigno = "";
        String terminoLiterales = "";
        Map<Integer, String>terminoAlgebraicoSeparado = new HashMap<>();
        for (String termino:terminoList
        ) {
            caracteres = termino.toCharArray();
            for (int i = 0; i < termino.length(); i++) {
                if (caracteres[i] == '-' && i == 0){
                    terminoNumSigno = "-";
                }
                if (Character.isDigit(caracteres[i])){
                    terminoNumSigno = terminoNumSigno+caracteres[i];
                }else{
                    if (caracteres[i] != '+' && caracteres[i] != '-'){
                        terminoLiterales = terminoLiterales + caracteres[i];
                    }
                }
            }
            terminoAlgebraicoSeparado.put(Integer.parseInt(terminoNumSigno), terminoLiterales);
            terminoNumSigno = "";
            terminoLiterales = "";
        }
        return terminoAlgebraicoSeparado;
    }
}
