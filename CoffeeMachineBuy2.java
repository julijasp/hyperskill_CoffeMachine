package com.company.CoffeeMachine;

import java.util.Scanner;

class CoffeeMachineBuy2 {
    public static void main(String[] args) {

        int water = 400;
        int milk = 540;
        int coffeeBeans = 120;
        int balance = 550;
        int cups = 9;

        BuyCoffee buyCoffee = new BuyCoffee();
        buyCoffee.showMenu(water, milk, coffeeBeans, cups, balance);

    }

    public static class BuyCoffee {

        public static int finalBalance;
        public static int waterForEspresso = 250;
        public static int coffeeBeansForEspresso = 16;
        public static int waterForLatte = 350;
        public static int coffeeBeansForLatte = 20;
        public static int milkForLatte = 75;
        public static int waterForCappuccino = 200;
        public static int coffeeBeansForCappuccino = 12;
        public static int milkForCappuccino = 100;
        public static int espressoPrice = 4;
        public static int lattePrice = 7;
        public static int cappuccinoPrice = 6;
        public static String coffeeType;
        public static int remainingWater = 400;
        public static int remainingMilk = 540;
        public static int remainingCoffeeBeans = 120;
        public static int remainingCups = 9;
        public static int remainingBalance = 550;
        public static int addWater;
        public static int addCoffeeBeans;
        public static int addMilk;
        public static int addCups;
        public static int paidMoney;
        public static boolean buyCupOfCoffee = false;

        public static int showMenu(int water, int milk, int coffeeBeans, int cups, int balance) {

            String action;
            int choiceNo = 0;
            do {
                System.out.println();
                System.out.println("Write action (buy, fill, take, remaining, exit): ");
                Scanner scanner = new Scanner(System.in);
                action = scanner.nextLine();
                choiceNo++;

                switch (action) {
                    case "buy":
                        buyCoffee(water, milk, coffeeBeans, cups, balance, buyCupOfCoffee);
                        break;

                    case "fill":
                        fillCoffeeMachine(water, milk, coffeeBeans, cups, balance);
                        break;

                    case "take":
                        takeMoney(water, milk, coffeeBeans, cups, balance);
                        break;

                    case "remaining":
                          if (choiceNo == 1) {
                            printBalance(water, milk, coffeeBeans, cups, balance);
                        } if (choiceNo > 1){
                            printBalanceAfterPurchase(remainingWater, remainingMilk, remainingCoffeeBeans, remainingCups, remainingBalance);
                        }
                          break;

                    case "exit":
                        System.exit(0);
                }
            } while (!action.equals("exit"));
           return choiceNo;
        }

        public static String buyCoffee(int water, int milk, int coffeeBeans, int cups, int balance, boolean buyCupOfCoffee) {
            Scanner scanner = new Scanner(System.in);
            System.out.println();
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
            coffeeType = scanner.nextLine();

            switch (coffeeType) {
                case "1": {
                    checkResourcesEspresso(water,milk, coffeeBeans, cups, balance, buyCupOfCoffee);
                    break;
                }
                case "2": {
                    checkResourcesLatte(remainingWater, remainingMilk, remainingCoffeeBeans, remainingCups, remainingBalance , buyCupOfCoffee);
                  break;
                }
                case "3": {
                    checkResourcesCappuccino(remainingWater, remainingMilk, remainingCoffeeBeans, remainingCups, remainingBalance , buyCupOfCoffee);
                    break;
                }
                case "back": {
                    showMenu(water, milk, coffeeBeans, cups, balance);
                    break;
                }
            }
            return coffeeType;
        }

        public static void printBalance(int water, int milk, int coffeeBeans, int cups, int balance) {

            System.out.println();
            System.out.println("The coffee machine has:\n" +
                    water + " ml of water\n" +
                    milk + " ml of milk\n" +
                    coffeeBeans + " g of coffee beans\n" +
                    cups + " disposable cups\n" +
                    '$' + balance + " of money");
        }

        public static void fillCoffeeMachine(int water, int milk, int coffeeBeans, int cups, int balance) {
            System.out.println();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Write how many ml of water you want to add: ");
            addWater = scanner.nextInt();
            System.out.println("Write how many ml of milk you want to add: ");
            addMilk = scanner.nextInt();
            System.out.println("Write how many grams of coffee beans you want to add:");
            addCoffeeBeans = scanner.nextInt();
            System.out.println("Write how many disposable cups of coffee you want to add: ");
            addCups = scanner.nextInt();
            remainingWater = remainingWater + addWater;
            remainingMilk = remainingMilk + addMilk;
            remainingCoffeeBeans = remainingCoffeeBeans + addCoffeeBeans;
            remainingCups = remainingCups + addCups;
            remainingBalance = remainingBalance;
            return;

        }

        public static void takeMoney(int water, int milk, int coffeeBeans, int cups, int balance) {
            paidMoney = remainingBalance;
            System.out.println();
            System.out.println("I gave you $" + remainingBalance);
            remainingBalance = 0;
            remainingWater = remainingWater;
            remainingMilk = remainingMilk;
            remainingCups = remainingCups;
            remainingCoffeeBeans = remainingCoffeeBeans;
            return;
            }

