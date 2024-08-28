package de.brockhausag;

public class OddOrEven implements OddOrEvenGame{


    @Override
    public String oddOrEven(int input) {
        if(input % 2 == 0) {
            return "Die Zahl " + input + " ist grade.";
        }else {
            return "Die Zahl " + input + " ist ungrade.";
        }
    }
}
