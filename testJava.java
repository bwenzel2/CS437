public class testJava{
    public static void main(String[] args){

        for (int i = 1999; i <= 10000; i++){
            int m4 = i % 4;
            int m100 = i % 100;
            int m400 = i % 400;
            //if ((i % 1000) == 0) System.out.println("We're still going");
            if ( ((m4 != 0) == false) && ((m100 == 0) == false) && ((m400 != 0) == false)){//This is the line that we change the true/false strings in
                System.out.println("Value is " + i);
                break;
            }

        }
    }
}
