package com.subasta.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "subastas")
public class Subasta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "obra_id", nullable = false, unique = true)
    private Obra obra;

    @Column(nullable = false)
    private LocalDateTime fechaInicio;

    @Column(nullable = false)
    private LocalDateTime fechaFin;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoSubasta estado;

    // Para el patrón Factory (NORMAL vs RESERVA)
    @Column(nullable = false)
    private String tipoSubasta;

    private BigDecimal precioReserva;

    // Para pujas y patrón Strategy (Jhairo)
    @Column(nullable = false)
    private BigDecimal precioActual;

    private String tipoIncremento; // "FIJO" o "PORCENTUAL"
    private BigDecimal valorIncremento;

    // ID del postor que va ganando actualmente (útil para Observer y adjudicación)
    private Long postorActualId;

    public Subasta() {
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Obra getObra() { return obra; }
    public void setObra(Obra obra) { this.obra = obra; }

    public LocalDateTime getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDateTime fechaInicio) { this.fechaInicio = fechaInicio; }

    public LocalDateTime getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDateTime fechaFin) { this.fechaFin = fechaFin; }

    public EstadoSubasta getEstado() { return estado; }
    public void setEstado(EstadoSubasta estado) { this.estado = estado; }

    public String getTipoSubasta() { return tipoSubasta; }
    public void setTipoSubasta(String tipoSubasta) { this.tipoSubasta = tipoSubasta; }

    public BigDecimal getPrecioReserva() { return precioReserva; }
    public void setPrecioReserva(BigDecimal precioReserva) { this.precioReserva = precioReserva; }

    public BigDecimal getPrecioActual() { return precioActual; }
    public void setPrecioActual(BigDecimal precioActual) { this.precioActual = precioActual; }

    public String getTipoIncremento() { return tipoIncremento; }
    public void setTipoIncremento(String tipoIncremento) { this.tipoIncremento = tipoIncremento; }

    public BigDecimal getValorIncremento() { return valorIncremento; }
    public void setValorIncremento(BigDecimal valorIncremento) { this.valorIncremento = valorIncremento; }

    public Long getPostorActualId() { return postorActualId; }
    public void setPostorActualId(Long postorActualId) { this.postorActualId = postorActualId; }
}