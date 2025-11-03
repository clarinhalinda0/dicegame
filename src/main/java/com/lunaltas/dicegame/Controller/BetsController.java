package com.lunaltas.dicegame.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bets")
public class BetsController {

  @GetMapping("/index")
  public String index() {
    System.out.println("**********");
    System.out.println("********** Passou pelo index BetsController");
    System.out.println("**********");
    return "/bets/index";
  }

  @GetMapping("/new")
  public String newBet() {
    System.out.println("**********");
    System.out.println("********** Passou pelo new BetsController");
    System.out.println("**********");
    return "/bets/new";
  }

  @PostMapping("/create")
  public String create() {
    System.out.println("**********");
    System.out.println("********** Passou pelo create BetsController");
    System.out.println("**********");
    return "redirect:/bets/show/1";
  }

  @GetMapping("/show/{id}")
  public String show(@PathVariable Long id) {
    System.out.println("**********");
    System.out.println("********** Passou pelo show - ID: " + id + " BetsController");
    System.out.println("**********");
    return "/bets/show";
  }

  @GetMapping("/edit/{id}")
  public String edit(@PathVariable Long id) {
    System.out.println("**********");
    System.out.println("********** Passou pelo edit - ID: " + id + " BetsController");
    System.out.println("**********");
    return "/bets/edit";
  }

  @PutMapping("/update/{id}")
  public String update(@PathVariable Long id) {
    System.out.println("**********");
    System.out.println("********** Passou pelo update - ID: " + id + " BetsController");
    System.out.println("**********");
    return "redirect:/bets/show/1";
  }

  @DeleteMapping("/delete/{id}")
  public String delete(@PathVariable Long id) {
    System.out.println("**********");
    System.out.println("********** Passou pelo delete - ID: " + id + " BetsController");
    System.out.println("**********");
    return "redirect:/bets/index";
  }
}
