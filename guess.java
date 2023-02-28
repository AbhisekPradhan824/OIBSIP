import java.util.Scanner;

public class guess {

    public static void
    guess_the_number()
    {
        Scanner obj = new Scanner(System.in);

        int num = 1 + (int)(100 * Math.random());

        int N = 5;

        int i;
        int guess_num;

        System.out.println("Choose a Number between 1 to 100 within the trail limit of 5 only");

        for (i = 0; i < N; i++) {

            System.out.println("Guess the number:");

            guess_num = obj.nextInt();

            if (num == guess_num) {
                System.out.println("Congratulations!!!");
                break;
            }
            else if (num > guess_num && i != N - 1) {
                System.out.println("Hint: The number is greater than your guess number " + guess_num);
            }
            else if (num < guess_num && i != N - 1) {
                System.out.println("Hint: The number is less than your guess number" + guess_num);
            }
        }

        if (i == N) {
            System.out.println("...You are failed... out of trails... try again later...");

            System.out.println("The number is:... " + num);
            System.out.println("Your Score is 00....Retry the game ...");
        }
        else if (i == N-1)
        {
            System.out.println("Good!!!...Your Score is 02");
        }
        else if (i == N-2)
        {
            System.out.println("Very Good!!!...Your Score is 04");
        }
        else if (i == N-3)
        {
            System.out.println("Amazing!!!...Your Score is 06");
        }
        else if (i == N-4)
        {
            System.out.println("Awesome!!!...Your Score is 08");
        }
        else if (i == 0)
        {
            System.out.println("Execellent!!!...Your Score is 10");
        }
    }

    public static void main(String []args)
    {
        guess_the_number();
    }
}
