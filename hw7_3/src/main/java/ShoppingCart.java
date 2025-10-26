import java.util.ArrayList;
import java.util.List;

public class ShoppingCart implements Cart {

    private List<String> listItems = new ArrayList<>();

    public ShoppingCart() {

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
        // в данном классе нужно провто выводить список товаров покупателя
        listItems.forEach(System.out::println);
    }

    public void shiftToCart(String item, int sign) {

        if (sign > 0) {
            listItems.add(item);
        } else if (sign < 0) {
            listItems.remove(item);
        }
    }

    public List<String> getListItems() {
        return listItems;
    }
}
