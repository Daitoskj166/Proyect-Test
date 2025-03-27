package model;

public class Book {
    private String titulo;
    private String autor;
    private long ISBN;
    private int año;
    private boolean disponible;

    public Book(String titulo, String autor, long ISBN, int año, boolean disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.año = año;
        this.disponible = disponible;
    }

    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public long getISBN() {
        return ISBN;
    }

    public int getAño() {
        return año;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

 
    public static boolean validarISBN(long ISBN) {
        String isbnStr = String.valueOf(ISBN);
        return isbnStr.length() == 13 && isbnStr.startsWith("978");
    }

 
    public static boolean validarAño(int año) {
        return año >= -800 && año <= 2025;
    }

    @Override
    public String toString() {
        return "Libro: " + titulo + " | Autor: " + autor + " | ISBN: " + ISBN + " | Año: " + año + " | Disponible: " + disponible;
    }
}