package com.wolf.jobsearch;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Esta es una plenum Java Object que se recibira la informacion directa del JSON que nos devuelva la
 * API de Github.
 */
public class  JobPosition {
    private String id; //Id del trabajo
    private String type; //Tipo de jornada del trabajo
    private String url; //Url de la oferta
    @SerializedName("created_at") //Con esto podemos cambiar el nombre de la variable que nos entrega JSON
                                  //colocando entre parentesis el nombre que tiene en la API y seguido definimos el nombre que deseamos.
    private String createdAt; //Fecha de creacion de la oferta laboral
    @SerializedName("company_url")//Con esto podemos cambiar el nombre de la variable que nos entrega JSON
                                  //colocando entre parentesis el nombre que tiene en la API y seguido definimos el nombre que deseamos.
    private String companyURL; //URL de la empresa que ofrece el cargo
    private String title; //Titulo de la oferta laboral
    private String description; //Descripcion de la oferta laboral
    @SerializedName("company_logo") //Con esto podemos cambiar el nombre de la variable que nos entrega JSON
                                    //colocando entre parentesis el nombre que tiene en la API y seguido definimos el nombre que deseamos.
    private String companyLogo; //Logo de la empresa
    @SerializedName("how_to_apply") //Con esto podemos cambiar el nombre de la variable que nos entrega JSON
                                    //colocando entre parentesis el nombre que tiene en la API y seguido definimos el nombre que deseamos.
    private String howApply; //Indica como aplicar.

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCompanyURL() {
        return companyURL;
    }

    public void setCompanyURL(String companyURL) {
        this.companyURL = companyURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    public String getHowApply() {
        return howApply;
    }

    public void setHowApply(String howApply) {
        this.howApply = howApply;
    }

    /**
     * Usaremos el metodo equal() y hascode() a utilizar para tener una manera de diferenciar los objetos de si mismos
     * Metodo equals() compara un objeto contra la instancia que tenemos
     * @param o Recibe el objeto que vamos a evaluar con equals
     * @return Valida si es igual el argumento al de nuestros objeto instanciado
     */
    @Override //Sobrescribimos nuestro metodo. Polimorfismo
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobPosition that = (JobPosition) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(type, that.type) &&
                Objects.equals(url, that.url) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(companyURL, that.companyURL) &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description) &&
                Objects.equals(companyLogo, that.companyLogo) &&
                Objects.equals(howApply, that.howApply);
    }

    /**
     * Usaremos el metodo equal() y hascode() a utilizar para tener una manera de diferenciar los objetos de si mismos
     * Metodo hashCode()
     * @return Retorna el valor del hash de los atributos del objeto
     */
    @Override //Sobrescribimos nuestro metodo. Polimorfismo
    public int hashCode() {
        return Objects.hash(id, type, url, createdAt, companyURL, title, description, companyLogo, howApply);
    }

    /**
     * Este metodo nos permite ver por pantalla los valores de nuestros objetos
     * @return Nos retorna un string con los valores de los atributos del objeto concatenados.
     */
    @Override //Sobrescribimos nuestro metodo. Polimorfismo
    public String toString() {
        return "JobPosition{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", companyURL='" + companyURL + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", companyLogo='" + companyLogo + '\'' +
                ", howApply='" + howApply + '\'' +
                '}';
    }
}
