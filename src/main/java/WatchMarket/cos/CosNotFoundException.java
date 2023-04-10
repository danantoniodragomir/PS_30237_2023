package WatchMarket.cos;

public class CosNotFoundException extends RuntimeException{
    CosNotFoundException(Long id) {
        super("Nu a putut fi gasit cosul " + id);
    }
}
