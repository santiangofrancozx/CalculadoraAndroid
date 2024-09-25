package com.example.superagenda;

import android.os.Parcel;
import android.os.Parcelable;
public class Contacto implements Parcelable {

    // Atributos
    private String nombre;
    private String apellido;
    private String documento;
    private int edad;
    private String telefono;
    private String direccion;
    private String fechaNacimiento; // En formato dd/mm/yyyy
    private String email;
    private String estadoCivil; // Casado o Soltero
    private String genero; // Masculino, Femenino, otro
    private String gustos; // Música, Deporte, Cine, Comida, Viajes, Libros
    private String equipoFutbolFavorito;
    private String peliculaFavorita;
    private String colorFavorito;
    private String comidaFavorita;
    private String libroFavorito;
    private String cancionFavorita;
    private String descripcionPersonal;

    // Código será generado automáticamente
    private int codigo;

    // Constructor
    public Contacto(String nombre, String apellido, String documento, int edad, String telefono, String direccion, 
                    String fechaNacimiento, String email, String estadoCivil, String genero, String gustos, 
                    String equipoFutbolFavorito, String peliculaFavorita, String colorFavorito, String comidaFavorita, 
                    String libroFavorito, String cancionFavorita, String descripcionPersonal, int codigo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.edad = edad;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.estadoCivil = estadoCivil;
        this.genero = genero;
        this.gustos = gustos;
        this.equipoFutbolFavorito = equipoFutbolFavorito;
        this.peliculaFavorita = peliculaFavorita;
        this.colorFavorito = colorFavorito;
        this.comidaFavorita = comidaFavorita;
        this.libroFavorito = libroFavorito;
        this.cancionFavorita = cancionFavorita;
        this.descripcionPersonal = descripcionPersonal;
        this.codigo = codigo; // Generar el código automáticamente
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getGustos() {
        return gustos;
    }

    public void setGustos(String gustos) {
        this.gustos = gustos;
    }

    public String getEquipoFutbolFavorito() {
        return equipoFutbolFavorito;
    }

    public void setEquipoFutbolFavorito(String equipoFutbolFavorito) {
        this.equipoFutbolFavorito = equipoFutbolFavorito;
    }

    public String getPeliculaFavorita() {
        return peliculaFavorita;
    }

    public void setPeliculaFavorita(String peliculaFavorita) {
        this.peliculaFavorita = peliculaFavorita;
    }

    public String getColorFavorito() {
        return colorFavorito;
    }

    public void setColorFavorito(String colorFavorito) {
        this.colorFavorito = colorFavorito;
    }

    public String getComidaFavorita() {
        return comidaFavorita;
    }

    public void setComidaFavorita(String comidaFavorita) {
        this.comidaFavorita = comidaFavorita;
    }

    public String getLibroFavorito() {
        return libroFavorito;
    }

    public void setLibroFavorito(String libroFavorito) {
        this.libroFavorito = libroFavorito;
    }

    public String getCancionFavorita() {
        return cancionFavorita;
    }

    public void setCancionFavorita(String cancionFavorita) {
        this.cancionFavorita = cancionFavorita;
    }

    public String getDescripcionPersonal() {
        return descripcionPersonal;
    }

    public void setDescripcionPersonal(String descripcionPersonal) {
        this.descripcionPersonal = descripcionPersonal;
    }

    public int getCodigo() {
        return codigo;
    }
    protected Contacto(Parcel in) {
        nombre = in.readString();
        apellido = in.readString();
        documento = in.readString();
        edad = in.readInt();
        telefono = in.readString();
        direccion = in.readString();
        fechaNacimiento = in.readString();
        email = in.readString();
        estadoCivil = in.readString();
        genero = in.readString();
        gustos = in.readString();
        equipoFutbolFavorito = in.readString();
        peliculaFavorita = in.readString();
        colorFavorito = in.readString();
        comidaFavorita = in.readString();
        libroFavorito = in.readString();
        cancionFavorita = in.readString();
        descripcionPersonal = in.readString();
        codigo = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(apellido);
        dest.writeString(documento);
        dest.writeInt(edad);
        dest.writeString(telefono);
        dest.writeString(direccion);
        dest.writeString(fechaNacimiento);
        dest.writeString(email);
        dest.writeString(estadoCivil);
        dest.writeString(genero);
        dest.writeString(gustos);
        dest.writeString(equipoFutbolFavorito);
        dest.writeString(peliculaFavorita);
        dest.writeString(colorFavorito);
        dest.writeString(comidaFavorita);
        dest.writeString(libroFavorito);
        dest.writeString(cancionFavorita);
        dest.writeString(descripcionPersonal);
        dest.writeInt(codigo);
    }

    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public String toString() {
        return "Contacto{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", documento='" + documento + '\'' +
                ", edad=" + edad +
                ", telefono='" + telefono + '\n' +
                ", direccion='" + direccion + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", email='" + email + '\'' +
                ", estadoCivil='" + estadoCivil + '\'' +
                ", genero='" + genero + '\'' +
                ", gustos='" + gustos + '\'' +
                ", equipoFutbolFavorito='" + equipoFutbolFavorito + '\'' +
                ", peliculaFavorita='" + peliculaFavorita + '\'' +
                ", colorFavorito='" + colorFavorito + '\'' +
                ", comidaFavorita='" + comidaFavorita + '\'' +
                ", libroFavorito='" + libroFavorito + '\'' +
                ", cancionFavorita='" + cancionFavorita + '\'' +
                ", descripcionPersonal='" + descripcionPersonal + '\'' +
                ", codigo='" + codigo + '\'' +
                '}';
    }


    public static final Creator<Contacto> CREATOR = new Creator<Contacto>() {
        @Override
        public Contacto createFromParcel(Parcel in) {
            return new Contacto(in);
        }

        @Override
        public Contacto[] newArray(int size) {
            return new Contacto[size];
        }


    };

}



