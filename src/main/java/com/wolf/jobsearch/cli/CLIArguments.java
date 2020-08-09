package com.wolf.jobsearch.cli;

import com.beust.jcommander.Parameter;

/**
 * Clase que representa los argumentos que va tomar JCommander. JCommander tambien trabaja por medio de Anotaciones
 */
public class CLIArguments {

    //Creamos un constructor que existe a nivel paquete, para prevenir que alguien mas cree objetos de esta clase
    CLIArguments(){
    }

    //Definimos anotaciones para poder trabajar con el CLI
    @Parameter( //Indicamos que esta propiedad es un parametro que podemos recibir por terminal
            required = true, //Sin keyword no podemos hacer peticion
            descriptionKey = "KEYWORD", //Es lo que se mostrara en la ayuda
            validateWith = CLIKeywordValidator.class, //Validamos con una clase especifica
            description = "KEYWORD" //Descripcion textual
    )
    private String keyword; //Keyword que estaremos buscando

    //Definimos anotaciones para poder trabajar con el CLI
    @Parameter( //Indicamos que esta propiedad es un parametro que podemos recibir por terminal
            names = {"--location","-l"}, //Indicamos los parametros para definir location
            description = "Cada busqueda puede incluir ubicacion" //Descripcion textual
    )
    private String location; //Especificar la ubicacion donde buscar

    //Definimos anotaciones para poder trabajar con el CLI
    @Parameter( //Indicamos que esta propiedad es un parametro que podemos recibir por terminal
            names = {"--page","-p"}, //Indicamos los parametros para paginacion
            description = "La API devuelve 50 resultados. Usa un numero para la pagina" //Descripcion textual
    )
    private int page = 0; //Inicializar la pagina de busqueda.

    //Definimos anotaciones para poder trabajar con el CLI
    @Parameter( //Indicamos que esta propiedad es un parametro que podemos recibir por terminal
            names = {"--full-time","-ft"}, //Indicamos los parametros para jornada laboral
            description = "Agregar si queremos trabajos de tiempo completo" //Descripcion textual
    )
    private boolean isFullTime = false; //Definir como deseamos el tipo de jornada laboral

    //Definimos anotaciones para poder trabajar con el CLI
    @Parameter( //Indicamos que esta propiedad es un parametro que podemos recibir por terminal
            names = "--markdown", //Indicamos los parametros para markdown
            description = "Obtener los resultados en markdown" //Descripcion textual
    )
    private boolean isMarkDown = false; //Indicar que nos devuelva los datos en formato markdown

    //Definimos anotaciones para poder trabajar con el CLI
    @Parameter( //Indicamos que esta propiedad es un parametro que podemos recibir por terminal
            names = "--help", //Indicamos los parametros para la ayuda
            validateWith = CLIHelpValidator.class, //Validamos con una clase especifica
            help = true, //Esta es especificamente la ayuda. Lo definimos con un booleano.
            description = "Mostrar esta ayuda" //Descripcion textual
    )
    private boolean isHelp = false; //Mostrar las opciones disponibles en un texto amigable

    public String getKeyword() {
        return keyword;
    }

    public String getLocation() {
        return location;
    }

    public int getPage() {
        return page;
    }

    public boolean isFullTime() {
        return isFullTime;
    }

    public boolean isMarkDown() {
        return isMarkDown;
    }

    public boolean isHelp() {
        return isHelp;
    }

    /**
     * Mostrar en pantalla los atributos del objeto a modo de debug
     * @return  Muestra los atributos en un string concatenando los valores.
     */
    @Override //Sobrescribimos nuestro metodo. Polimorfismo
    public String toString() {
        return "CLIArguments{" +
                "keyword='" + keyword + '\'' +
                ", location='" + location + '\'' +
                ", page=" + page +
                ", isFullTime=" + isFullTime +
                ", isMarkDown=" + isMarkDown +
                ", isHelp=" + isHelp +
                '}';
    }

    /**
     * Funcion especie de Supplier. Esta funcion se encarga de modificar la manera en que se creen los argumentos
     * de terminal, cambie. De esta forma no dependemos de un constructor
     */
    public static CLIArguments newInstance(){
        return new CLIArguments();
    }
}
