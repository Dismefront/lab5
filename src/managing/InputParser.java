package managing;

import stored.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputParser {

    public static Worker getWorkerFromInput() {
        String name;
        Coordinates coords;
        Long salary;
        LocalDate date;
        int pweight;
        Color eyeC;
        Color hairC;
        Country pcountry;
        Person person;
        Position pos;
        Status st;

        Scanner in = Vars.globalScanner;

        System.out.println("Введите имя:");
        name = in.nextLine();
        while (name.isBlank()) {
            System.out.println("Неверное имя. Повторите ввод");
            name = in.nextLine();
        }

        System.out.println("Введите координаты x y");
        String[] temp = in.nextLine().split(" ");
        while (true) {
            try {
                float x = Float.parseFloat(temp[0]);
                int y = Integer.parseInt(temp[1]);
                coords = new Coordinates(x, y);
                if (!coords.isValid())
                    throw new NumberFormatException();
                break;
            }
            catch (NumberFormatException e) {
                System.out.println("Неверный ввод. Повторите");
                temp = in.nextLine().split(" ");
            }
            catch (NoSuchElementException e) {
                System.out.println("Неверный ввод. Повторите");
                in = new Scanner(System.in);
            }
        }

        System.out.println("Введите зарплату:");
        while (true) {
            try {
                salary = Long.parseLong(in.nextLine());
                break;
            }
            catch (NumberFormatException e) {
                System.out.println("Неверный ввод. Повторите");
            }
            catch (NoSuchElementException e) {
                System.out.println("Неверный ввод. Повторите");
                in = new Scanner(System.in);
            }
        }

        System.out.println("Введите дату");
        while (true) {
            try {
                date = LocalDate.parse(in.nextLine());
                break;
            }
            catch (DateTimeParseException e) {
                System.out.println("Неверный ввод. Повторите");
            }
            catch (NoSuchElementException e) {
                System.out.println("Неверный ввод. Повторите");
                in = new Scanner(System.in);
            }
        }

        System.out.println("Введите позицию");
        System.out.println(Position.CLEANER);
        while (true) {
            try {
                String temp1 = in.nextLine();
                if (temp1.isBlank())
                    pos = null;
                else
                    pos = Position.valueOf(temp1);
                break;
            }
            catch (IllegalArgumentException e) {
                System.out.println("Неверный ввод. Повторите");
            }
            catch (NoSuchElementException e) {
                System.out.println("Неверный ввод. Повторите");
                in = new Scanner(System.in);
            }
        }

        System.out.println("Введите статус");
        System.out.println(Status.FIRED);
        while (true) {
            try {
                String temp1 = in.nextLine();
                if (temp1.isBlank())
                    st = null;
                else
                    st = Status.valueOf(temp1);
                break;
            }
            catch (IllegalArgumentException e) {
                System.out.println("Неверный ввод. Повторите");
            }
            catch (NoSuchElementException e) {
                System.out.println("Неверный ввод. Повторите");
                in = new Scanner(System.in);
            }
        }

        System.out.println("Введите вес человека:");
        while (true) {
            try {
                pweight = Integer.parseInt(in.nextLine());
                if (pweight <= 0)
                    throw new NumberFormatException();
                break;
            }
            catch (NumberFormatException e) {
                System.out.println("Неверный ввод. Повторите");
            }
            catch (NoSuchElementException e) {
                System.out.println("Неверный ввод. Повторите");
                in = new Scanner(System.in);
            }
        }

        System.out.println("Введите цвет глаз человека");
        System.out.println(Color.BLACK);
        while (true) {
            try {
                String temp1 = in.nextLine();
                if (temp1.isBlank())
                    eyeC = null;
                else
                    eyeC = Color.valueOf(temp1);
                break;
            }
            catch (IllegalArgumentException e) {
                System.out.println("Неверный ввод. Повторите");
            }
            catch (NoSuchElementException e) {
                System.out.println("Неверный ввод. Повторите");
                in = new Scanner(System.in);
            }
        }

        System.out.println("Введите цвет волос человека");
        System.out.println(Color.BLACK);
        while (true) {
            try {
                String temp1 = in.nextLine();
                if (temp1.isBlank())
                    hairC = null;
                else
                    hairC = Color.valueOf(temp1);
                break;
            }
            catch (IllegalArgumentException e) {
                System.out.println("Неверный ввод. Повторите");
            }
            catch (NoSuchElementException e) {
                System.out.println("Неверный ввод. Повторите");
                in = new Scanner(System.in);
            }
        }

        System.out.println("Введите национальность человека");
        System.out.println(Country.ITALY);
        while (true) {
            try {
                String temp1 = in.nextLine();
                if (temp1.isBlank())
                    pcountry = null;
                else
                    pcountry = Country.valueOf(temp1);
                break;
            }
            catch (IllegalArgumentException e) {
                System.out.println("Неверный ввод. Повторите");
            }
            catch (NoSuchElementException e) {
                System.out.println("Неверный ввод. Повторите");
                in = new Scanner(System.in);
            }
        }
        person = new Person(pweight, eyeC, hairC, pcountry);
        Worker w = new Worker(name, coords,
                salary, date, pos, st, person);
        return w;
    }

}
