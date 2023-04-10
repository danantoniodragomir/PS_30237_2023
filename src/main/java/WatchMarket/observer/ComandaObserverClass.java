package WatchMarket.observer;

import WatchMarket.cos.Cos;

public class ComandaObserverClass implements ComandaObserverInterface {
    public void onComanda(Cos cos) {
        cos.deleteCos();
    }

}
