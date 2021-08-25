package adapter;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CostableToPricable implements Pricable{
    private final Costable costable;

    @Override
    public int getPrice() {
        return costable.cost();
    }
}
