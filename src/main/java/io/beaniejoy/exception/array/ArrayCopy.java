package io.beaniejoy.exception.array;

public class ArrayCopy {

    // copy and expand length from original array by for loop
    static int[] expandLengthByForLoop(int[] arr) {
        int[] newArr = new int[arr.length * 2];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        return newArr;
    }

    static int[] expandLengthByArrayCopy(int[] arr) {
        int[] newArr = new int[arr.length * 2];

        System.arraycopy(arr, 0, newArr, 0, arr.length);

        return newArr;
    }

    public static void main(String[] args) {
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        System.out.println("[변경전]");
        System.out.println("arr.length: " + arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] : " + arr[i]);
        }

//        arr = expandLengthByForLoop(arr);
        arr = expandLengthByArrayCopy(arr);

        System.out.println("[변경후]");
        System.out.println("arr.length: " + arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] : " + arr[i]);
        }
    }
}
