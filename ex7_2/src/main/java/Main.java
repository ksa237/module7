public class Main {

    public static void main(String[] args) {

        Todos todos = new Todos()
                .addPrimary("Побегать")
                .addPrimary("Поработать")
                .addSecondary("Сходить с магазин")
                .addPrimary("Провести вебинар");

        for (String todo : todos) {

            System.out.println("" + todo);
        }


    }

}
