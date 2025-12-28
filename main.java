import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        fighter player1 = new fighter();
        tank player2 = new tank();
        boolean winplayer1=false,winplayer2=false;
        Scanner input = new Scanner(System.in);
        while (player1.hp > 0 && player2.hp > 0) {
            int rang=(int)(Math.random()*10) + 1;
            player1.speed=rang;
            rang=(int)(Math.random()*10) + 1;
            player2.speed=rang;
            while (player1.speed == player2.speed) {
                int rang1=(int)(Math.random()*10) + 1;
                player1.speed=rang1;
                rang1=(int)(Math.random()*10) + 1;
                player2.speed=rang1;
            }
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
            if (play1.equals("D")  && play2.equals("D")) {
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
