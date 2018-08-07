public class TennisScoring {

    String points;
    int pntA, pntB, gameA, gameB, setA, setB;

    public TennisScoring(String in) {
        this.points = in;
        this.pntA = 0;
        this.pntB = 0;
        this.gameA = 0;
        this.gameB = 0;
        this.setA = 0;
        this.setB = 0;
    }

    public void evalAndPrintScore() {
        for(char c : this.points.toUpperCase().toCharArray()) {
            if(c == 'A')
                this.pntA++;
            else
                this.pntB++;
            this.checkGame();
        }
        this.printResult();
    }

    public void checkGame() {
        if(this.pntA >= 4 && this.pntA - this.pntB >= 2) {
            this.pntA = 0;
            this.pntB = 0;
            this.gameA++;
            this.checkSet();
        }
        else if(this.pntB >= 4 && this.pntB - this.pntA >= 2) {
            this.pntA = 0;
            this.pntB = 0;
            this.gameB++;
            this.checkSet();
        }
    }

    public void checkSet() {
        if(this.gameA >= 6 && this.gameA - this.gameB >= 2) {
            this.gameA = 0;
            this.gameB = 0;
            this.setA++;
        }
        else if(this.gameB >= 6 && this.gameB - this.gameA >= 2) {
            this.gameA = 0;
            this.gameB = 0;
            this.setB++;
        }
    }

    public void printResult() {
        System.out.println("player:\t\tA\tB");
        System.out.println("sets:\t\t" + this.setA + "\t" + this.setB);
        System.out.println("games:\t\t" + this.gameA + "\t" + this.gameB);
        this.printPoints();
    }

    public void printPoints() {
        int points[] = {0, 15, 30, 40};
        System.out.print("points:\t\t");

        if(this.pntA >= 3 && this.pntB >= 3) {
            if(this.pntA == this.pntB)
                System.out.println("deuce");
            else if(this.pntA > this.pntB)
                System.out.println("adv\t40");
            else
                System.out.println("40\tadv");
        }
        else
            System.out.println(points[this.pntA] + "\t" + points[this.pntB]);
    }


    public static void main(String[] args) {
        String input = "ABABABAAB";
        TennisScoring tennis = new TennisScoring(input);
        tennis.evalAndPrintScore();
    }
}