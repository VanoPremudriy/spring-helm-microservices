package ru.mirea.authorizationservice.models;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserTO  implements Serializable{

	
	private long id;

	private String email;


	private String username;

	private String password;

}
