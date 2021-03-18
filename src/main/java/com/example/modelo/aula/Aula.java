package com.example.modelo.aula;

import com.example.modelo.centro.Centro;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "CTRAula")
public class Aula {

	@Id
	private String id;
	@Column
	private int width;
	@Column
	private int height;
	@Column
	private int left_canvas;
	@Column
	private int top_canvas;
	@Column
	private int angle;
	@Column
	private String fill;
	@Column
	private double opacity;
	@Column
	private String canvasImage;

//	@OneToOne(cascade = {CascadeType.ALL})
//	@JoinColumn(name = "idCTRCentro")
//	private Centro idCTRCentro;

	public Aula() {

	}

	public Aula(String id, int width, int height, int left_canvas, int top_canvas, int angle, String fill, double opacity, String canvasImage) {
		this.id = id;
		this.width = width;
		this.height = height;
		this.left_canvas = left_canvas;
		this.top_canvas = top_canvas;
		this.angle = angle;
		this.fill = fill;
		this.opacity = opacity;
		this.canvasImage = canvasImage;
//		this.idCTRCentro = idCTRCentro;
	}

	public String getId() {
		return id;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getLeft_canvas() {
		return left_canvas;
	}

	public int getTop_canvas() {
		return top_canvas;
	}

	public int getAngle() {
		return angle;
	}

	public String getFill() {
		return fill;
	}

	public double getOpacity() {
		return opacity;
	}

	public String getCanvasImage() {
		return canvasImage;
	}

//	public Centro getIdCTRCentro() {
//		return idCTRCentro;
//	}

	public void setId(String id) {
		this.id = id;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setLeft_canvas(int left_canvas) {
		this.left_canvas = left_canvas;
	}

	public void setTop_canvas(int top_canvas) {
		this.top_canvas = top_canvas;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

	public void setFill(String fill) {
		this.fill = fill;
	}

	public void setOpacity(double opacity) {
		this.opacity = opacity;
	}

	public void setCanvasImage(String canvasImage) {
		this.canvasImage = canvasImage;
	}

//	public void setIdCTRCentro(Centro idCTRCentro) {
//		this.idCTRCentro = idCTRCentro;
//	}
}
