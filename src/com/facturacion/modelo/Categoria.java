package com.facturacion.modelo;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import lombok.*;
 
@Entity @Getter @Setter
public class Categoria {
 
    @Id
    @Hidden // La propiedad no se muestra al usuario. Es un identificador interno
    @GeneratedValue(generator="system-uuid") // Identificador Universal Único (1)
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(length=32)
    String oid;
 
    @Column(length=50)
    String descripcion;
 
}



/*import javax.persistence.*;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import lombok.*;

@Entity @Getter @Setter
public class Categoria {

	@Id
	@Hidden
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid")
	@Column(length=32)
	
	
	//identificador de objeto
	String oid;
	
	@Column(length=50)
	String descripcion;
	
	
} */
