import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Goods {

    private String path;
    private List<String> listGoods = new ArrayList<>();

    public Goods(String path) {
        this.path = path;
        readGoods(this.path);
    }

    public void readGoods(String path) {

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                listGoods.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printGoods() {

        for (int i = 0; i < listGoods.size(); i++) {
            int num = i + 1;
            System.out.println(num + ". " + listGoods.get(i));
        }
    }

    public int size(){
        return listGoods.size();
    }

    public String get(int number){
        return listGoods.get(Math.abs(number)-1);
    }

}
