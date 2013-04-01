package net.studyprojects.calcdespesas.jpa.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GeraTabelas {

	public static void main(String[] args) {

		System.out.println("Inicializando JPA...");

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("controledespesas");

		factory.close();

	}
}
