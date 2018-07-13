package managers;

import java.util.List;

import dao.CategorieDAO;
import model.Kategorie;

public class CategorieManager {

	private CategorieDAO categorieDAO = new CategorieDAO();

	public Kategorie getCategorieByName(String categorieName) {
		return categorieDAO.getCategorie(categorieName);
	}
	
	public List<Kategorie> getCategories(){
		return categorieDAO.getCategories();
	}
}
