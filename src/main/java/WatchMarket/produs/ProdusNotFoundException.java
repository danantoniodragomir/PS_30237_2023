package WatchMarket.produs;

public class ProdusNotFoundException extends RuntimeException{
    ProdusNotFoundException(Long id) {
            super("Nu a putut fi gasit produsul " + id);
    }

}
