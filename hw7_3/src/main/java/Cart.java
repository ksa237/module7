public interface Cart {

    // 3. Liskov substitution principle
    // Классы ShoppingCart и DiscountCart "наследники" интерфейса Cart
    // классы имеют свои особенности и специфичность,
    // но всегда имеют общие для друг друга методы как в предке
    // size() общий для обоих классов и могут заменять предка

    // 4. Dependency inversion principle
    // есть требование у предка реализовать печать списка товаров printCart()
    // но реализация дл потомков ShoppingCart и DiscountCart должа быть индивидуальная

    int size();
    void printCart();

}
