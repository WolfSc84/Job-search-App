package com.wolf.jobsearch.cli;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

/**
 *Clase para validar cuando el usuario use los caracteres correctos para escirbir los keyword.
 *Implementa la interfaz de JCommander IParameterValidator
 */
public class CLIKeywordValidator implements IParameterValidator {

    @Override
    public void validate(String name, String value) throws ParameterException {
        //Validamos que los caracteres sean validos
        if(!value.matches("^[a-zA-Z]+[0-9]*$")){
            System.out.println("El criterio de busqueda no es valido");
            throw new ParameterException("Unicamente letras y numeros");
        }
    }
}
