import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiscountCart implements Cart {

    private ShoppingCart shoppingCart;
    private List<String> listItems = new ArrayList<>();
    private final int DISCOUNT_CONDITION = 2;

    public DiscountCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }


    // 3. Liskov substitution principle
    // Классы ShoppingCart и DiscountCart "наследники" интерфейса Cart
    // классы имеют свои особенности и специфичность,
    // но всегда имеют общие для друг друга методы как в предке
    // size() общий для обоих классов и могут заменять предка
    @Override
    public int size() {
        return listItems.size();
    }

    @Override
    public void printCart() {

        // 4. Dependency inversion principle
        // есть требование у предка реализовать печать списка товаров printCart()
        // но реализация дл потомков ShoppingCart и DiscountCart должа быть индивидуальная
        // в данном классе нужно вывожить условия акции

        System.out.println("В случае оплаты вам будут дотсупны скидки на такие товары:");
        System.out.println("Условия скидки: купи одинаковых товаров больше чем " + DISCOUNT_CONDITION);
        listItems.forEach(System.out::println);
    }

    public void compute() {

        Map<String, Integer> repeatMap = new HashMap<>();

        // Подсчитываем частоту каждого элемента
        for (String item : shoppingCart.getListItems()) {
            if (repeatMap.containsKey(item)) {
                repeatMap.put(item, repeatMap.get(item) + 1);
            } else {
                repeatMap.put(item, 1);
            }
        }

        // Добавляем в listItemswithoutRepeats только элементы с частотой ≥ 2
        for (Map.Entry<String, Integer> entry : repeatMap.entrySet()) {
            if (entry.getValue() > DISCOUNT_CONDITION) {
                listItems.add(entry.getKey());
            }
        }

    }

}
