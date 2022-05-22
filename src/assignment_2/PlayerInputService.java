/*

Assignment 1 - Program Design & Construction 2022

Coded by Mark Alexander
ID: 20112145

 */
package assignment_2;

import java.util.Scanner;

public class PlayerInputService implements IPlayerInputService {

    private static final Scanner scan = new Scanner(System.in);

    @Override
    public String playerInput() {
        String s = scan.nextLine();
        return s;
    }

}
