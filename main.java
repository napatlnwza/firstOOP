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
        input.nextLine();
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
        System.out.println("H is Heal");
        System.out.println("*********************************");
        input.nextLine();

        // ตัวแปรหาผู้ชนะ
        boolean winplayer1=false,winplayer2=false;

        // โควต้าการฮิล
        int healplayer1=3,healplayer2=3;


        // เริ่มเกม
        while (player1.hp > 0 && player2.hp > 0) {
            while (player1.speed == player2.speed) {
                int rang=(int)(Math.random() * 10) + 1;
                player1.speed=rang;
                rang=(int)(Math.random() * 10) + 1;
                player2.speed=rang;
            }
            System.out.println("P1 Action: ");
            String play1 = input.nextLine().toUpperCase();
            System.out.println("P2 Action:");
            String play2 = input.nextLine().toUpperCase();
            if (play1.equals("A") && play2.equals("D")) {
                double dam = 1.2*(player1.atk - (player2.def / player1.speed));
                if (dam < 0) dam=1;
                double disdam=dam-player2.speed*(0.9);
                player2.hp = player2.hp - dam + disdam;
            }
            if (play2.equals("A") && play1.equals("D")) {
                double dam = 1.2*(player2.atk - (player1.def / player2.speed));
                if (dam < 0) dam=1;
                double disdam=dam-player1.speed*(0.9);
                player1.hp = player1.hp - dam + disdam;
            }
            if (play1.equals("D") && play2.equals("D")) {
                IO.println("HP player 1: " + player1.hp);
                IO.println("HP player 2: "+ player2.hp);
                continue;
            }
            if (play1.equals("A") && play2.equals("A")) {
                double damToP2 = 0.8 * (player1.atk - (player2.def / player1.speed));
                damToP2 = Math.max(1, damToP2 - (player2.speed * 0.5));
                player2.hp -= damToP2;

                // P2 โจมตี P1
                double damToP1 = 0.8 * (player2.atk - (player1.def / player2.speed));
                damToP1 = Math.max(1, damToP1 - (player1.speed * 0.5));
                player1.hp -= damToP1;
            }
            if (play1.equals("H") && healplayer1 > 0) {
                healplayer1--;
                player1.hp+=(player1.maxhp * 0.3);
                System.out.println("Hp : " + player1.hp);
                System.out.println("Quota healing P1 : " + healplayer1 + "/3");
            }
            if (play2.equals("H") && healplayer2 > 0) {
                healplayer2--;
                player2.hp+=(player2.maxhp * 0.3);
                System.out.println("Hp : " + player2.hp);
                System.out.println("Quota healing P2 : " + healplayer2 + "/3");
            }
            IO.println("HP player 1: " + "HP : " + player1.hp);
            IO.println("HP player 2: " + "HP : " + player2.hp);
        }
        if (player1.hp > player2.hp) {
            winplayer1=true;
        }
        else if  (player2.hp > player1.hp) {
            winplayer2=true;
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