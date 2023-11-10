package com.cibertec.edu.pe.models;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Matricula implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_matricula")
	int id;
	
	String tipo_matricula;
	String fec_matricula;
	String periodo_matricula;
	
	@ManyToMany(mappedBy = "matriculas")
	Set<Curso>cursos;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_alumno",referencedColumnName = "id_alumno")
	Alumno alumno;
}
