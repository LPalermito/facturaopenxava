package com.facturacion.modelo;

import java.time.*;
import java.util.*;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;
import org.openxava.calculators.*;

import com.calculadores.*;

import lombok.*;

@Entity
@Getter @Setter


@View(members =
		"anyo, numero, fecha;" +
		"cliente;" +
		"detalles;" +
		"observaciones"
		)

public class Factura {

	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@Hidden
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(length = 32)
	String oid;
	
	
	@DefaultValueCalculator(CurrentYearCalculator.class) //es el año actual
	@Column(length = 4)
	int anyo;
	
	
	@Column(length = 6)
	 @DefaultValueCalculator(value  = CalculadorProximo.class, //es la fecha actual
	properties = @PropertyValue(name = "anyo")) 
	int numero;
	//esto es para insertar el año en el calculador
	
	
	@Required
	@DefaultValueCalculator(CurrentLocalDateCalculator.class)
	LocalDate fecha;
	
	
	
	
	//agregar cliente a la factura, es obligatrio por eso el opcional false
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@ReferenceView("Simple") 	//mostrarlo de forma compacta
	Cliente cliente;
	
	
	
	@ElementCollection
	@ListProperties("producto.numero, producto.descripcion, cantidad")
	Collection<Detalle> detalles; 
	//para agregar el producto al detalle de la factura
	
	
	
	@Stereotype("MEMO")
	String observaciones;
	
}
