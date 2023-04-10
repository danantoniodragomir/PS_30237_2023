package WatchMarket.utilizator;

public class UtilizatorNotFoundException extends RuntimeException{
    UtilizatorNotFoundException(Long id) {
        super("Nu a putut fi gasit utilizatorul " + id);
    }
}
