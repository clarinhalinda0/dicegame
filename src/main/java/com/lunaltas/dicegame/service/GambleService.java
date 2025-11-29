@Service
public class GambleService {

    @Autowired
    private GambleRepository gambleRepository;

    @Autowired
    private BetRepository betRepository;

    @Autowired
    private UserRepository userRepository;

    public Gamble createGamble(Long userId, Long betId, Gamble gambleDTO) {

        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Bet bet = betRepository.findById(betId)
            .orElseThrow(() -> new RuntimeException("Bet não encontrada"));

        Gamble gamble = new Gamble();
        gamble.setAmount(gambleDTO.getAmount());
        gamble.setGuess(gambleDTO.getGuess());
        gamble.setOwner(user);
        gamble.setBet(bet);

        return gambleRepository.save(gamble);
    }

    public Gamble updateGamble(Long userId, Long gambleId, Gamble updated) {

        Gamble gamble = gambleRepository.findById(gambleId)
            .orElseThrow(() -> new RuntimeException("Aposta não encontrada"));

        if (!gamble.getOwner().getId().equals(userId)) {
            throw new RuntimeException("Você NÃO pode editar apostas de outro usuário.");
        }

        gamble.setGuess(updated.getGuess());
        gamble.setAmount(updated.getAmount());
        return gambleRepository.save(gamble);
    }

    public void deleteGamble(Long userId, Long gambleId) {

        Gamble gamble = gambleRepository.findById(gambleId)
            .orElseThrow(() -> new RuntimeException("Aposta não encontrada"));

        if (!gamble.getOwner().getId().equals(userId)) {
            throw new RuntimeException("Você NÃO pode deletar apostas de outro usuário.");
        }

        gambleRepository.delete(gamble);
    }

    public List<Gamble> listGambles(Long betId) {
        return gambleRepository.findByBetId(betId);
    }
}
