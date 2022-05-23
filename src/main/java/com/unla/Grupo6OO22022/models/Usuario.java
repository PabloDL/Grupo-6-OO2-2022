package com.unla.Grupo6OO22022.models;

import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class Usuario {
	private int idUsuario;
	@Size(min = 3, max = 45)
	private String nombre;
	@Size(min=3, max=45)
	private String Apellido;
	@Size(min=6, max=45)
	private String tipoDocumento;
	@Size(min=3, max=45)
	private String nroDocumento;
	@Email
	@Size(max=90)
	private String email;
//	private Perfil rol;

	public Usuario() {
	}

	public Usuario(int idUsuario, String nombre, String apellido, String tipoDocumento, String nroDocumento,
			String email /* , Perfil rol */) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		Apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.email = email;
//			this.rol = rol;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//		public Perfil getRol() {
//			return rol;
//		}
	//
//		public void setRol(Perfil rol) {
//			this.rol = rol;
//		}

	@Override
	public int hashCode() {
		return Objects.hash(Apellido, email, idUsuario, nombre, nroDocumento, tipoDocumento);
	}

	@Override
	public boolean equals(Object obj) {
		Usuario other = (Usuario) obj;
		return Objects.equals(Apellido, other.Apellido) && Objects.equals(email, other.email)
				&& idUsuario == other.idUsuario && Objects.equals(nombre, other.nombre)
				&& Objects.equals(nroDocumento, other.nroDocumento)
				&& Objects.equals(tipoDocumento, other.tipoDocumento);
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", Apellido=" + Apellido + ", tipoDocumento="
				+ tipoDocumento + ", nroDocumento=" + nroDocumento + ", email=" + email + "]";
	}

}
