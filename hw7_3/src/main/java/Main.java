import java.util.Scanner;

public class Main {

    public static final String WELCOME = """
            
             -=Наш магазин приветствует вас=-
            -=и предлагает купить наши товары=-
            """;

    public static final String MENU = """
            
            -Для добавления товара в корзину введите 'номер' товара
            -Для удаления товара из корзины введите '-номер' товара
            -Для завершения покупок введите '!'
            -Для отказа от покупок введите 'X'
            """;


    public static final String BYE_WITH_BUY = "Покупки завершены, вот список ваших товаров.";
    public static final String BYE_LONER = "Сегодня не выбрали. Ждем вас снова.";

    public static final String PATH_TO_LOAD_GOODS = "src/main/goods.txt";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;


        //1. Single-responsibility principle
        // класс Goods и класс Cart хранят данные о товарах в списках, списки можно распечатывать, заполнять,
        // но у классов совершенно разная ответственность. Goods - это все товары магазина,
        // Cart - корзина товаров покупателя.
        Goods goods = new Goods(PATH_TO_LOAD_GOODS);
        ShoppingCart shoppingCart = new ShoppingCart();

        //System.out.println(WELCOME);
        printStaticTitle(WELCOME,false);

        while (isRunning) {

            goods.printGoods();
            //System.out.println(MENU);
            printStaticTitle(MENU, false);

            String input = scanner.nextLine();

            if (isFinishProcessInput(input, goods, shoppingCart)) {

                //2. Open-closed principle
                // классы shoppingCart и discountCart содержат данны о товарах покупателя.
                // но discountCart должен вычислять и распечатывать только товары подлежащие акции
                // в дальшейшем этот класс удобно использовать для маркетиговых вычислений,
                // поэтому не меняя класс shoppingCart мы добавляем новую функциональность в discountCart новую функциональность

                DiscountCart discountCart = new DiscountCart(shoppingCart);
                discountCart.compute();

                if (discountCart.size() > 0) {
                    discountCart.printCart();
                }
                break;
            }
        }

        scanner.close(); // Закрываем сканер
    }


    private static boolean isFinishProcessInput(String input, Goods goods, ShoppingCart shoppingCart) {

        if (input.equalsIgnoreCase("X") || input.equalsIgnoreCase("Х")) {
            //System.out.println(BYE_LONER);
            printStaticTitle(BYE_LONER,false);
            return true;
        } else if (input.equals("!")) {
            if (shoppingCart.size() > 0) {
                //System.out.println(BYE_WITH_BUY);
                printStaticTitle(BYE_WITH_BUY, false);
                shoppingCart.printCart();
            } else {
                //System.out.println(BYE_LONER);
                printStaticTitle(BYE_LONER,false);
            }
            return true;
        } else if (isInteger(input)) {
            int number = Integer.parseInt(input);
            if (number > goods.size()) {
                System.out.println("Нет товара с номером " + number);
                return false;
            } else {

                shoppingCart.shiftToCart(goods.get(number), number);

                return false;
            }
        } else
            return false;
    }

    private static boolean isInteger(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    //Принцип DRY. есть повторяющийся код в разных участках модуля, сделаем общий метод.
    private static void printStaticTitle(String title, boolean paragraph){
        System.out.println(title);
        if (paragraph){
            System.out.println();
        }
    }

}
