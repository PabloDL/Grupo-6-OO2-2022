package com.unla.Grupo6OO22022.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author pablo
 *
 */
@Entity
@Getter @Setter @NoArgsConstructor
public class Credenciales {
	@Id
    @Column(name = "user_id")
    private Long id;

   
    @OneToOne
    @MapsId
    @JoinColumn(name = "idUsuario")
    private Usuario propietario;
    @Column(name = "usuario")
	private String usuario;
    @Column(name = "contraseña")
	private String contraseña;
	
	public Credenciales(String usuario, String contraseña) {
		super();
		this.usuario = usuario;
		this.contraseña = contraseña;
	}
	
	
}
