package com.aman.dynamic;

public class ParticleVelocity {

    public static void main(String[] args) {

        int[] A = {0,0,0,1,1,1};

        int total=particlesStabilty(A);
        System.out.println(total);
    }

    private static int particlesStabilty(int[] A) {

        int total=0;
        if(A.length<3){
            return -1;
        }

        for(int i=2; i<A.length; i++){
            int j=0;
            while(i<A.length && A[i]-A[i-1] == A[i-1]-A[i-2]){
                j++;

                total=total+j;
                i++;
            }
        }

        if(total<1000000000){
            return total;
        }

        return -1;
    }
}
