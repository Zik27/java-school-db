package adapter;

import java.util.List;
import java.util.function.Supplier;

import static homework.lab3.utils.ParamsGenerator.getRandomElement;

/**
 * @author Evgeny Borisov
 */
public class ProductRepo {

    private List<Supplier<? extends Costable>> products = List.of(Chair::new,Table::new);

    public Costable getProduct() {
        return getRandomElement(products).get();
    }
}
