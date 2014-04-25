/*
 * Javaによるプログラム
 * author: OHASHI Kent
 */

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;

public class ProgramInJava {
    private static final int FIRST_PRIME = 2;

    /*
     * エラトステネスの篩(ふるい)により最大値maxまでの素数のリストを取得する。
     * maxが整数でない場合、コンパイルエラーとなる。
     */
    public static List<Integer> primeNumbers(int max) {
        List<Integer> primes = new ArrayList<Integer>();
        if (max < 0) {
            return primes;
        }

        List<Integer> numbers = new ArrayList<Integer>(max);
        for (int i = FIRST_PRIME; i <= max; i++) {
            numbers.add(i);
        }
        int stopPoint = (int) Math.sqrt(max);
        return primeFilter(numbers, primes, stopPoint);
    }

    private static List<Integer> primeFilter(List<Integer> numbers, List<Integer> primes, int stopPoint) {
        for (int i = FIRST_PRIME; i <= stopPoint; i++) {
            if (numbers.get(0) == i) {
                final int n = i;
                primes.add(n);
                numbers.remove(0);
                CollectionUtils.filter(numbers, new Predicate<Integer>() {
                    public boolean evaluate(Integer x) {
                        return (x % n != 0);
                    }
                });
            }
        }
        primes.addAll(numbers);
        return primes;
    }

    public static void main(String[] args) {
        // 実行例
        System.out.println(primeNumbers(100));
    }
}
