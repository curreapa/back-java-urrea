package com.privilege.app.models.entity;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "privilegios")
public class Privilegio{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPrivilegio;
	@Column(name="clavePrivilegio", unique = true, nullable = false)
	private Long clavePrivilegio;
	@Column(name="nombreCorto")
	private String nombreCorto;
	@Column(name="shortPrivilegio")
	private String shortPrivilegio;
	

	public Privilegio(){
		
	}

	public Privilegio(Long idPrivilegio, Long clavePrivilegio, String nombreCorto, String shortPrivilegio) {
		this.idPrivilegio = idPrivilegio;
		this.clavePrivilegio = clavePrivilegio;
		this.nombreCorto = nombreCorto;
		this.shortPrivilegio = shortPrivilegio;
	}

	public Long getIdPrivilegio() {
		return idPrivilegio;
	}

	public void setIdPrivilegio(Long idPrivilegio) {
		this.idPrivilegio = idPrivilegio;
	}

	public Long getClavePrivilegio() {
		return clavePrivilegio;
	}

	public void setClavePrivilegio(Long clavePrivilegio) {
		this.clavePrivilegio = clavePrivilegio;
	}

	public String getNombreCorto() {
		return nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	public String getShortPrivilegio() {
		return shortPrivilegio;
	}

	public void setShortPrivilegio(String shortPrivilegio) {
		this.shortPrivilegio = shortPrivilegio;
	}
	
}