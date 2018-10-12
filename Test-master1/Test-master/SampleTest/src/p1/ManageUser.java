package p1;

import java.util.List;

public interface ManageUser {

	public String addUser(User user);
	public List<User> getUsers();
	public User getUserById(String id);
	public String updateUser(User user);
	public List<User> getUserByAge(int minAge,int maxAge);
	public String deleteUser(String id);
}
