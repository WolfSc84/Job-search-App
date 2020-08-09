package com.wolf.jobsearch;

import com.beust.jcommander.JCommander;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.wolf.jobsearch.api.APIJobs;
import com.wolf.jobsearch.cli.CLIArguments;
import com.wolf.jobsearch.cli.CLIFunctions;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static com.wolf.jobsearch.cli.CommanderFunctions.buildCommanderWithName;
import static com.wolf.jobsearch.cli.CommanderFunctions.parseArguments;
import static com.wolf.jobsearch.api.APIFunctions.*;

public class JobSearch {

    public static void main(String[] args) {
        System.out.println("Hello to Job Search!!");
        //Construimos un commander con un nombre especifico. Le pasamos de donde generar los argumentos por medio del metodo CLIArguments con referencia a la funcion newInstance
        JCommander jCommander = buildCommanderWithName("job-search", CLIArguments::newInstance);

        //Definimos un Stream del tipo CLIArguments para recibir los argumentos de JCommander.
        Stream<CLIArguments> streamOfCLI =
                parseArguments(jCommander, args, JCommander::usage) //Devuelve un tipo Optional con una lista de los argumentos
                        .orElse(Collections.emptyList())//Si no tenemos datos o regresa argumentos, nos devuelve una lista vacia
                        .stream() //Convertimos a Stream
                        .map(obj -> (CLIArguments) obj); //Mapeamos el objeto para convertirlo en un CLIArguments

        //Definimos un Optional para obtener los argumentos que no sea Ayuda y se hayan colocado una palabra clave para la busqueda
        Optional<CLIArguments> cliArgumentsOptional = streamOfCLI.filter(cli -> !cli.isHelp()) //No queremos argumentos de ayuda
                .filter(cli -> cli.getKeyword() != null) //Revisar que traiga un keyword
                .findFirst(); //La primera cantidad de argumentos que corresponda con estas dos caracteristicas.

        //Covertimos el Optional de argumentos en algo que pueda procesarse en la URL.
        //Tomamos el Optional y lo mapeamos para convertirlo a otro tipo de dato.
        cliArgumentsOptional.map(CLIFunctions::toMap) //Lo mapeamos para convertirlo de A -> B en una estructura de llave y valor
                .map(JobSearch::executeRequest) //Hacemos nuestra peticion por un metodo definido por nosotros donde ejecutaremos la peticion web
                .orElse(Stream.empty()) //Si no tenemos datos ni pudimos hacer ejecucion, definimos un caso de que hacer es decir generar un stream vacio
                .forEach(System.out::println); //Por cada resultado mostramos en terminal
    }

    /**
     * Funcion interna que generara un Stream del tipo JobPosition
     * Convertimos una lista que nos devuelve APIJobs a un Stream de JobPositions
     * @param params
     * @return
     */
    private static Stream<JobPosition> executeRequest(Map<String, Object> params){

        APIJobs api = buildApi(APIJobs.class,"https://jobs.github.com");  //Construimos nuestra peticion a la API
        return Stream.of(params) //Stream de las opciones que nos pasaron en este caso los params
                .map(api::jobs) //Mapeamos tomando la funcion que ya definimos
                .flatMap(Collection::stream); //Toma una collecction y la transforma en elementos individuales.
    }
}
