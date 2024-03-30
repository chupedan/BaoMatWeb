public class Chuong4 {
    // Bài tập 4.10.1
    public static int[] extendedEuclidean(int a, int b) {
        if (b == 0) {
            return new int[]{a, 1, 0};
        } else {
            int[] values = extendedEuclidean(b, a % b);
            int d = values[0];
            int x = values[2];
            int y = values[1] - (a / b) * values[2];
            return new int[]{d, x, y};
        }
    }

    public static void main(String[] args) {
        int a = 240;
        int b = 46;

        int[] result = extendedEuclidean(a, b);
        int d = result[0];
        int x = result[1];
        int y = result[2];

        System.out.println("Greatest Common Divisor (GCD) of " + a + " and " + b + " is: " + d);
        System.out.println("Values of x and y in equation ax + by = d are: x = " + x + ", y = " + y);
    }
}
