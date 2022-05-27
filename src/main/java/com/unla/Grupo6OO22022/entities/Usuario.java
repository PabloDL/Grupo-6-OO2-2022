package com.unla.Grupo6OO22022.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author pablo
 *
 */

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUsuario")
	private int idUsuario;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellido")
	private String Apellido;
	@Column(name = "tipoDocumento")
	private String tipoDocumento;
	@Column(name = "nroDocumento")
	private String nroDocumento;
	@Column(name = "email")
	private String email;
	@OneToMany(mappedBy = "usuario")
	@Column(name = "rol")
	private Rol rol;
	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Credenciales credenciales;

	public Usuario(int idUsuario, String nombre, String apellido, String tipoDocumento, String nroDocumento,
			String email, Credenciales credenciales) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		Apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.email = email;
		this.credenciales = credenciales;
	}

}
