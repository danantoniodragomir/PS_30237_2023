package WatchMarket.comanda;

public class ComandaNotFoundException extends RuntimeException{
    ComandaNotFoundException(Long id) {
        super("Nu a putut fi gasita comanda " + id);
    }
}
