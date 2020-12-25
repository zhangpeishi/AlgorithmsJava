/**
 * The sequence of triangle numbers is generated by adding the natural numbers. So the 7th triangle
 * number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:
 *
 * <p>1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 *
 * <p>Let us list the factors of the first seven triangle numbers:
 *
 * <p>1: 1 3: 1,3 6: 1,2,3,6 10: 1,2,5,10 15: 1,3,5,15 21: 1,3,7,21 28: 1,2,4,7,14,28 We can see
 * that 28 is the first triangle number to have over five divisors.
 *
 * <p>What is the value of the first triangle number to have over five hundred divisors?
 *
 * <p>link: https://projecteuler.net/problem=12
 */
public class Problem12 {

  /** Driver Code */
  public static void main(String[] args) {
    assert solution1(500) == 76576500;
  }

  /* returns the nth triangle number; that is, the sum of all the natural numbers less than, or equal to, n */
  public static int triangleNumber(int n) {
    int sum = 0;
    for (int i = 0; i <= n; i++) sum += i;
    return sum;
  }

  public static int solution1(int number) {
    int j = 0; // j represents the jth triangle number
    int n = 0; // n represents the triangle number corresponding to j
    int numberOfDivisors = 0; // number of divisors for triangle number n

    while (numberOfDivisors <= number) {

      // resets numberOfDivisors because it's now checking a new triangle number
      // and also sets n to be the next triangle number
      numberOfDivisors = 0;
      j++;
      n = triangleNumber(j);

      // for every number from 1 to the square root of this triangle number,
      // count the number of divisors
      for (int i = 1; i <= Math.sqrt(n); i++) if (n % i == 0) numberOfDivisors++;

      // 1 to the square root of the number holds exactly half of the divisors
      // so multiply it by 2 to include the other corresponding half
      numberOfDivisors *= 2;
    }
    return n;
  }
}
