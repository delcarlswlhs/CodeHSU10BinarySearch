import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        int[] myNumList = new int[100];
        for(int i = 0; i < myNumList.length; i++){
            myNumList[i] = (int)(Math.random()*(100)+1); //rand ints between 1 and 100
        }

        Arrays.sort(myNumList);
        int randIndex = (int)(Math.random()*(myNumList.length));
        int randNumToFind = myNumList[randIndex];

        //linear search
        long start1 = System.nanoTime();
        int location = linearSearch(myNumList, randNumToFind);
        long end1 = System.nanoTime();
        System.out.println();
        System.out.println("Location: "+location);
        System.out.println("Elapsed time in nano: " + (end1 - start1));

        //binary search
        long start2 = System.nanoTime();
        int location2 = binarySearch(myNumList, randNumToFind,0,myNumList.length-1);
        long end2 = System.nanoTime();
        System.out.println();
        System.out.println("Location: "+location);
        System.out.println("Elapsed time in nano: " + (end2 - start2));

    }

    public static int linearSearch(int[] array, int target){
        for(int i = 0; i<array.length; i++){
            if(array[i] == target){
                return i;
            }
        }
        return -1;
    }

    //recursive binary search
    public static int binarySearch(int[] array, int target, int start, int end){
        int mid = (start+end)/2;
        if(target==array[mid]){ //base case if target exists in list
            return mid;
        }
        if(start==end){ //base case if target not in list
            return -1;
        }
        if(target<array[mid]){
            return binarySearch(array,target,start,mid-1);
        }
        if(target>array[mid]){
            return binarySearch(array, target, mid+1, end);
        }
        return -1;
        }
    }
