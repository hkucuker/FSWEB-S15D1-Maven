package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList= new ArrayList<>();

    public static void startGrocery(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Lütfen; Programı sonlandırmak için '0', Listeye ürün eklemek için '1', Listeden ürün çıkarmak için '2' giriniz! :");
            int sayi = scanner.nextInt();
            scanner.nextLine();
            if (sayi == 0) {
                System.out.println("0 girildi, program sonlandırılıyor.");
                printSorted();
                break;
            }else if(sayi == 1){
                System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                String urunler= scanner.nextLine();
                addItems(urunler);
            }else if(sayi == 2){
                System.out.println("Cıkarılmasını istediğiniz elemanları giriniz.");
                String urunler= scanner.nextLine();
                removeItems(urunler);
            }else{
                System.out.println("Lütfen '0'-'1'-'2' değerinden birini giriniz.");
                //System.out.println("Lütfen sonlandırmak için '0' giriniz.");
                //System.out.println("Lütfen listeye ürün eklemek için '1' giriniz.");
                //System.out.println("Lütfen listeden ürün çıkarmak için '2' giriniz.");
            }
        }
        scanner.close();
    }

    public static void addItems(String input){
        String[] items = input.split(",");
        for(String item : items){
            String trimmedItem = item.trim();
            if(!checkItemIsInList(trimmedItem)){
                groceryList.add(trimmedItem);
            }else{
                System.out.println('"'+trimmedItem+'"'+ " zaten listede var.");
            }
            printSorted();
        }
    }

    public static void removeItems(String input){
        String[] items = input.split(",");
        for(String item : items){
            String trimmedItem = item.trim();
            if(checkItemIsInList(trimmedItem)){
                groceryList.remove(trimmedItem);
            }else{
                System.out.println('"'+trimmedItem+'"'+ " zaten listede yok.");
            }
            printSorted();
        }
    }

    public static boolean checkItemIsInList(String product){
        return groceryList.contains(product);
    }

    public static void printSorted(){
        Collections.sort(groceryList);
        System.out.println("Ürünlerimiz :" + groceryList);
    }
}
