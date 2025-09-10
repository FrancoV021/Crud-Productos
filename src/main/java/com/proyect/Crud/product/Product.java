package com.proyect.Crud.product;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.Period;

// Esta clase java es la estructura tipica de una clase entidad para usarla con un CRUD
// CrateReadUpdateDelete

@Entity // se usa para trabajar con bd / @ esta clase representa una tabla em la bd @  LA TABLA PRODUCTO
@Table  // personaliza la tabla (nombre)
public class Product { // tabla de la Bd Crud
    // todos los atributos de esta clase son columnas  en la bd
    @Id // marca la PK de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY) // se usa en conjunto con @id /   se usqa cuando no queremos asignar manualmente el valor de la pk, deja que la bd o el framework lo genere automaticamente - lo que esta entre () es que se va a usar la estratgia identity (será la bd quien se encargue de generar el valor del id por defecto de forma autoincremental)
    private Long id;
    @Column(unique = true)  // column = este atributo de la clase product se mapea con una columna de la tabla de la bd de productos (unique true) si los valores deben ser unicos
    private String name;
    private float price;
    private LocalDate fecha;
    @Transient  // no esta en la bd directamente ya que este dato proviene de otro campo!
    private int antiguedad;

    public Product() { // necesario por las librerias, jpa/Hibernate, estas rewquieren un constructor publico sin parametros para poder instanciar objetos medainte reflexion

    }

    // constructor publico con todos los atrib, (los que no hace falta que esten, son los @Transient)
    public Product(Long id, String name, float price, LocalDate fecha) {  // util para crear un objeto completo, se usa en metodo read para obtemer un registro completo
        this.id = id;
        this.name = name;
        this.price = price;
        this.fecha = fecha;
    }

    // constructor publico sin id
    public Product(String name, float price, LocalDate fecha) { // ideal para insertar un nuevo registro y la bd genera el id automaticamente,
        this.fecha = fecha;
        this.price = price;
        this.name = name;
    }

    // los getters y setters permiten acceder y modificar los atributos de manera controlada y tambien son requeridos por jpa

    public int getAntiguedad() {
        return Period.between(this.fecha, LocalDate.now()).getYears();
    }
    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
