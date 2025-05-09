package org.example.model;

public class Pelicula {
    public int codigo_pelicula;
    public String titulo;
    public String idioma;
    public String formato;
    public String genero;
    public int codigo_productora;

    public Pelicula(int codigo_pelicula, String titulo, String idioma, String formato,
                    String genero, int codigo_productora) {
        this.codigo_pelicula= codigo_pelicula;
        this.titulo = titulo;
        this.idioma = idioma;
        this.formato = formato;
        this.genero = genero;
        this.codigo_productora = codigo_productora;
    }

    public Pelicula(){
    };

    //getters

    public int getCodigo_pelicula() { return codigo_pelicula; }
    public String getTitulo() { return titulo; }
    public String getIdioma() { return idioma; }
    public String getFormato() { return formato; }
    public String getGenero() { return genero; }
    public int getCodigo_productora() { return codigo_productora; }


//setters

// Setters
public void setCodigo_pelicula(int codigo_pelicula) {
    this.codigo_pelicula = codigo_pelicula;
}

public void setTitulo(String titulo) {
    this.titulo = titulo;
}

public void setIdioma(String idioma) {
    this.idioma = idioma;
}

public void setFormato(String formato) {
    this.formato = formato;
}

public void setGenero(String genero) {
    this.genero = genero;
}

public void setCodigo_productora(int codigo_productora) {
    this.codigo_productora = codigo_productora;
}


    @Override
    public String toString() {
        return "Pelicula{" +
                "titulo='" + titulo + '\'' +
                ", idioma='" + idioma + '\'' +
                ", genero='" + genero + '\'' +
                ", formato='" + formato + '\'' +
                ", codigo_productora=" + codigo_productora +
                '}';
    }

}
