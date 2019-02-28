/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API.model;

import java.time.LocalDate;

/**
 *
 * @author fabian
 */
public class Opinion {
    private int id;
    private LocalDate fecha;
    private int usuarioId;
    private int tiendaId;
    private int compraId;
    private int puntuacion;
    private String comentario;

    public Opinion(int id, LocalDate fecha, int usuarioId, int tiendaId, int compraId, int puntuacion, String comentario) {
        this.id = id;
        this.fecha = fecha;
        this.usuarioId = usuarioId;
        this.tiendaId = tiendaId;
        this.compraId = compraId;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
    }
    
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void setTiendaId(int tiendaId) {
        this.tiendaId = tiendaId;
    }

    public void setCompraId(int compraId) {
        this.compraId = compraId;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getId() {
        return id;
    }
    
    public LocalDate getFecha() {
        return fecha;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public int getTiendaId() {
        return tiendaId;
    }

    public int getCompraId() {
        return compraId;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public String getComentario() {
        return comentario;
    }
    
    @Override
    public String toString() {
        return "Opinion {" +
                "id=" + id +
                ", usuariId ='" + usuarioId + '\'' +
                ", tiendaId='" + tiendaId + '\'' +
                ", compraId='" + compraId + '\'' +
                ", puntuacion='" + puntuacion + '\'' +
                ", comentario='" + this.comentario + '\'' +
                '}';
    }
}
