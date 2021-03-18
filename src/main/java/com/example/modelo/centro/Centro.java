package com.example.modelo.centro;

import com.example.modelo.aula.Aula;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CTRCentro")
public class Centro {

	@Id
	private String id;
	
	@Column
	private String idCTRSede;
	
	@Column
	private String canvasImage;
	
	@Column
	private Integer width;
	
	@Column
	private Integer height;

	@OneToMany (cascade = {CascadeType.ALL})
	@JoinColumn(name = "idCTRCentro")
	private Set<Aula> aulas;

	public Centro(String id, String idCTRSede, String canvasImage, Integer width, Integer height, Set<Aula> aulas) {
		this.id = id;
		this.idCTRSede = idCTRSede;
		this.canvasImage = canvasImage;
		this.width = width;
		this.height = height;
		this.aulas = aulas;
	}

	public Centro() {

	}

	public Set<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(Set<Aula> aulas) {
		this.aulas = aulas;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdCTRSede() {
		return idCTRSede;
	}

	public void setIdCTRSede(String idCTRSede) {
		this.idCTRSede = idCTRSede;
	}

	public String getCanvasImage() {
		return canvasImage;
	}

	public void setCanvasImage(String canvasImage) {
		this.canvasImage = canvasImage;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	
}
