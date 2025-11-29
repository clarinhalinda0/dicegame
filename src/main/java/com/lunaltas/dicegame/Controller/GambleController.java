@RestController
@RequestMapping("/bets/{betId}/gambles")
public class GambleController {

    @Autowired
    private GambleService gambleService;

    @PostMapping("/{userId}")
    public Gamble create(
            @PathVariable Long userId,
            @PathVariable Long betId,
            @RequestBody Gamble gamble) {

        return gambleService.createGamble(userId, betId, gamble);
    }

    @PutMapping("/{gambleId}/user/{userId}")
    public Gamble update(
            @PathVariable Long userId,
            @PathVariable Long gambleId,
            @RequestBody Gamble gamble) {

        return gambleService.updateGamble(userId, gambleId, gamble);
    }

    @DeleteMapping("/{gambleId}/user/{userId}")
    public void delete(
            @PathVariable Long userId,
            @PathVariable Long gambleId) {

        gambleService.deleteGamble(userId, gambleId);
    }

    @GetMapping
    public List<Gamble> list(@PathVariable Long betId) {
        return gambleService.listGambles(betId);
    }
}
