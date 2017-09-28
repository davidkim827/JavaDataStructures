/**
 * Created by dk on 9/28/2017.
 */
public class timer {
    public static void main(String[] args) {
        int countSeconds = 0;
        int countMinutes = 0;
        int countHundrethSeconds = 0;
        while (true) {
            long startTime = System.currentTimeMillis();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long endTime = System.currentTimeMillis();
            int hundrethSeconds = (int) ((endTime - startTime) / 10);
            System.out.println("You have : " + countMinutes + " minutes and " + countSeconds + " seconds and " + (countHundrethSeconds + hundrethSeconds));
            countHundrethSeconds++;
            if (countSeconds == 60) {
                countMinutes++;
                countSeconds = 0;
            }
            if (countHundrethSeconds == 99) {
                countSeconds++;
                countHundrethSeconds = -1;
            }
        }
    }
}
