import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxSwap {
    public static int maximumSwap(int num){
        List<Integer> list = new ArrayList<>();
        int temp = num;
        while (temp > 0){
            int a = temp%10;
            list.add(a);
            temp = temp/10;
        }
        Collections.reverse(list);

        int max = num;

        int i = 0;
        int j = 1;

        while (i < list.size()-1){
            int a = list.get(i);
            list.set(i, list.get(j));
            list.set(j, a);
            int formedNumber = getNumber(list);
            if (formedNumber > max){
                max = formedNumber;
            }
            list.set(j, list.get(i));
            list.set(i, a);
            j++;
            if (j == list.size()){
                i++;
                j = i+1;
            }
        }

        return max;
    }

    public static int getNumber(List<Integer> list){
        int a = list.get(0);
        int i = 1;
        while (i<list.size()){
            a = (a*10) + list.get(i);
            i++;
        }
        return a;
    }
    public static void main(String[] args) {
        System.out.println(maximumSwap(9973));
    }
}
