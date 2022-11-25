import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = {0,20,7, 9, 1, 18, 6, 7};// by nadav!!!
        // 1,2,6,7,9,18

        int[][] couples = printBestCouples(array);

        for (int i = 0; i < couples.length; i++)
            printArray(couples[i]); 

    }

    // כתוב פעולה המקבלת מערך מספרים שלמים שונים ומחזירה את אינדקס של השני הכי קטן
    public static int getSecondMin(int[] array) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                index = i;
            }
        }
        int secondMin = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > min && array[i] < secondMin) {
                secondMin = array[i];
                index = i;
            }
        }
        return index;
    }


    // כתבו פעולה המקבלת מערך של מספרים שלמים על הפעולה להדפיס רק את המספרים הזוגיים במיקומים אי זוגיים
    public static void printEven(int[] array) {
        for (int i = 0; i < array.length; i++)
            if (array[i] % 2 == 0 && i % 2 == 1)
                System.out.println(array[i]);
    }

    // [[1,2],[3,4],[5,6]]
    // [ (2,9), (1,18), (6,7) ]
    // כתוב פעולה המקבלת מערך של מספרים ומחזירה מערך של זוגות של מספרים מהמערך ( מצוותת לזוגות )
    // סכום הזוג המקסימלי בחלוקה צריך להיות מינימלי ביחס לכל חלוקה אחרת אפשרית
    public static int[][] printBestCouples(int[] array) {
        bubbleSort(array);
        int[][] couples = new int[array.length / 2][2]; //  [ [0,0], [0,0]... ]
        int f = 0, l = array.length - 1;
        while (f < l) {
            System.out.println(f);
            couples[f] = new int[]{array[f], array[l]};   // (i,j) // [ [1,2], [3,4] ]
            f++;
            l--;
        }
        return couples;
    }


    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

}