        public static void checkResourcesEspresso(int water, int milk, int coffeeBeans, int cups, int balance,  boolean buyCupOfCoffee) {

            if (waterForEspresso <= remainingWater && coffeeBeansForEspresso <= remainingCoffeeBeans) {
                System.out.println("I have enough resources, making you a coffee!");
                buyCupOfCoffee = true;
                if (buyCupOfCoffee = true){
                    remainingWater = remainingWater - waterForEspresso;
                    remainingMilk = remainingMilk;
                    remainingCoffeeBeans = remainingCoffeeBeans - coffeeBeansForEspresso;
                    remainingCups --;
                    remainingBalance = remainingBalance + espressoPrice;
                }
            }
            else if (waterForEspresso > remainingWater) {
                System.out.println("Sorry, not enough water!");
                remainingWater = remainingWater;
                remainingMilk = remainingMilk;
                remainingCoffeeBeans = remainingCoffeeBeans;
                remainingCups = remainingCups;
                remainingBalance = remainingBalance;
            }
           else if (coffeeBeansForEspresso > remainingCoffeeBeans) {
                System.out.println("Sorry, not enough coffee beans!");
                remainingWater = remainingWater;
                remainingMilk = remainingMilk;
                remainingCoffeeBeans = remainingCoffeeBeans;
                remainingCups = remainingCups;
                remainingBalance = remainingBalance;
            }
        }

        public static void checkResourcesLatte(int water, int milk, int coffeeBeans, int cups, int balance,  boolean buyCupOfCoffee) {

            if (waterForLatte <= remainingWater && coffeeBeansForLatte <= remainingCoffeeBeans && milkForLatte <= remainingMilk) {
                System.out.println("I have enough resources, making you a coffee!");
                buyCupOfCoffee = true;

                if (buyCupOfCoffee = true) {

                    remainingWater = remainingWater - waterForLatte;
                    remainingMilk = remainingMilk - milkForLatte;
                    remainingCoffeeBeans = remainingCoffeeBeans - coffeeBeansForLatte;
                    remainingCups--;
                    remainingBalance = remainingBalance + lattePrice;
                    }

            } else if ( waterForLatte > remainingWater) {
                System.out.println("Sorry, not enough water!");
                remainingWater  = remainingWater;
                remainingMilk = remainingMilk;
                remainingCoffeeBeans = remainingCoffeeBeans;
                remainingCups = remainingCups;
                remainingBalance = remainingBalance;

            }
            else if (coffeeBeansForLatte > remainingWater) {
                System.out.println("Sorry, not enough coffee beans!");
                remainingWater  = remainingWater;
                remainingMilk = remainingMilk;
                remainingCoffeeBeans = remainingCoffeeBeans;
                remainingCups = remainingCups;
                remainingBalance = remainingBalance;
            }
           else if (milkForLatte > remainingMilk) {
                System.out.println("Sorry, not enough milk!");
                remainingWater  = remainingWater;
                remainingMilk = remainingMilk;
                remainingCoffeeBeans = remainingCoffeeBeans;
                remainingCups = remainingCups;
                remainingBalance = remainingBalance;
            }
        }

        public static void checkResourcesCappuccino(int water, int milk, int coffeeBeans, int cups, int balance,  boolean buyCupOfCoffee) {

            if (waterForCappuccino <= remainingWater && coffeeBeansForCappuccino <= remainingCoffeeBeans && milkForCappuccino <= remainingMilk) {
                System.out.println("I have enough resources, making you a coffee!");
                buyCupOfCoffee = true;
                if (buyCupOfCoffee =true){
                    remainingWater = remainingWater - waterForCappuccino;
                    remainingMilk = remainingMilk - milkForCappuccino;
                    remainingCoffeeBeans = remainingCoffeeBeans - coffeeBeansForCappuccino;
                    remainingCups--;
                    remainingBalance = remainingBalance + cappuccinoPrice;
                }
            }
            else if (waterForCappuccino > remainingWater) {
                System.out.println("Sorry, not enough water!");
                remainingWater  = remainingWater;
                remainingMilk = remainingMilk;
                remainingCoffeeBeans = remainingCoffeeBeans;
                remainingCups = remainingCups;
                remainingBalance = remainingBalance;
            }
            else if (coffeeBeansForCappuccino > remainingCoffeeBeans) {
                System.out.println("Sorry, not enough coffee beans!");
                remainingWater  = remainingWater;
                remainingMilk = remainingMilk;
                remainingCoffeeBeans = remainingCoffeeBeans;
                remainingCups = remainingCups;
                remainingBalance = remainingBalance;
            }
            else if (milkForCappuccino > remainingMilk) {
                System.out.println("Sorry, not enough milk!");
                remainingWater  = remainingWater;
                remainingMilk = remainingMilk;
                remainingCoffeeBeans = remainingCoffeeBeans;
                remainingCups = remainingCups;
                remainingBalance = remainingBalance;
            }
        }

        public static String printBalanceAfterPurchase(int remainingWater, int remainingMilk, int remainingCoffeeBeans, int remainingCups, int remainingBalance) {

            System.out.println();
            System.out.println("The coffee machine has:\n" +
                    remainingWater + " ml of water\n" +
                    remainingMilk  + " ml of milk\n" +
                    remainingCoffeeBeans + " g of coffee beans\n" +
                    (remainingCups) + " disposable cups\n" +
                    '$' + remainingBalance + " of money");
            return null;
        }
    }
}