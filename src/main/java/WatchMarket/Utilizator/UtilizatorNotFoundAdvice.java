package WatchMarket.Utilizator;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class UtilizatorNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(UtilizatorNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String UtilizatorNotFoundHandler(UtilizatorNotFoundException ex) {
        return ex.getMessage();
    }
}
