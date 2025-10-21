import java.util.Iterator;
import java.util.Random;

public class Randoms implements Iterable<Integer> {
    protected Random random;
    protected int min;
    protected int max;


    //для получения случайного числа в заданном интервале:
    //1. используем класс Random из пакета java.util
    //данный класс Random возвращает случайное число на интервале начиная с нуля
    //чтобы выполнить генерацию случайного int на интервале min, max
    //воспользуемся формулой nextInt(max - min + 1) + min;
    //в конструкторе нашего собственного класса Randoms только запомним min.max
    //и разумеется созданим экземляр nextInt(max - min + 1) + min;
    public Randoms(int min, int max) {
        random = new Random();
        this.min = min;
        this.max = max;
    }


    //для реализации Iterable<Integer> переоперделим функцию, но она возвращает Iterator,
    //для которого характерно два момента: есть следующий? и верни следующий.
    //в условии задания сказано что реализуем бесконечную итерацию, значит hasNext() сделаем всегла true
    //а для next() воспользуемся получением случайного числа на интервале с доработанной формулой.
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Integer next() {
                return random.nextInt(max - min + 1) + min;
            }
        };
    }


}