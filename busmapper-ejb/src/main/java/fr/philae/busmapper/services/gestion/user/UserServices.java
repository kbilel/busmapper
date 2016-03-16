package fr.philae.busmapper.services.gestion.user;




import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import fr.philae.busmapper.domain.User;




/**
 * Session Bean implementation class UserServices
 */
@Stateless
public class UserServices implements UserServicesRemote, UserServicesLocal {
	@PersistenceContext(unitName="busmapper-ejb")
	EntityManager entityManager;
    public UserServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addUser(User user) {
		try {
			entityManager.persist(user);
			System.out.println("ok ejb");
			
			return true;
		} catch (Exception e) {
			System.out.println("erreur ejb");
			return false;
			
		}
		
	}

	@Override
	public Boolean updateUser(User user) {
		try {
			entityManager.merge(user);
			
			return true;
		} catch (Exception e) {
			System.out.println("exception update user");
			return false;
		}
	}

	@Override
	public Boolean deleteUser(User user) {
		try {
			
			
			entityManager.remove(entityManager.merge(user));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User findUserById(Integer idUser) {
		User user=null;
		try {
			user=entityManager.find(User.class, idUser);
		
		} catch (Exception e) {
			
		}
		return user;
	}

	@Override
	public List<User> findAllUsers() {
		Query query=entityManager.createQuery("select u from User u ");
		return query.getResultList();
	}

	@Override
	public User authentificate(String login, String pwd) {
		User user=null;

		try {
			Query query=entityManager.createQuery("select u from User u where u.userName=:l and u.password=:p");	
		query.setParameter("l", login).setParameter("p",pwd);
		user=(User) query.getSingleResult();
		} catch (Exception e) {
			user=null;
		}
		return user;
	}

	@Override
	public User findUserByUsername(String name) {
		
		User user=null;

		try {
			Query query=entityManager.createQuery("select u from User u where u.userName=:l");	
		query.setParameter("l", name);
		user=(User) query.getSingleResult();
		} catch (Exception e) {
			user=null;
		}
		return user;
	}
	@Override
	public Integer findParticipateOrNot(String participate) {
		List<User> users =null;
		Integer number;
		Query query=entityManager.createQuery("select u from User u where u.participation=:p ");
		query.setParameter("p", participate);
		if (query.getResultList()!=null)
		{
			users= query.getResultList();
			number=users.size();
		
		System.out.println("ejb find  auction participate is not null");
		
		return number;
		}
		else {
			number=0;
			return number;
		}
		
		
		
	}
	
	@Override
	public Integer findUserByLevel(String level) {
		List<User> users =null;
		Integer number;
		Query query=entityManager.createQuery("select u from User u where u.level=:p ");
		query.setParameter("p", level);
		if (query.getResultList()!=null)
		System.out.println("ejb find  level is not null");
		users= query.getResultList();
		number=users.size();
		return number;
	}


	}
	
