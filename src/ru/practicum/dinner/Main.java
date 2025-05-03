package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command.trim()) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    System.out.println("На этом моя миссия подходит к концу.");
                    return;
                default:
                    System.out.println("Команда не распознана. Попробуйте снова.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine().trim();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine().trim();

        dc.addNewDish(dishType, dishName);// добавьте новое блюдо
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos;
        while (true) {
            if (scanner.hasNextInt()) {
                numberOfCombos = scanner.nextInt();
                if (numberOfCombos < 0){
                    System.out.println("Количество наборов не может быть отрицательным.");
                } else if (numberOfCombos == 0){
                    System.out.println("Путсть будет хотя бы 1 набор.");
                } else {
                    break;
                }
            } else {
                System.out.println(scanner.next() + " не является числом.");
            }
            System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        }
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода " +
                "введите пустую строку.");
        String nextItem = scanner.nextLine();
        ArrayList<String> types = new ArrayList<>();

        //реализуйте ввод типов блюд
        while (!nextItem.isEmpty()) {
            if (dc.contains(nextItem.trim())){
                types.add(nextItem.trim());
            } else {
                System.out.println("Такого типа блюд нет в списке, попробуйте снова:");
            }
            nextItem = scanner.nextLine();
        }

        // сгенерируйте комбинации блюд и выведите на экран
        for (int i = 0; i < numberOfCombos; i++) {
            ArrayList<String> combo = dc.generateDishCombo(types);

            System.out.print(i);
            for (String dish : combo){
                System.out.print(" - " + dish);
            }
            System.out.println();
        }
        //Я решил, что раз
        //"Важное условие: весь код, который взаимодействует с пользователем, должен находиться в классе Main.".
        //То все выводы тоже должны быть внутри main. Поэтому генерация блюда останется внутри отведённого класса
        //но вывод получившейся комбинации обязан быть тут
    }
}
