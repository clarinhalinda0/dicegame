package com.lunaltas.dicegame.service;

import java.util.List;

import com.lunaltas.dicegame.domain.Bet;

public class BetService {

    @Autowired
    private BetRepository betRepository;

    @Autowired
    private GambleRepository gambleRepository;

    public String finishBet(Long ownerId, Long betId) {

        Bet bet = betRepository.findById(betId)
                .orElseThrow(() -> new RuntimeException("Bet não encontrada"));

        if (!bet.getOwner().getId().equals(ownerId)) {
            throw new RuntimeException("Apenas o DONO da Bet pode encerrar e sortear o vencedor.");
        }

        if (bet.getFinished()) {
            return "Bet já finalizada.";
        }

        // Simulação simples de sorteio
        int resultado = (int) (Math.random() * 6) + 1;
        bet.setWinningResult(String.valueOf(resultado));
        bet.setFinished(true);
        betRepository.save(bet);

        // Identifica vencedor
        List<Gamble> gambles = gambleRepository.findByBetId(betId);

        return gambles.stream()
                .filter(g -> g.getGuess().equals(String.valueOf(resultado)))
                .findFirst()
                .map(g -> "VENCEDOR: " + g.getOwner().getName())
                .orElse("Nenhum vencedor.");
    }
}

