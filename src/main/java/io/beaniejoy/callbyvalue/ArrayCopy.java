package io.beaniejoy.callbyvalue;

public class ArrayCopy {

    // copy and expand length from original array by for loop
    static int[] expandLengthByForLoop(int[] arr) {
        int[] newArr = new int[arr.length * 2];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        return newArr;
    }

    // copy and expand length from original array by for loop
    static int[] expandLengthByArrayCopy(int[] arr) {
        int[] newArr = new int[arr.length * 2];

        System.arraycopy(arr, 0, newArr, 0, arr.length);

        return newArr;
    }

    // call by value 내용을 보여주는 메소드
    static void expandLengthNotChanged(int[] arr) {
        int[] newArr = new int[arr.length * 2];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        // 여기서 arr은 메소드 안에서의 parameter 변수값
        // 호출부에서 argument 넣은 arr의 참조값을 복사해서 가져오기만 하는꼴(사실 call by value)
        // 본래의 arr은 변하지 않는다.
        arr = newArr;
        System.out.println("method: " + arr);
    }

    public static void main(String[] args) {
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        System.out.println("[변경전]");
        System.out.println("arr ref: " + arr);
        System.out.println("arr.length: " + arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] : " + arr[i]);
        }

//        arr =expandLengthByForLoop(arr);
//        arr = expandLengthByArrayCopy(arr);
        expandLengthNotChanged(arr);

        System.out.println("[변경후]");
        System.out.println("arr ref: " + arr);
        System.out.println("arr.length: " + arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] : " + arr[i]);
        }
    }
}
