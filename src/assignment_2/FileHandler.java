/*

Assignment 1 - Program Design & Construction 2022

Coded by Mark Alexander
ID: 20112145

 */
package assignment_2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public final class FileHandler {

    private final PlayerService ps = new PlayerService("", 0, 0);
    private HashMap<String, Player> users;
    private String fileName;

    public FileHandler(String s) {
        this.fileName = s;
        this.users = new HashMap();
        this.getFile(fileName);
    }

    public HashMap<String, Player> getUsers() {
        return users;
    }

    public void setUsers(HashMap<String, Player> users) {
        this.users = users;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    //A HashMap to make every user unique
    public HashMap<String, Player> getFile(String fn) {
        FileInputStream fin;
        try {
            fin = new FileInputStream(fn);
            Scanner fileScanner = new Scanner(fin);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                StringTokenizer st = new StringTokenizer(line);
                Player player = ps.createPlayer(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                this.getUsers().put(player.getUsername(), player);
            }
            fin.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    //Prints to the file with the updated player records.
    public void updateScore(Player player) {
        System.out.println(player.getUsername() + ", your score is: " + player.getCurrentScore());
        this.getUsers().put(player.getUsername(), player);
        try {
            FileOutputStream fOut = new FileOutputStream(this.getFileName());
            try (PrintWriter pw = new PrintWriter(fOut)) {
                this.getUsers().values().forEach(p -> {
                    pw.println(p.getUsername() + " " + p.getCurrentScore() + " " + p.getHighScore());
                });
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    //Checks if user exisits, and if they dont creates a new user.
    public Player checkUser(String un) { 
        Player player;
        if (this.getUsers().containsKey(un)) {
            player = this.getUsers().get(un);
            System.out.println("--------------------------------------");
            System.out.println("★ Your highscore: " + player.getHighScore() + " points");
            System.out.println("★ Your previous score: " + player.getCurrentScore() + " points");
            System.out.println("--------------------------------------");
            player.setCurrentScore(0);
        } else {
            player = ps.createPlayer(un, 0, 0);
            this.getUsers().put(un, player);
        }
        return player;
    }

}
