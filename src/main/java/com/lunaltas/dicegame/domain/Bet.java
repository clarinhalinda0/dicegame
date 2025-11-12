package com.lunaltas.dicegame.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@SuppressWarnings("serial")
@Entity
@Table(name = "bet")
public class Bet extends AbstractEntity<Long> {

  @Column(name = "name", nullable = false, length = 60)
	private String name;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

}
