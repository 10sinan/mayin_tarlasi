package java_exercise.Mayin_tarlasi;

import java.util.Random;
import java.util.Scanner;

public class Mayin_tarlasi {
    public int[][] map;
    public int[][] board;
    public boolean oyun = true;
    public int rowNumber, colNumber, size;// size, kaç adet -1 gelecegının sayaci,row=satır,col=sutun
    Random rand = new Random();
    Scanner input = new Scanner(System.in);

    public Mayin_tarlasi(int rowNumber, int colNumber) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.size = rowNumber * colNumber;
        map = new int[rowNumber][colNumber];
        board = new int[rowNumber][colNumber];
    }

    public void run() {
        int row, col;
        prepareGame();
        print(map);
        System.out.println("..oyun basladi..");
        while (oyun) {
            print(board);
            System.out.println("satir ve sütun numaralarını gir (sirayla) ");
            row = input.nextInt();
            col = input.nextInt();
            if (map[row][col] != -1) {
                check(row, col);
            } else {
                oyun = false;
                System.out.println("..GAME OVER..!");
                System.out.println("---------------");
                print(map);
                System.out.println("---------------");

            }
        }
    }

    public void prepareGame() {
        int randRow, randCol, sayac = 0;

        while (sayac < (size / 4)) {
            randRow = rand.nextInt(rowNumber);
            randCol = rand.nextInt(colNumber);// rasgele bır sekiilde -1 ata
            if (map[randRow][randCol] != -1) {
                map[randRow][randCol] = -1;
                sayac++;
            }
        }
    }

    public void check(int r, int c) { // made by Chatgpt
        int count = 0;

        // Üst komşu
        if (r > 0 && map[r - 1][c] == -1) {
            count++;
        }
        // Alt komşu
        if (r < rowNumber - 1 && map[r + 1][c] == -1) {
            count++;
        }
        // Sol komşu
        if (c > 0 && map[r][c - 1] == -1) {
            count++;
        }
        // Sağ komşu
        if (c < colNumber - 1 && map[r][c + 1] == -1) {
            count++;
        }
        board[r][c] = count; // Etrafındaki mayın sayısını kaydet
    }

    public void print(int[][] dizi) {
        for (int i = 0; i < dizi.length; i++) {
            for (int j = 0; j < dizi[0].length; j++) {
                if (dizi[i][j] >= 0) {
                    System.out.print(" ");// estetiklik için
                }
                System.out.print(dizi[i][j] + " ");
            }
            System.out.println();
        }
    }
}
