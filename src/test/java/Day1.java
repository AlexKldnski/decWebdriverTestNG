import org.testng.annotations.Test;

import java.util.Arrays;

public class Day1 {

    public void SortArrays(double[] array) {
        Arrays.sort(array);
    }

    @Test
    public void testFirst001() {
        System.out.println("Hello,world!");

    }

    @Test
    public void test002() {
        double [] myArray = new double[10];
        for (int i=0; i<myArray.length; i++){
            myArray [i]=Math.random()*100;
            System.out.println(myArray[i]);
        }
        /*double temp;
        for (int i=0; i < myArray.length; i++) {
            for (int j = 0; j < myArray.length; j++) {
                if (myArray[i] < myArray[j]) {
                    temp = myArray[i];
                    myArray[i] = myArray[j];
                    myArray[j] = temp;
                }
            }
        }*/

        SortArrays(myArray);
        //Arrays.sort(myArray);

        System.out.println();

        for (int i=0; i<myArray.length; i++){
            System.out.println(myArray[i]);
        }
    }

    @Test
    public void test003() {
        boolean a = false;
        boolean b = true;
        if (a!=b){
            System.out.println("That's true");
        }

    }


}
