package com.wolf.jobsearch.cli;

import java.util.HashMap;
import java.util.Map;

/**
 *Clase que nos permite
 */
public class CLIFunctions {

    /**
     * Funcion estatica que nos devuelve un Mapa de String a Objetos
     * @param cliArguments
     * @return
     */
    public static Map<String, Object> toMap(CLIArguments cliArguments){
        //Definimos un Map que convertira de Strin a Object, del tipo HashMap que es una estructura collecion de Java
        Map<String, Object> params = new HashMap<>();

        params.put("description", cliArguments.getKeyword());
        params.put("location", cliArguments.getLocation());
        params.put("full_time", cliArguments.isFullTime());
        params.put("page", cliArguments.getPage());

        if(cliArguments.isMarkDown()){
            params.put("markdown", true);
        }

        return params;
    }

}
