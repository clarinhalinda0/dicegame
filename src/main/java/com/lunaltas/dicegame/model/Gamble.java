@Entity
public class Gamble {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String guess;   // palpite do usuário
    private Double amount;  // valor apostado

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;     // dono da aposta (quem apostou)

    @ManyToOne
    @JoinColumn(name = "bet_id")
    private Bet bet;        // Bet na qual essa Gamble foi feita

    // getters e setters
}
