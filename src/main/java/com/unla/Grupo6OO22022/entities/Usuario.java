package com.unla.Grupo6OO22022.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author pablo
 *
 */

@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String Apellido;
	@Column(name="tipoDocumento")
	private String tipoDocumento;
	@Column(name="nroDocumento")
	private String nroDocumento;
	@Column(name="email")
	private String email;
//	private Perfil rol;

}
