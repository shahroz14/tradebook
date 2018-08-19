package in.co.tradecart.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import in.co.tradebook.enums.Enums.UserRole;

@Entity
@Table(name = "user_role_mappings")
public class UserRoleMapping extends Identifiable {
	
	@Enumerated(EnumType.STRING)
	private UserRole userRole;
	
	@ManyToOne
	private User user;

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
