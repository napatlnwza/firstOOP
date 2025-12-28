import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        character player1 = null;
        character player2 = null;

        // รับประเภทตัวละคร
        Scanner input = new Scanner(System.in);
        System.out.println("please Select Character");
        System.out.println("1.Fighter");
        System.out.println("2.Tank");
        System.out.println("3.Assassin");
        System.out.println("4.Carry");
        System.out.println("5.Mage");
        System.out.print("Player 1 : ");
        int character1=input.nextInt();
        System.out.print("Player 2 : ");
        int character2=input.nextInt();

        // ตรวจสอบประเภทตัวละคร 1
        if (character1 == 1) {
            player1 = new fighter(); 
            System.out.println("P1 is Fighter!");
        }
        else if (character1 == 2) {
            player1 = new tank();
            System.out.println("P1 isTank!");
        }
        else if (character1 == 3) {
            player1 = new assassin();
            System.out.println("P1 is Assassin!");
        }
        else if (character1 == 4) {
            player1 = new carry();
            System.out.println("P1 is Carry!");
        }
        else if (character1 == 5) {
            player1 = new mage();
            System.out.println("P1 is Mage!");
        }
        
        // ตรวจสอบประเภทตัวละคร 2
        if (character2 == 1) {
            player2 = new fighter();
            System.out.println("P2 is Fighter!");
        }
        else if (character2 == 2) {
            player2 = new tank();
            System.out.println("P2 is Tank!");
        }
        else if (character2 == 3) {
            player2 = new assassin();
            System.out.println("P2 is Assassin!");
        }
        else if (character2 == 4) {
            player2 = new carry();
            System.out.println("P2 is Carry!");
        }
        else if (character2 == 5) {
            player2 = new mage();
            System.out.println("P2 is Mage!");
        }
        System.out.println("*********************************");
        System.out.println("A is Attack");
        System.out.println("D is Defend");
        System.out.println("*********************************");

        // ตัวแปรหาผู้ชนะ
        boolean winplayer1=false,winplayer2=false;


        // เริ่มเกม
        int i=0;
        while (player1.hp > 0 && player2.hp > 0) {
            if (i>0) {
                int rang=(int)(Math.random() * 10) + 1;
                player1.speed=rang;
                rang=(int)(Math.random() * 10) + 1;
                player2.speed=rang;
            }
            i++;
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

        // ประกาศผู้ชนะ
        if  (winplayer1) {
            System.out.println("Player 1 wins!");
        }
        else if (winplayer2) {
            System.out.println("Player 2 wins!");
        }
    }
}