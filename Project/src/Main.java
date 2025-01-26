import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOfGuesses = 0;
        ArrayList<Integer> usedTurns = new ArrayList<>();
        int[] loc = new int[3];
        boolean doesItLive = true;
        String result;
        SimpleDotCome simpleDotCome = new SimpleDotCome();
        Random random = new Random();
        int random1 = random.nextInt(11);
        switch (random1){
            case 0,1,2,3,4,5,6,7,8  -> loc = new int[]{random1, random1 + 1, random1 + 2};
            case 9 -> loc = new int[]{random1 - 1, random1, random1 + 1};
            case 10 -> loc = new int[]{random1 - 2, random1 - 1, random1};
        }
        simpleDotCome.setLocationCells(loc);
        while (doesItLive){
            System.out.print("Введите число: ");
            int gues = in.nextInt();
            if (!(0<=gues && gues<=10)){
                System.out.println("Ты ввел недействительное число (больше рамок поля)");
                continue;
            }
            if (usedTurns.contains(gues)){
                System.out.println("Ты уже вводил это число");
                continue;
            }
            usedTurns.add(gues);
            numOfGuesses++;
            result = simpleDotCome.checkYourself(gues);
            System.out.println(result);

            if (result.equals("Потопил")){
                System.out.println("Ты справился за " + numOfGuesses + " ходов!");
                doesItLive = false;
            }
        }
    }
}