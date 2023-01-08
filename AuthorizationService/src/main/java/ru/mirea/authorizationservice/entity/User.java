package ru.mirea.authorizationservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

	@Id
	private long id;

	@Column(name = "user_email")
	private String email;

	@Column(name = "user_name")
	private String username;

	@Column(name = "user_password")
	private String password;

}
