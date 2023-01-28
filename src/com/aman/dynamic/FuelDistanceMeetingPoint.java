package com.aman.dynamic;

public class FuelDistanceMeetingPoint {

    public static void main(String[] args) {
        int[] fuelArray = {0,5,6,10,2,3};
        int[] distanceArray = {4,3,8,7,5,3};
        int size = fuelArray.length;
        int fuelExtra= 0;
        int start=0;
        int end=1;
        fuelExtra = fuelExtra+fuelArray[start]-distanceArray[start];
        boolean endAgain=false;
        while(end  != start){
            if(fuelExtra<0){
                fuelExtra = 0;
                start=end;
            }
            fuelExtra = fuelExtra+fuelArray[end]-distanceArray[end];
            end++;
            if(start < end && endAgain) {
                System.out.println("No Solution");
                return;
            }

            if(end>size-1){
                endAgain=true;
            }
            end=end%size;
        }

        if(start == end){
            System.out.println(start + " "+ end);
        }

    }
}
