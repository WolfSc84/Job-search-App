package com.wolf.jobsearch.cli;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

/**
 *Clase para validar cuando el usuario pida ayuda y no se lance como una opcion mas.
 *Implementa la interfaz de JCommander IParameterValidator
 */
public class CLIHelpValidator implements IParameterValidator {

    @Override
    public void validate(String name, String value) throws ParameterException{
        //Validamos el valor del flag help para mostrar la ayuda
        boolean actualValue = Boolean.parseBoolean(value);
        if(actualValue){
            throw new ParameterException("Ayuda Solicitada");
        }

    }

}
