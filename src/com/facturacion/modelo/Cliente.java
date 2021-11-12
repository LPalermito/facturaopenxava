package com.facturacion.modelo;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
//marca la clase cliente como una entidad

@Getter @Setter
//hacen publicamente accesibles los campos de aca abajo

@View(name = "Simple", members = "numero, nombre")

public class Cliente {

		//id hace q tenga clave
		@Id
		@Column(length=6)
		//longitud de la columna
		int numero;
		
		
		@Column(length=50)
		@Required
		String nombre;
		
		@Embedded @NoFrame //el no frame hace que no haya un marco en la direccion
		Direccion direccion;
}
