package fr.philae.busmapper.services.gestion.user;

import java.util.List;

import javax.ejb.Local;

import fr.philae.busmapper.domain.User;


@Local
public interface UserServicesLocal {
	Boolean addUser(User user );
	Boolean updateUser(User user);
	Boolean deleteUser(User user);
	User findUserById(Integer idUser);
	List<User>findAllUsers();
	User findUserByUsername(String name);
	User authentificate(String login,String pwd);
	Integer findParticipateOrNot(String participate);
	Integer findUserByLevel(String level);

}
