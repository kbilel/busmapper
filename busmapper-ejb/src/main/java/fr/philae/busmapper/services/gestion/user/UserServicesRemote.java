package fr.philae.busmapper.services.gestion.user;

import java.util.List;

import javax.ejb.Remote;

import fr.philae.busmapper.domain.User;

@Remote
public interface UserServicesRemote {
	Boolean addUser(User user );
	Boolean updateUser(User user);
	Boolean deleteUser(User user);
	User findUserById(Integer idUser);
	User findUserByUsername(String name);
	List<User>findAllUsers();
	User authentificate(String login,String pwd);
	Integer findParticipateOrNot(String participate);
	Integer findUserByLevel(String level);

	
	
}
