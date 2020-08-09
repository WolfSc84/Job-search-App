package com.wolf.jobsearch.api;
import com.wolf.jobsearch.JobPosition;
import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;
import java.util.List;
import java.util.Map;

@Headers("Accept: application/json") //Anotacion con la cual indicamos las cabeceras que se enviaran por medio de nuestra aplicacion
                                     //debido que son los tipos de datos que vamos a estar recibiendo, en este caso tipo JSON.
/**Clase para manejar la base de las peticiones que hagamos con la libreria feign
 *
 */
public interface APIJobs {


    @RequestLine("GET /positions.json") //Con esto le decimos a feign como tiene que ser la peticion web es decir el tipo de metodo http que vamos a utilizar
                                        //para este caso un GET que apunta hacia positions.json

    List<JobPosition> jobs(@QueryMap Map<String, Object> queryMap); //Listado de trabajos disponibles. Definimos los resultados
                                                                    //Necesitamos generar un QueryMap(peticion) del tipo Map<String a Objeto>. (Usaremos un Map para enlazara cada elemento con su par).


}
