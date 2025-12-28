import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        // รับประเภทตัวละคร
        Scanner input = new Scanner(System.in);
        System.out.println("please Select Character");
        System.out.println("1.Fighter");
        System.out.println("2.Tank");
        System.out.println("3.Assassin");
        System.out.println("4.Carry");
        System.out.println("5.Mage");
        int character1=input.nextInt();
        int character2=input.nextInt();

        // ตรวจสอบประเภทตัวละคร 1
        if (character1 == 1) {
            fighter player1 = new fighter(); 
        }
        else if (character1 == 2) {
            tank player1 = new tank();
        }
        else if (character1 == 3) {
            assassin player1 = new assassin();
        }
        else if (character1 == 4) {
            carry player1 = new carry();
        }
        else if (character1 == 5) {
            mage player1 = new mage();
        }
        
        // ตรวจสอบประเภทตัวละคร 2
        if (character2 == 1) {
            fighter player2 = new fighter();
        }
        else if (character2 == 2) {
            tank player2 = new tank();
        }
        else if (character2 == 3) {
            assassin player2 = new assassin();
        }
        else if (character2 == 4) {
            carry player2 = new carry();
        }
        else if (character2 == 5) {
            mage player2 = new mage();
        }

        // ตัวแปรหาผู้ชนะ
        boolean winplayer1=false,winplayer2=false;
        while (player1.hp > 0 && player2.hp > 0) {
            IO.println("Player1 Speed: "+player1.speed);
            IO.println("Player2 Speed: "+player2.speed);
            String play1 = input.nextLine();
            String play2 = input.nextLine();
            if (play1.equals("A")) {
                int dam = player1.atk - (player2.def / player1.speed);
                if (dam < 0) dam=1;
                player2.hp = player2.hp - dam;
            }
            if (play2.equals("A")) {
                int dam = player1.atk - (player2.def / player1.speed);
                if (dam < 0) dam=1;
                player1.hp = player1.hp - dam;
            }
            if (play1.equals("D") && play2.equals("D")) {
                IO.println("HP And ATK player 1: " + "HP : " + player1.hp);
                IO.println("HP And ATK player 2: " + "HP : " + player2.hp);
                continue;
            }
            if (play1.equals("D")) {
                int dam = player2.atk - (player1.def / player2.speed);
                if (dam < 0) dam=1;
                player1.hp = player1.hp - dam;
            }
            if (play2.equals("D")) {
                int dam = player1.atk - (player2.def / player1.speed);
                if (dam < 0) dam=1;
                player1.hp = player1.hp - dam;
            }
            IO.println("HP And ATK player 1: " + "HP : " + player1.hp);
            IO.println("HP And ATK player 2: " + "HP : " + player2.hp);
            if (player1.hp > player2.hp) {
                winplayer1=true;
            }
            else if  (player2.hp > player1.hp) {
                winplayer2=true;
            }
        }
        if  (winplayer1) {
            System.out.println("Player 1 wins!");
        }
        else if (winplayer2) {
            System.out.println("Player 2 wins!");
        }
    }
}