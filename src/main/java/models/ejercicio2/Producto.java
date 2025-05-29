package models.ejercicio2;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Producto {
    private String nombre;
    private String categoria;
    private BigDecimal precio;
    private int stock;
    private LocalDate fechaIngreso;

    public Producto(String nombre, String categoria, BigDecimal precio, int stock, LocalDate fechaIngreso) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
        this.fechaIngreso = fechaIngreso;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getCategoria() { return categoria; }
    public BigDecimal getPrecio() { return precio; }
    public int getStock() { return stock; }
    public LocalDate getFechaIngreso() { return fechaIngreso; }

    @Override
    public String toString() {
        return String.format("%s (%s) - $%.2f - Stock: %d",
                nombre, categoria, precio, stock);
    }
}
