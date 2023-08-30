package mx.edu.utez.secondapp.models;

import com.sun.jdi.PrimitiveValue;

public class clases {
    private long id;
    private String nombre;
    private String estado;
    private String descripcion;
    private long idinstructor;

    public clases() {
    }

    public clases(long id, String nombre, String estado, String descripcion, long idinstructor) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.descripcion = descripcion;
        this.idinstructor = idinstructor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getIdinstructor() {
        return idinstructor;
    }

    public void setIdinstructor(long idinstructor) {
        this.idinstructor = idinstructor;
    }
}
