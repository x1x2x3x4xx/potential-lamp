import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Converter converter = new Converter();
        String[] ations = {"+","-","*","/"};
        String[] regActions = {"\\+","-","/","\\*"};
        System.out.print("Input:");
        String exp = scn.nextLine();
        int actionIndex=-1;
        for (int i = 0; i< ations.length;i++)
        {
            if(exp.contains(ations[i]))
            {
                actionIndex = i;
                break;
            }
        }
        if (actionIndex==-1)
        {
            System.out.println("error");
            return;
        }
        String[] data = exp.split(regActions[actionIndex]);
        if(converter.isRoman(data[0]) == converter.isRoman(data[1]))
        {
            int a,b;
            boolean isRoman = converter.isRoman(data[0]);
            if (isRoman)
            {
                a = converter.romanToInt(data[0]);
                b = converter.romanToInt(data[1]);
            }
            else
            {
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }
            int result;
            switch (ations[actionIndex]){
                case "+":
                    result = a+b;
                    break;
                case "-":
                    result = a-b;
                    break;
                case "*":
                    result = a*b;
                    break;
                default:
                    result = a/b;
                    break;
            }
            if (isRoman) {
                System.out.println(converter.intToRoman(result));
            }
            else
            {
                System.out.println(result);
            }
        }
        else
        {
            System.out.println("используются одновременно разные системы счисления");
        }
    }
}