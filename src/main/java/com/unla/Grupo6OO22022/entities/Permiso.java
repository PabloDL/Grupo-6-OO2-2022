package com.unla.Grupo6OO22022.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="permiso")
public class Permiso {
	@Column(name="")
	private String nombre;
	@Column(name="")
	private String descripcion;
	@Column(name="")
	private boolean habilitado;
	
}
