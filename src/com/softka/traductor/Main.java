package com.softka.traductor;

import java.util.Scanner;

class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in), sc2 = new Scanner(System.in);

        Files file = new Files();
        file.Create("resources/Traductor.txt");

        System.out.println("Welcome, what do you want do?");
        System.out.println("1. Add a new word");
        System.out.println("2. See the whole dictionary");
        System.out.println("3. Consult a word");
        System.out.println("4. Exit");
        System.out.print("Your option is: ");

        int option = sc.nextInt();
        String word,translation;

        switch(option) {
            case 1:
                System.out.println("Please enter the word in Spanish");
                word = sc2.nextLine();
                System.out.println("Enter the traslation");
                translation = sc2.nextLine();

                String text = word + ": " + translation;
                file.Write("resources/Traductor.txt", text);
                break;

            case 2:
                file.Read("resources/Traductor.txt");
                break;

            case 3:
                System.out.println("Please enter the word for which you want to know it´s translation");
                word = sc2.nextLine();
                translation = file.Find(word, "resources/Traductor.txt");

                if (translation.equals(""))
                    System.out.println("The word is not in the dictionary");
                else
                    System.out.println(word + ": " + translation);
                break;

            case 4:
                System.out.println("Good Bye");
                break;

            default:
                System.out.println("Incorrect option");
        }
    }
}
