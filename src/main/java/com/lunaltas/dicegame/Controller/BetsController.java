package com.lunaltas.dicegame.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lunaltas.dicegame.domain.Bet;
import com.lunaltas.dicegame.service.BetService;
import com.lunaltas.dicegame.service.UserService;

@Controller
@RequestMapping("/bets")
public class BetsController {

  @Autowired
  private BetService betService;

  @Autowired
  private UserService userService;

  @GetMapping("/index")
  public String index(ModelMap model) {
    model.addAttribute("bets", betService.findAll());
    int size = betService.findAll().size();
    model.addAttribute("size", size);
    return "/bets/index";
  }

  @GetMapping("/new")
  public String newBet(ModelMap model) {
    model.addAttribute("bet", new Bet());
    model.addAttribute("users", userService.findAll());
    return "/bets/new";
  }

  @PostMapping("/create")
  public String create( Bet bet) {
    System.out.println("**********");
    System.out.println("********** Passou pelo create - BetsController");
    System.out.println("********** Bet: " + bet);
    System.out.println("**********");
    betService.save(bet);
    return "redirect:/bets/show/" + bet.getId();
  }

  @GetMapping("/show/{id}")
  public String show(@PathVariable Long id, ModelMap model) {
    model.addAttribute("bet", betService.findById(id));
    System.out.println("**********");
    System.out.println("********** Passou pelo show - ID: " + id + " BetsController");
    System.out.println("********** Bet: " + betService.findById(id));
    System.out.println("**********");
    return "/bets/show";
  }

  @GetMapping("/edit/{id}")
  public String edit(@PathVariable Long id, ModelMap model) {
    model.addAttribute("bet", betService.findById(id));
    model.addAttribute("users", userService.findAll());
    System.out.println("**********");
    System.out.println("********** Passou pelo edit - ID: " + id + " BetsController");
    System.out.println("**********");
    return "/bets/edit";
  }

  @PutMapping("/update/{id}")
  public String update(@PathVariable Long id, Bet bet) {
    betService.update(bet);
    System.out.println("**********");
    System.out.println("********** Passou pelo update - ID: " + id + " BetsController");
    System.out.println("**********");
    return "redirect:/bets/show/" + bet.getId();
  }

  @DeleteMapping("/delete/{id}")
  public String delete(@PathVariable Long id) {
    betService.delete(id);
    System.out.println("**********");
    System.out.println("********** Passou pelo delete - ID: " + id + " BetsController");
    System.out.println("**********");
    return "redirect:/bets/index";
  }
}
