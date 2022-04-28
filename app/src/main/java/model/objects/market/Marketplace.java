package model.objects.market;

import java.util.ArrayList;
import java.util.List;

public class Marketplace {
    List<Goods> marketplace;

    public List<Goods> getMarketplace() {
        return marketplace;
    }

    public List<String> getGoodsNames() {
        List<String> goods = new ArrayList<>();

        for (Goods good : marketplace) {
            goods.add(good.getSymbol());
        }

        return goods;
    }
}
