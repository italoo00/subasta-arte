package com.subasta.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "obras")
public class Obra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String artista;

    @Column(length = 1000)
    private String descripcion;

    private String imagenUrl;

    @Column(nullable = false)
    private BigDecimal precioBase;

    // ID del usuario dueño de la obra (útil para validar autopujas en Proxy)
    @Column(nullable = false)
    private Long propietarioId;

    public Obra() {
    }

    public Obra(String titulo, String artista, String descripcion, String imagenUrl, BigDecimal precioBase, Long propietarioId) {
        this.titulo = titulo;
        this.artista = artista;
        this.descripcion = descripcion;
        this.imagenUrl = imagenUrl;
        this.precioBase = precioBase;
        this.propietarioId = propietarioId;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getArtista() { return artista; }
    public void setArtista(String artista) { this.artista = artista; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getImagenUrl() { return imagenUrl; }
    public void setImagenUrl(String imagenUrl) { this.imagenUrl = imagenUrl; }

    public BigDecimal getPrecioBase() { return precioBase; }
    public void setPrecioBase(BigDecimal precioBase) { this.precioBase = precioBase; }

    public Long getPropietarioId() { return propietarioId; }
    public void setPropietarioId(Long propietarioId) { this.propietarioId = propietarioId; }
}