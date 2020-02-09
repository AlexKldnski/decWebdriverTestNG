import com.sun.javaws.progress.PreloaderPostEventListener;
import org.testng.ConversionUtils;
import org.testng.annotations.Test;

import java.awt.image.ImageProducer;
import java.util.*;

public class Day2 {
    @Test
    public void swapTwoNumbersInArray() {
        int[] array = {1, 2, 3, 4};
        swap(array, 1,2);
        System.out.println(Arrays.toString(array));
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Test
    public void testPrintOddNumbers() {
        for (int i=1; i<=10; i++){
            if (i%2!=0) System.out.println(i);
        }

    }

    @Test
    public void testCountLetters() {
        String input = "hello world";
        int result = 0;
        for (char eachChar : input.toCharArray()){
            if (eachChar=='l') result++;
        }
        System.out.println(result);
    }

    @Test
    public void testCountAllLetters() {
        String input = "hello world";
        System.out.println(input);
        char[] arrayOfChars = input.toCharArray();
        ArrayList<Character> sortedArrayOfChars = new ArrayList<Character>();
        for (int i=0; i<arrayOfChars.length; i++){
            if (sortedArrayOfChars.contains(arrayOfChars[i])) continue;
            else sortedArrayOfChars.add(arrayOfChars[i]);
        }

        System.out.println(sortedArrayOfChars.toString());

        HashMap<Character, Integer> mapOfLetters = new HashMap<Character, Integer>();

        for (char each : sortedArrayOfChars) {
            int count = 0;
            for (int i=0; i<arrayOfChars.length; i++) {
            if(each==arrayOfChars[i]) count++;
            mapOfLetters.put(each, count);
            }
        }
        System.out.println(mapOfLetters);
    }

    @Test
    public void testConstructorTest() {
        Actor instanceOfActor = new Actor("Name", "LastName");
        instanceOfActor.act();
        instanceOfActor.play();
    }

    @Test
    public void testArrays() {
    int[] array = {1, 2, 3, 4, 5};
        ArrayList<Integer> arrayList= new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);
    }

    @Test
    public void testActorsArrayList() {
        ArrayList<Actor> actorArrayList = new ArrayList<Actor>();
        Actor newActor1 = new Actor("John", "Travolta");
        Actor newActor2 = new Actor("Tom", "Hanks");
        actorArrayList.add(newActor1);
        actorArrayList.add(newActor2);;
        System.out.println(actorArrayList.toString());

    }

    @Test
    public void testPrintEvenNumbers() {
        for (int i=1; i<=10;i++){
            if (i%2==0) System.out.println(i);
        }
    }

    @Test
    public void testIfPalindrome() {
    String str = "dot saw I was tod";
        System.out.println(testCheckPalindrom(str));
    }

    private boolean testCheckPalindrom(String str) {
        boolean ifPalindrome = false;
        //char[] arrayOfChar = str.toCharArray();
        char[] reversedArray = new char[str.length()];
        for (int i=0; i<reversedArray.length; i++){
            reversedArray[reversedArray.length-i-1]=str.charAt(i);
        }
        String reversedStr = new String(reversedArray);
        if (str.equals(reversedStr)){
            ifPalindrome=true;
        }
        System.out.println(str);
        System.out.println(reversedStr);
        return ifPalindrome;
    }

    @Test
    public void testDoWhileLoops() {
        int i=0;
        do {
            System.out.println(i);
            i++;
        } while (i<10);
    }

    @Test
    public void testEnhancedForLoops() {
        int[] arr = {0,1,2,3,4,5,6,7,8,9,10};
        for (int i : arr){
            System.out.println(i);
        }
    }

    @Test
    public void testArrayList() {
        List ls = new ArrayList();
        for (int i = 0; i <= 10; i++) {
            Actor actor = new Actor("Name", "Lastname");
            ls.add(actor);
            System.out.println(ls.get(i));
            System.out.println(ls.size());
        }
    }


        @Test
        public void method1() {
            System.out.println("This is method 1");
        }

        @Test(dependsOnMethods={"method1"})
        public void method2() {
            System.out.println("This is method 2");
        }


    @Test
    public void testWhileLoops() {
        int i=0;
        while (i<5){
            System.out.println(i);
            i++;
        }

    }
}

