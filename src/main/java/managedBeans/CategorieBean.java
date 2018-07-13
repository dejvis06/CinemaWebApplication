package managedBeans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import managers.CategorieManager;
import model.Kategorie;

@ManagedBean
public class CategorieBean {

	private Kategorie categorie;
	private CategorieManager categorieManager;
	
	public CategorieBean() {
		categorie = new Kategorie();
		categorieManager = new CategorieManager();
	}

	public Kategorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Kategorie categorie) {
		this.categorie = categorie;
	}

	public CategorieManager getCategorieManager() {
		return categorieManager;
	}

	public void setCategorieManager(CategorieManager categorieManager) {
		this.categorieManager = categorieManager;
	}

	public List<Kategorie> getCategories(){
		return categorieManager.getCategories();
	}
	
	public Kategorie getCategorieByName() {
		return categorieManager.getCategorieByName(categorie.getKategorieName());
	}
}
