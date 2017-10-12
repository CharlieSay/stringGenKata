import java.util.ArrayList;
import java.util.List;

public class stringGen {

    public int Add(String numbers){

        String[] parts = numbers.split("[;-|\\.\n/,*%]");
        List<Integer> negatives = new ArrayList<Integer>();
        int sum = 0;
        for (int i= 0; (i < parts.length); i++){
            //new lines other crazy stuff
            if ((!"".equals(parts[i]))) {
                if (Integer.parseInt(parts[i])<0){
                    negatives.add(Integer.parseInt(parts[i]));
                }else if(Integer.parseInt(parts[i])>=1000){}
                else{ sum += Integer.parseInt(parts[i]);}
            }
        }
        if (negatives.size() > 0) {
            throw new IllegalArgumentException("negatives not allowed: " +negatives.toString());
        }
        return sum;
    }
}