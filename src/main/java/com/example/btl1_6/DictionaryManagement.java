package com.example.btl1_6;

import javafx.scene.effect.ImageInput;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DictionaryManagement  {
    private final Dictionary dictionary_management = new Dictionary();


    DictionaryManagement() {
    }
    public Dictionary getDictionary_management() {
        return dictionary_management;
    }

    public void insertFromCommandLine(String eng_word, String viet_word) {
        Word new_word = new Word(eng_word,viet_word);
        if(checkWord(eng_word)) {
            dictionary_management.addWord(new_word);
        }

    }

    public boolean checkWord(String eng_word) {
        for(int i = 0; i < dictionary_management.getDictionary().size(); i++) {
            if (eng_word.equalsIgnoreCase(dictionary_management.getDictionary().get(i).getWord_target())) {
                return false;
            }
        }
        return true;


    }

    public void insertfromFile() throws IOException{
        try {
            Path path = Path.of("C:\\Users\\BENH VIEN CONG NGHE\\OneDrive\\Desktop\\BTL_oops_team6\\BTL1_6\\src\\dic.txt");
            List<String> li = Files.readAllLines(path);
            for (int i = 1; i < li.size(); i++) {
                String[] array = li.get(i).split("-");
                Word ten = new Word(array[0], array[1]);
                this.dictionary_management.addWord(ten);
            }
            System.out.println("Insert thanh cong!");
        } catch (Exception e) {
            System.out.println("khong the insert do loi");
        }
    }

    public void dictionaryLookup() {
        System.out.println("Type the word you want to find: ");
        Scanner scanner = new Scanner(System.in);
        String find_word = scanner.nextLine();
        for(Word search : dictionary_management.getDictionary()) {
            if (find_word.equalsIgnoreCase(search.getWord_target())) {
                System.out.println(search.getWord_target() + " = " + search.getWord_explain());
                return;
            }
        }
        System.out.println("Nothing found");
    }

    public void deleteWord() {
        System.out.println("Nhap tu muon xoa: ");
        Scanner scanner = new Scanner(System.in);
        String find_word = scanner.nextLine();

        for(int i = 0; i < dictionary_management.getDictionary().size(); i++) {
            if (find_word.equalsIgnoreCase(dictionary_management.getDictionary().get(i).getWord_target())) {
                dictionary_management.deleteWord(i);
                return;
            }
            i++;
        }
        System.out.println("Found no word");
    }

    public void delelefx(String word) {
        for(int i = 0; i < dictionary_management.getDictionary().size(); i++) {
            if (word.equalsIgnoreCase(dictionary_management.getDictionary().get(i).getWord_target())) {
                dictionary_management.deleteWord(i);
            }
        }
        /*int i = checkWord(dictionary_management, 0, dictionary_management.getDictionary().size() - 1, word);
        if(i != -1) {
            dictionary_management.deleteWord(i);
            return;
        } */

    }

    public void editWord() {
        System.out.println("Type the word you want to edit: ");
        Scanner scanner = new Scanner(System.in);
        String edit_word = scanner.nextLine();
        for(Word search : dictionary_management.getDictionary()) {
            if (edit_word.equalsIgnoreCase(search.getWord_target())) {

            }
        }
    }

    public void editfx(String a, String b){
        for(Word search : dictionary_management.getDictionary()) {
            if (a.equalsIgnoreCase(search.getWord_target())) {
                search.setWord_explain(b);
            }
        }
    }


    public void dictionaryExportToFile() throws IOException {
            PrintWriter a = new PrintWriter(new File("src\\dic.txt"));
            for (int i = 0; i < dictionary_management.getDictionary().size(); i++) {
                a.write( this.dictionary_management.getDictionary().get(i).getWord_target() + "-" + this.dictionary_management.getDictionary().get(i).getWord_explain() + "\n");
            }
            a.flush();
            a.close();
            System.out.println("Export thanh cong!");
    }
}
