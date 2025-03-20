package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    // Константи для генерації випадкових чисел у заданому діапазоні
    private static final int MIN_VALUE = -100; // Мінімальне значення
    private static final int MAX_VALUE = 100;  // Максимальне значення

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Введення розмірів матриці
        System.out.print("Введіть кількість рядків матриці (макс. 20): ");
        int rows = scanner.nextInt();
        System.out.print("Введіть кількість стовпців матриці (макс. 20): ");
        int cols = scanner.nextInt();

        // Перевірка на допустимий розмір
        if (rows > 20 || cols > 20) {
            System.out.println("Розмір матриці не може перевищувати 20x20!");
            return;
        }

        // Вибір способу заповнення матриці
        System.out.print("Виберіть спосіб заповнення (1 - вручну, 2 - випадково): ");
        int choice = scanner.nextInt();

        int[][] matrix = new int[rows][cols]; // Ініціалізація матриці

        if (choice == 1) {
            fillMatrixManually(matrix, scanner); // Заповнення вручну
        } else if (choice == 2) {
            fillMatrixRandomly(matrix); // Заповнення випадковими числами
        } else {
            System.out.println("Невірний вибір! Виберіть 1 або 2.");
            return;
        }

        // Виведення матриці на екран
        System.out.println("Матриця:");
        printMatrix(matrix);

        // Обчислення характеристик матриці
        int min = findMin(matrix); // Мінімальний елемент
        int max = findMax(matrix); // Максимальний елемент
        double avg = calculateArithmeticMean(matrix); // Середнє арифметичне
        double geoAvg = calculateGeometricMean(matrix); // Середнє геометричне

        // Виведення результатів
        System.out.println("Мінімальний елемент: " + min);
        System.out.println("Максимальний елемент: " + max);
        System.out.println("Середнє арифметичне: " + avg);
        System.out.println("Середнє геометричне: " + geoAvg);
    }

    // Заповнення матриці вручну
    public static void fillMatrixManually(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("Введіть елемент матриці [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    // Заповнення матриці випадковими числами
    public static void fillMatrixRandomly(int[][] matrix) {
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
            }
        }
    }

    // Виведення матриці на екран
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }

    // Пошук мінімального елемента
    public static int findMin(int[][] matrix) {
        int min = matrix[0][0];
        for (int[] row : matrix) {
            for (int value : row) {
                if (value < min) {
                    min = value;
                }
            }
        }
        return min;
    }

    // Пошук максимального елемента
    public static int findMax(int[][] matrix) {
        int max = matrix[0][0];
        for (int[] row : matrix) {
            for (int value : row) {
                if (value > max) {
                    max = value;
                }
            }
        }
        return max;
    }

    // Обчислення середнього арифметичного
    public static double calculateArithmeticMean(int[][] matrix) {
        int sum = 0, count = 0;
        for (int[] row : matrix) {
            for (int value : row) {
                sum += value;
                count++;
            }
        }
        return (double) sum / count;
    }

    // Обчислення середнього геометричного
    public static double calculateGeometricMean(int[][] matrix) {
        double product = 1;
        int count = 0;
        boolean hasPositive = false;
        
        for (int[] row : matrix) {
            for (int value : row) {
                if (value > 0) { // Беремо лише додатні значення
                    product *= value;
                    count++;
                    hasPositive = true;
                }
            }
        }
        
        return hasPositive ? Math.pow(product, 1.0 / count) : 0;
    }
}