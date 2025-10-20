import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Todos implements Iterable<String> {

    private List<String> primary = new ArrayList<>();
    private List<String> secondary = new ArrayList<>();

    public Todos addPrimary(String task) {
        primary.add(task);
        return this;
    }

    public Todos addSecondary(String task) {
        secondary.add(task);
        return this;
    }


    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {

            boolean isPrimary = true;
            int next = 0;

            @Override
            public boolean hasNext() {
                if (isPrimary) {
                    if (next < primary.size() ){
                        return true;
                    }else{
                        return !secondary.isEmpty();
                    }

                }else {
                    return next < secondary.size();
                }
            }

            @Override
            public String next() {
                if (isPrimary) {

                    if (next < primary.size() ) {
                        String task = primary.get(next);
                        next++;
                        return task;
                    } else {
                        isPrimary = false;
                        next = 1;
                        return secondary.get(0);
                    }


                } else {
                    String task = secondary.get(next);
                    next++;
                    return task;
                }
            }
        };


    }


}
