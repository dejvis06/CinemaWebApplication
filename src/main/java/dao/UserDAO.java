package dao;

import javax.faces.context.FacesContext;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import hibernate.HibernateLayer;
import model.User;

public class UserDAO extends HibernateLayer {

	public void destroySession() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}

	public void saveUser(User user) {
		try {
			begin();
			getEntityManager().persist(user);
			commit();
		} catch (RuntimeException e) {
			rollBack();
		}
	}

	public void updateUser(User user) {
		try {
			begin();
			getEntityManager().merge(user);
			commit();
		} catch (RuntimeException e) {
			rollBack();
		}
	}

	public void deleteUser(User user) {
		try {
			begin();
			getEntityManager().remove(user);
			commit();
		} catch (RuntimeException e) {
			rollBack();
		}
	}

	public User getUser(User user) {
		Query query = getEntityManager()
				.createQuery("from User user where user.username =:username " + " and user.password =:password");
		query.setParameter("username", user.getUsername());
		query.setParameter("password", user.getPassword());

		try {
			User dbUser = (User) query.getSingleResult();
			return (User) dbUser;
		} catch (NoResultException e) {
			return null;
		}
	}

	public boolean checkUsername(String username) {
		try {
			Query query = getEntityManager().createQuery("from User user where user.username =:username");
			query.setParameter("username", username);

			User user = (User) query.getSingleResult();
			if (user == null) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			return false;
		}

	}

}
