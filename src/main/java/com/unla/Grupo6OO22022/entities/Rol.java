package com.unla.Grupo6OO22022.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "usuario")
public class Rol {
	private String rol;
	private List<Permiso> permisos = new ArrayList<>();
	
	public Rol(String rol, List<Permiso> permisos) {
		super();
		this.rol = rol;
		this.permisos = permisos;
	}
		
}
