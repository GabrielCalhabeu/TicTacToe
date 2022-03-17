package _utility;

import java.util.Scanner;

//Simple utility i made for myself, it may or may not be worse, but i think its practical :^)
public class scanner {

    public static int scanNum(String text){

        int num = 0;
        System.out.print(text);
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();

        return num;
    }

    public static int scanRange(String text, int menor, int maior){

        int num;
        do {
            System.out.print(text);
            Scanner sc = new Scanner(System.in);
            num = sc.nextInt();
            if(num < menor || num > maior) {
                System.out.println("Type a valid input!\n");
            }
        }while(num < menor || num > maior);
        return num;
    }

    public static String scanStr(String text){

        String str;
        System.out.print(text);
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();

        return str;
    }

    public static float scanFlo(String text){

        float flo = 0;
        System.out.print(text);
        Scanner sc = new Scanner(System.in);
        flo = sc.nextFloat();

        return flo;
    }

    public static double scanPosD(String text){

        double posdouble = 0;
        do {
            System.out.print(text);
            Scanner sc = new Scanner(System.in);
            posdouble = sc.nextDouble();
            if(posdouble < 0) {
                System.out.println("Digite um valor positivo!\n");
            }
        }
        while(posdouble < 0);
        return posdouble;
    }

    public static int scanPos(String text){

        int posint = 0;
        do {
            System.out.print(text);
            Scanner sc = new Scanner(System.in);
            posint = sc.nextInt();
            if(posint < 0) {
                System.out.println("Digite um valor positivo!\n");
            }

        }
        while(posint < 0);
        return posint;
    }

}



