package com.cibertec.edu.pe.models;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Alumno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_alumno")
	int id;
	
	String nombre;
	
	String apellidos;
	
	@Column(name="fec_nac")
	String fecha;
	
	@Column(name="num_telf")
	String numero;
	
	String sexo;
	
	@OneToOne(mappedBy = "alumno")
	Matricula matricula;
}
