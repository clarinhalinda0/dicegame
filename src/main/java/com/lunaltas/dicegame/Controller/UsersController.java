package com.lunaltas.dicegame.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.lunaltas.dicegame.domain.User;
import com.lunaltas.dicegame.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {

  @Autowired
  private UserService userService;

  @GetMapping("/index") // lista de usuários
  public String index(ModelMap model) {
    model.addAttribute("users", userService.findAll());
    int size = userService.findAll().size();
    model.addAttribute("size", size);
    System.out.println("**********");
    System.out.println("********** Passou pelo index UsersController");
    System.out.println("**********");
    return "/users/index";
  }

  @GetMapping("/new") // novo usuário
  public String newUser(ModelMap model) {
    model.addAttribute("user", new User());
    System.out.println("**********");
    System.out.println("********** Passou pelo newUser UsersController");
    System.out.println("**********");
    return "/users/new";
  }

  @PostMapping("/create") // salvar novo usuário
  public String create(User user) {
    userService.save(user);
    System.out.println("**********");
    System.out.println("********** Passou pelo create UsersController");
    System.out.println("**********");
    return "redirect:/users/show/" + user.getId();
  }

  @GetMapping("/show/{id}") // detalhes do usuário
  public String show(@PathVariable Long id, ModelMap model) {
    model.addAttribute("user", userService.findById(id));
    System.out.println("**********");
    System.out.println("********** Passou pelo show - ID: " + id + " UsersController");
    System.out.println("**********");
    System.out.println("********** User: " + userService.findById(id));
    System.out.println("**********");
    return "/users/show";
  }

  @GetMapping("/edit/{id}") // editar usuário
  public String edit(@PathVariable Long id, ModelMap model) {
    model.addAttribute("user", userService.findById(id));
    System.out.println("**********");
    System.out.println("********** Passou pelo edit - ID: " + id + " UsersController");
    System.out.println("**********");
    System.out.println("********** User: " + userService.findById(id));
    System.out.println("**********");
    return "/users/edit";
  }

  @PutMapping("/update/{id}") // atualizar usuário - put+++
  public String update(@PathVariable Long id, User user) {
    userService.update(user);
    System.out.println("**********");
    System.out.println("********** Passou pelo update - ID: " + id + " UsersController");
    System.out.println("**********");
    return "redirect:/users/show/" + user.getId();
  }

  @DeleteMapping("/delete/{id}") // deletar usuário - delete
  public String delete(@PathVariable Long id) {
    userService.delete(id);
    System.out.println("**********");
    System.out.println("********** Passou pelo delete - ID: " + id + " UsersController");
    System.out.println("**********");
    System.out.println("********** User: " + userService.findById(id));
    System.out.println("**********");
    return "redirect:/users/index";
  }
}
