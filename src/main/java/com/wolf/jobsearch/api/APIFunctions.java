package com.wolf.jobsearch.api;

import feign.Feign;
import feign.gson.GsonDecoder;

/**
 *
 */
public interface APIFunctions {

    /**
     * Metodo estatico que se encarga de generar un objeto de API que sera consumido como una API.
     * Tenemos ventajas manteniendolo por separado, ya que podriamos en un futuro cambiar nuestra libreria por otra
     * que no sea Feign.
     * Podemos cambiar facilmente la libreria por una mas robusta solo en esta parte y el resto del codigo no se afectara
     *
     * Construimos el cliente web, decodificamos los resultados con la libreria Gson de Feign para generar el JSON, apuntando a una API que esta en una URL.
     * Es decir tenemos el medio para decodificar los datos y luego dirigirlos a la URL establecida.
     *
     * @param clazz Es la clase que vamos a generar
     * @param url La url hacia la cual se va generar esta API
     * @param <T> Parametro de nuestra funcion generica
     * @return
     */
    static <T> T buildApi(Class<T> clazz, String url) {
        return Feign.builder() //Construimos el cliente Web por medio del uso de la libreria Feign
                .decoder(new GsonDecoder()) //Decodificamos los resultados usando Gson
                .target(clazz, url); //Apuntamos a una API que esta en una url
    }
}
