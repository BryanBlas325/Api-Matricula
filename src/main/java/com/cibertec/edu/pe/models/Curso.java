package com.cibertec.edu.pe.models;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_curso")
	int id;
	
	@Column(name="nombre_curso")
	String nombre;

	@ManyToMany
	@JoinTable(
			  name = "tb_curso_matricula", 
			  joinColumns = @JoinColumn(name = "id_curso"), 
			  inverseJoinColumns = @JoinColumn(name = "id_matricula"))
	Set<Matricula>matriculas;
}
