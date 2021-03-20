package lesson3;
import java.util.Scanner;
import java.util.Random;
//Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число.
// При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем загаданное, или меньше.
// После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
public class lesson3 {
    public static void main(String[] args) {
      //game();
        game2();
    }
    static void game() {
        System.out.println("Сыграем в игру, дружок!");
            int k = 3;
            Random rand = new Random();
            int p = rand.nextInt(9);
            while (k > 0) {
                System.out.println("У вас есть " + k + " попытки(ка)");
                k--;
                Scanner alex = new Scanner(System.in);
                System.out.print("Ваше число: ");
                int x = alex.nextInt();
                if ((x>9)||(x<0)) {
                    System.out.println("Соблюдай условие. Штраф 1 попытка");
                    continue; }

                if (x == p) {
                    System.out.println("Вы победили!");
                    break;
                }
                if (k==0) {
                    System.out.println("Вы проиграли!");
                }
                    else if (x > p) {
                    System.out.println("Попробуй меньше");

                } else {
                    System.out.println("Попробуй больше");
                }


            }
            System.out.println("Сыграть еще раз? (1 - Да : 0 - Нет)");
        Scanner leha = new Scanner(System.in);
        int s = leha.nextInt();
         switch (s) {
                case 1:
                    game();
                    break;
                case 0:
                    System.out.println("Спасибо за игру!");
                    break;
                default:
            }


        }


    static void game2() {

            String[] arr = {"apple", "orange", "lemon", "banana", "apricot",
                    "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
                    "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                    "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin",
                    "potato"};
            String slovo = random(arr);
            String lockedSlovo = lockedWord(slovo);
            System.out.println("Введите слово");

           Scanner Borua = new Scanner(System.in);

            while (true) {
                String Word = Borua.nextLine();
                Word = lockedWord(Word);
                if (lockedSlovo.equals(Word)) {
                    System.out.println("Ты победил!: " + slovo);
                    break;
                } else {
                    String secret = "";
                    for (int i = 0; i < lockedSlovo.length() - 1; i++) {
                        if (lockedSlovo.charAt(i) == Word.charAt(i))
                            secret += lockedSlovo.charAt(i);
                        else secret += "#";
                    }
                    System.out.println(secret);
                    System.out.println("Неверно. Повтори попытку.");
                }
            }

        }

        static String random(String[] s) {
            Random r = new Random();
            return s[r.nextInt(s.length - 1)];
        }

        static String lockedWord(String s) {
            String mask = "###############";
            for (int i = s.length() - 1; i < mask.length() - 1; i++) {
                s += mask.charAt(i);
            }
            return s;
        }
    }



