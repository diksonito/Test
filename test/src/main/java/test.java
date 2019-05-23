import java.util.List;

import de.desolo.jurik.dao.UsersDao;
import de.desolo.jurik.resources.User;

public class test {

	public static void main(String[] args) {
		//String login = "juri";
		UsersDao ud = new UsersDao();
		List<User> foundUser = ud.selectAll(User.class);
		
		//User foundUser = ud.findByLogin(login);
		
		//System.out.println(foundUser);
		
		//System.out.println(foundUser.getLogin() + " " + foundUser.getPassword() + " " + foundUser.getPermission());
		
		
		for (User u : foundUser) {
			System.out.println(u.getLogin() + " " + u.getPassword() + " " + u.getPermission());
		}
		
		User fg = foundUser.get(2);
		ud.delete(fg);
		
		foundUser = ud.selectAll(User.class);
		for (User u : foundUser) {
			System.out.println(u.getLogin() + " " + u.getPassword() + " " + u.getPermission());
		}
		
		fg = foundUser.get(2);
		ud.createUser(fg);
		
		foundUser = ud.selectAll(User.class);
		for (User u : foundUser) {
			System.out.println(u.getLogin() + " " + u.getPassword() + " " + u.getPermission());
		}
		
		
		
	}
}
