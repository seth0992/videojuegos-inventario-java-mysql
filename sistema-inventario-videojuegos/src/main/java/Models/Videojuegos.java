package Models;

/**
 * Clase que representa un videojuego con sus atributos y métodos asociados.
 * 
 * @autor seth
 */
public class Videojuegos {
    
    // Atributos privados de la clase
    private int id;                // Identificador único del videojuego
    private String titulo;         // Título del videojuego
    private String plataforma;     // Plataforma en la que se puede jugar el videojuego (ej. PC, PS5)
    private String genero;         // Género del videojuego (ej. Aventura, Acción)
    private double precio;         // Precio del videojuego
    private int stock;             // Cantidad de unidades disponibles en stock
   
    /**
     * Constructor que inicializa un objeto Videojuegos con los atributos dados.
     *
     * @param titulo Título del videojuego
     * @param plataforma Plataforma del videojuego
     * @param genero Género del videojuego
     * @param precio Precio del videojuego
     * @param stock Cantidad de unidades disponibles
     */
    public Videojuegos(String titulo, String plataforma, String genero, double precio, int stock) {
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.genero = genero;
        this.precio = precio;
        this.stock = stock;
       
    }

    /**
     * Constructor que inicializa un objeto Videojuegos con todos los atributos, incluido el ID.
     *
     * @param id Identificador único del videojuego
     * @param titulo Título del videojuego
     * @param plataforma Plataforma del videojuego
     * @param genero Género del videojuego
     * @param precio Precio del videojuego
     * @param stock Cantidad de unidades disponibles
     */
    public Videojuegos(int id, String titulo, String plataforma, String genero, double precio, int stock) {
        this.id = id;
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.genero = genero;
        this.precio = precio;
        this.stock = stock;
    }

    // Métodos getter y setter para acceder y modificar los atributos privados

    /**
     * Obtiene el ID del videojuego.
     *
     * @return ID del videojuego
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el título del videojuego.
     *
     * @return Título del videojuego
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título del videojuego.
     *
     * @param titulo Nuevo título del videojuego
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene la plataforma del videojuego.
     *
     * @return Plataforma del videojuego
     */
    public String getPlataforma() {
        return plataforma;
    }

    /**
     * Establece la plataforma del videojuego.
     *
     * @param plataforma Nueva plataforma del videojuego
     */
    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    /**
     * Obtiene el género del videojuego.
     *
     * @return Género del videojuego
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Establece el género del videojuego.
     *
     * @param genero Nuevo género del videojuego
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Obtiene el precio del videojuego.
     *
     * @return Precio del videojuego
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del videojuego.
     *
     * @param precio Nuevo precio del videojuego
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la cantidad de unidades disponibles del videojuego.
     *
     * @return Cantidad de unidades disponibles
     */
    public int getStock() {
        return stock;
    }

    /**
     * Establece la cantidad de unidades disponibles del videojuego.
     *
     * @param stock Nueva cantidad de unidades disponibles
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

}
