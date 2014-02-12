package net.studyprojects.calcdespesas.jpa.test;

import java.util.List;

import javax.persistence.EntityManager;

import net.studyprojects.calcdespesas.model.Compra;
import net.studyprojects.calcdespesas.model.Parcela;
import net.studyprojects.calcdespesas.model.factory.ParcelaFactory;

public class ParcelaFactoryTest {

	public static void main(String[] args) {

		EntityManager em = JPAUtil.getEntityManager();

		// 1o. Recuperamos a compra na qual colocaremos as parcelas

		Compra compra = em.find(Compra.class, 3L);

		// 2o. Geracao das parcelas e associacao com a compra
		// A compra sera associada a parcela no momento de criacao da parcela

		ParcelaFactory parcelaFactory = new ParcelaFactory();

		List<Parcela> parcelasGeradas = parcelaFactory
				.constroiParcelasParaCompra(compra);

		em.getTransaction().begin();

		for (Parcela parcela : parcelasGeradas) {

			em.persist(parcela);

		}

		em.getTransaction().commit();

		em.close();

	}
}
