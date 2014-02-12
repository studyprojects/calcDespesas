package net.studyprojects.calcdespesas.junit.jpa.test;

import java.util.List;

import javax.persistence.EntityManager;

import junit.framework.Assert;
import net.studyprojects.calcdespesas.jpa.test.JPAUtil;
import net.studyprojects.calcdespesas.model.Compra;
import net.studyprojects.calcdespesas.model.Parcela;
import net.studyprojects.calcdespesas.model.factory.ParcelaFactory;

import org.junit.Test;

public class ParcelaFactoryTest {

	@Test
	public void paraCompraEmCincoVezesGeraCincoParcelasDistintas() {

		EntityManager em = JPAUtil.getEntityManager();

		// 1o. Recuperamos a compra na qual colocaremos as parcelas

		Compra compra = em.find(Compra.class, 5L);

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

		Assert.assertEquals(5, parcelasGeradas.size());

	}
}
