import org.testng.annotations.Test;

public class BreakContinueTest {

    @Test
    public void test001() {
        int i;
        for (i = 0; i < 5; i++) {
            if (i >= 3) {
                break;
            }
            System.out.println("Yuhu");
            if (i >= 1) {
                continue;
            }
            System.out.println("Tata");
        }
        System.out.println(i);
// Output
// Yuhu
// Tata
// Yuhu
// Yuhu
// 3"
    }
}
