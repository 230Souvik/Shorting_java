
package sorting;
import java.util.*;
import java.lang.*;

public class Sorting {
    public void insertion(int arr[],int n){
        int i,j,key;
        for(i=1;i<n;i++){
            key=arr[i];
            j=i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j=j-1;
            }
            arr[j+1]=key;
            display(arr,n);
        }
    }
    public void marge(int arr[],int l,int r){
        if(l<r){
        int m=(l+r)/2;
        marge(arr,l,m);
        marge(arr,m+1,r);
        margesort(arr,l,m,r);
        //display(arr, r+1);
        }
    }
    public void margesort(int arr[],int l,int m,int r){
        int n1=m-l+1;
        int n2=r-m;
        int i=0,j=0;
        int L[]=new int[n1];
        int R[]=new int[n2];
        for( i=0;i<n1;i++){
            L[i]=arr[i+l];
        }
        for( j=0;j<n2;j++){
            R[j]=arr[j+m+1];
        }
        int k=l;
        
        while(i<n1 &&j<n2 ){
            if(L[i]<=R[j]){
                arr[k]=L[i];
  i++;
            }
            else{
                arr[k]=R[j];j++;
            }
            k++;
        }
        while(i<n1){
            arr[k]=L[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k]=R[j];
            j++;k++;
        }
        //display(arr,k);
//        System.out.println("priny array");
//        //int n=arr.length;
//        for(int v=0;i<k;i++){
//             System.out.println(arr[v]+" ");}
        
    }
    public void display(int arr[],int n){
        System.out.println("priny array");
         for(int i=0;i<n;i++){
             System.out.println(arr[i]+" ");
    }
    }
    public void print(int arr[]){
        int n=arr.length;
        for(int i=0;i<n;i++){
             System.out.println(arr[i]+" ");
    }
    }
    static void quick(int arr[],int l,int r){
        if(l<r){
            int pos=quicksort(arr,l,r);
            quicksort(arr,l,pos-1);
            quicksort(arr,pos+1,r);
        }
       // display(arr,r+1);
    }
    static int quicksort(int arr[],int l,int r){
        int lb,ub,pivot;
        lb=l;
        ub=r;
        pivot=arr[l];
        while(lb<ub){
            while(arr[lb]<=pivot && lb<ub){
                lb++;
            }
            while(arr[lb]>=pivot){
                ub--;
            }
            if(lb<ub){
                int temp=arr[lb];
                arr[lb]=arr[ub];
                arr[ub]=temp;
            }
        }
        int temp=arr[l];
        arr[l]=arr[ub];
        arr[ub]=temp;
        return ub;
        
    }
 
    public static void main(String[] args) {
        // TODO code application logic hereSorting
        Sorting s=new Sorting();
        
        System.out.println("no of element in array");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("enter ele of array");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("priny array");
         for(int i=0;i<n;i++){
             System.out.println(arr[i]+" ");
         }
        System.out.println("1.insertion sort 2.marge sort 3.quick sort 4.heap sort");
        int i=sc.nextInt();
        switch(i){
            case 1:{
                s.insertion(arr,n);
                break;
            }
            case 2:{
                s.marge(arr,0,n-1);
                System.out.println("after sort");
                s.print(arr);
               // s.display(arr, n);
                break;
            }
            case 3:{
                s.quick(arr,0,n-1);
                System.out.println("sorted array");
                System.out.println(Arrays.toString(arr));
                break;
            }
            case 4:{
               // s.heap();
                break;
            }
        }
        
    }
    
}
