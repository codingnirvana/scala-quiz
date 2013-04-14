package codejam;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class FairAndSquare {
    static Scanner sc;
    static PrintStream out;

    public static void main(String[] args) throws Exception {
        sc = new Scanner(new FileReader("input/qualification/C-large-1.in"));
        out = System.out; //new PrintStream(new FileOutputStream("C-large-2.out"));

        for (int length = 1; length <= 100; length++)
            addNumbers(length);
        fsNumbers = fsSet.toArray(new BigInteger[0]);

//        for (BigInteger fsNumber : fsNumbers) {
//            System.out.println(fsNumber);
//        }

        for (String root : roots) {
            System.out.println(root);
        }

//        int testCases = sc.nextInt();
//        for (int index = 1; index <= testCases; index++) {
//            out.println(String.format("Case #%s: %s", index, solveCase()));
//        }
    }

    static BigInteger[] fsNumbers;
    static Set<BigInteger> fsSet = new TreeSet<BigInteger>();

    static Set<String> roots = new TreeSet<String>();

    public static int solveCase() {
        BigInteger lower = new BigInteger(sc.next()).subtract(BigInteger.ONE);
        BigInteger upper = new BigInteger(sc.next());
        return getCount(upper) - getCount(lower);
    }

    static int getCount(BigInteger limit) {
        int count = Arrays.binarySearch(fsNumbers, limit);
        if (count < 0)
            count = -(count + 1);
        else
            count++;
        return count;
    }

    public static void addNumbers(int length) {
        if (length % 2 == 0)
            return;

        if (length == 1) {
            checkAndAdd("0");
            checkAndAdd("1");
            checkAndAdd("2");
            checkAndAdd("3");
            return;
        }

        int rootLength = (length + 1) / 2;

        // Add roots starting with 1
        char[] root = new char[rootLength];
        Arrays.fill(root, '0');
        root[0] = root[rootLength - 1] = '1';
        checkAndAdd(new String(root));

        for (String temp : roots.toArray(new String[0])) {
            if (temp.length() < rootLength
                    && (rootLength - temp.length()) % 2 == 0) {
                Arrays.fill(root, '0');
                root[0] = root[rootLength - 1] = '1';
                int offset = (rootLength - temp.length()) / 2;
                for (int index = 0; index < temp.length(); index++)
                    root[index + offset] = temp.charAt(index);
                checkAndAdd(new String(root));
            }
        }

        // Add roots starting with 2
        Arrays.fill(root, '0');
        root[0] = root[rootLength - 1] = '2';
        checkAndAdd(new String(root));

        if (rootLength % 2 == 1) {
            root[rootLength / 2] = '1';
            checkAndAdd(new String(root));
        }

    }

    static String reverse(String text) {
        return new StringBuilder(text).reverse().toString();
    }

    static boolean checkAndAdd(String root) {
        BigInteger number = new BigInteger(root);
        number = number.multiply(number);
        boolean shouldAdd = isPalindrome(number);
        if (shouldAdd) {
            roots.add(root);
            fsSet.add(number);
        }
        return shouldAdd;
    }

    public static boolean isPalindrome(BigInteger number) {
        String text = number.toString();
        return text.equals(reverse(text));
    }

}