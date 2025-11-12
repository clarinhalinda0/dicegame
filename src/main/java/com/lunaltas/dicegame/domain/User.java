package com.lunaltas.dicegame.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "users")
public class User extends AbstractEntity<Long> {

  @Column(name = "name", nullable = false, length = 60)
	private String name;

  @Column(name = "email", nullable = false, length = 60)
	private String email;

  @Column(name = "password", nullable = false, length = 60)
	private String password;

  @Column(name = "role", nullable = false)
	private String role = "USER";

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }
}
