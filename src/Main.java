import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws IOException, MyExeption {
        String a = enterNumbers();
        System.out.println("Output:" + " " + '\n' + a);
    }

    public static String enterNumbers() throws IOException, MyExeption {

        System.out.println("Input: ");


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String enterLine = reader.readLine();

        return String.valueOf(calculateArabNumbers(enterLine));


    }

    public static Integer calculateArabNumbers(String enterDataForCalculate) throws MyExeption {
        int result = 0;

        if (enterDataForCalculate == null || enterDataForCalculate.isEmpty() || enterDataForCalculate.length() == 1)
            throw new MyExeption(" строка не является математической операцией");


        String newDataForCalculate = enterDataForCalculate.replaceAll(" ", "");

        for (int i = 0; i < newDataForCalculate.length(); i++) {
            if (newDataForCalculate.charAt(i) == '+') {
                result = metodMetod(enterDataForCalculate).get(0) + metodMetod(enterDataForCalculate).get(1);

            } else if (newDataForCalculate.charAt(i) == '-') {
                result = metodMetod(enterDataForCalculate).get(0) - metodMetod(enterDataForCalculate).get(1);
            } else if (newDataForCalculate.charAt(i) == '*') {
                result = metodMetod(enterDataForCalculate).get(0) * metodMetod(enterDataForCalculate).get(1);
            } else if (newDataForCalculate.charAt(i) == '/') {
                result = metodMetod(enterDataForCalculate).get(0) / metodMetod(enterDataForCalculate).get(1);
            }
        }
        return result;
    }

    public static ArrayList<Integer> metodMetod(String s) throws MyExeption {
        String[] str = s.split(" ");
        if (str.length > 3) {
            throw new MyExeption(" формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else {
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[2]);
            if (x > 10 || y > 10) {
                throw new MyExeption("Запрещенно воводить значения больше 10!");
            }
            ArrayList<Integer> list = new ArrayList<>();
            list.add(x);
            list.add(y);
            return list;
        }
    }


}