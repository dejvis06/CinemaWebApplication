package dao;

import java.util.List;

import javax.persistence.Query;

import hibernate.HibernateLayer;
import model.Kategorie;
import model.User;

public class CategorieDAO extends HibernateLayer {

	public List<Kategorie> getCategories() {
		Query query = getEntityManager().createQuery("from Kategorie kategorie");

		List<Kategorie> categorieList = query.getResultList();

		return categorieList;
	}

	public Kategorie getCategorie(String categorieName) {
		Query query = getEntityManager()
				.createQuery("from Kategorie kategorie where kategorie.kategorieName =:kategorieName");
		query.setParameter("kategorieName", categorieName);

		Kategorie dbKategorie = (Kategorie) query.getSingleResult();
		return dbKategorie;
	}

}
