package com.wolf.jobsearch.cli;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class CommanderFunctions {

    /**
     * Funcion generica que recibira
     * @param cliName Nombre del comando
     * @param argumentSupplier Supplier de Object
     * @param <T>
     * @return
     */
    public static <T> JCommander buildCommanderWithName(String cliName, Supplier<T> argumentSupplier){

        JCommander Jcommander = JCommander.newBuilder()
                .addObject(argumentSupplier.get())
                .build();
        Jcommander.setProgramName(cliName); //Indicamos el nombre del comando

        return Jcommander;//Retorna el objeto
    }

    /**
     * Funcion de un Optional de una lista de objetos
     * @param Jcommander
     * @param args Arreglo de Strings que son los argumentos que nos dieron por terminal
     * @param onError Funcion en la cual haremos el consumo de la funcion que se va utilizar
     * @return
     */
    public static Optional<List<Object>> parseArguments(JCommander Jcommander, String[] args, Consumer<JCommander> onError){
        try {//Atrapamos la exception que arrojamos en CLIKeywordValidator para poder mostrar la ayuda
            Jcommander.parse(args); //Tomamos los argumentos
            return Optional.of(Jcommander.getObjects()); //Retornamos un optional de lo que JCommander nos de como los argumentos
        }catch(ParameterException paramEx){
            onError.accept(Jcommander);

        }
        //Nos aseguramos que dentro del codigo cuando el parse de argumentos no encuentre los argumentos adecuados o algo sale mal pueda mostrar la ayuda
        return Optional.empty();
    }
}
