// An example of a double-recursive function.

public class DoubleRecursion {

    public static void main(String[] args) {

        // NOTE: you can modify this array to try different sizes.
        int[] population = { 25, 40, 35, 50, 20, 85, 12, 3 };
        int n = population.length;
        System.out.print("population: ");
        for (int i = 0; i < n; i++)
            System.out.print(population[i] + " ");
        System.out.println();

        System.out.printf("within main: compute(population, %d, %d) is about to be called...\n", 0, n - 1);
        int result = compute(population, 0, n - 1, " >");
        System.out.printf("within main: compute(population, %d, %d) returned value: %d\n", 0, n - 1, result);

    }

    public static int compute(int[] arr, int s, int e, String indent) {
        System.out.printf("%s Compute for positions %d to %d...\n", indent, s, e);
        int t;
        if (s > e) { // invalid positions, s must be less than or equal to e
            t = 0;
        } else if (s == e) {
            t = arr[s];
        } else {
            int m = (s + e) / 2; // middle position, halfway between s and e
            int L = compute(arr, s, m, indent + " >");
            int R = compute(arr, m+1, e, indent + " >");
            t = L + R;
        }
        System.out.printf("%s Result for positions %d to %d is %d\n", indent, s, e, t);
        return t;
    }
}
