package Merge;
import java.util.Arrays;
import java.util.Random;


public class Merge {

	
	
    public static void main(String[] args)
    {
    	
    	
    	int[] a = new int[20];
    	Random rnd = new Random();
		for (int i = 0; i < 20; i++) {
			a[i] = 1 + rnd.nextInt(100);
		}

       

		System.out.println();
		

        System.out.print("Rasgele Dizi:");
        for (int x = 0; x < a.length; x++)
        {
        	System.out.print(a[x]);
            if (x <= a.length - 2) System.out.print(",");
        }

        int[] B = Arrays.copyOf(a, a.length);
        int[] C = Arrays.copyOf(a, a.length);
        
        System.out.println();
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Recursive Merge Sort");
        System.out.println();
        long startTime = System.nanoTime();

        
        mergesort(a,0, a.length-1);
        
        
        long endTime = System.nanoTime();
		long estimatedTime = endTime - startTime;
        System.out.println();

		System.out.println("Recursive Merge Sort Çalýþma Süresi= " + estimatedTime + " Nanosaniye");
		
		
		System.out.print("Sýralanmýþ Dizi: " );
		diziYaz(a);
		System.out.println("------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Iterative Merge Sort");
        System.out.println();
		long startTime2 = System.nanoTime();

		iterativesort(B, B.length);
		
		
		long endTime2 = System.nanoTime();
		long estimatedTime2 = endTime2 - startTime2;
		System.out.println("Iterative Merge Sort Çalýþma Süresi= " + estimatedTime2 + " Nanosaniye");
		System.out.println();
		
		System.out.print("Sýralanmýþ Dizi: " );
		diziYaz(B);
        System.out.println();
        System.out.println("----------------------------------------------------------------------------");

        System.out.println("Insertion Merge Sort");
        System.out.println();
		
		long startTime3 = System.nanoTime();
		
		insertionsort(C);
		
		long endTime3 = System.nanoTime();
		
		long estimatedTime3 = endTime3 - startTime3;
		System.out.println();
		System.out.println("Insertion Sort Çalýþma Süresi= " + estimatedTime3 + " Nanosaniye");
		System.out.println();

		System.out.print("Sýralanmýþ Dizi: " );
		diziYaz(C);
 


       
    }

	
    
    static void mergee(int arr[], int alt, int mid, int ust)  
    {  
      
    int l = mid - alt + 1;  
    int r = ust - mid;  
      
    int Sol[] = new int [l];  
    int Sag[] = new int [r];  
      
    for (int i=0; i<l; ++i)  
    Sol[i] = arr[alt + i];  
      
    for (int j=0; j<r; ++j)  
    Sag[j] = arr[mid + 1+ j];  
      
      
    int i = 0, j = 0;  
    int k = alt;  
    while (i<l&&j<r)  
    {  
    if (Sol[i] <= Sag[j])  
    {  
    arr[k] = Sol[i];  
    i++;  
    }  
    else  
    {  
    arr[k] = Sag[j];  
    j++;  
    }  
    k++;  
    }  
    while (i<l)  
    {  
    arr[k] = Sol[i];  
    i++;  
    k++;  
    }  
      
    while (j<r)  
    {  
    arr[k] = Sag[j];  
    j++;  
    k++;  
    }  
    
    diziYaz(arr);
    }  
      
   static void mergesort(int arr[], int alt, int ust)  
    {  
    if (alt<ust)  
    {  
    int mid = (alt+ust)/2;  
    mergesort(arr, alt, mid);  
    mergesort(arr , mid+1, ust);  
    mergee(arr, alt, mid, ust);  
    }  
    }  
    

    static void diziYaz(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
        	System.out.print(arr[i] + " ");
        	
        }
    	System.out.println();

    }

    static void merge(int arr[], int l, int m, int r) 
    { 
    	
        int n1 = m - l + 1; 
        int n2 = r - m; 

        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 

        int i = 0, j = 0; 
        int k = l; 
        
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
        diziYaz(arr);
    } 
    
    static void iterativesort(int arr[], int n) 
    { 
          
        int size;  
        int alt; 
                          
        for (size = 1; size <= n-1;size = 2*size) 
        { 
              
            for (alt = 0; alt < n-1;alt += 2*size) 
            { 
                int mid = Math.min(alt + size - 1, n-1); 
          
                int ust = Math.min(alt + 2*size - 1, n-1); 

                merge(arr, alt, mid, ust); 
            } 
        } 
    } 
    
    
    static public void insertionsort(int[] dizi)
    {
        int adim = 0;
        for (int i = 0; i < dizi.length; i++)
        {
            for (int j = i; j > 0; j--)
            {
                if (dizi[j] < dizi[j - 1])
                {
                    int temp = dizi[j];
                    dizi[j] = dizi[j - 1];
                    dizi[j - 1] = temp;
                    adim = adim + 1;

                    diziYaz(dizi);

                }
            }
        }
    }
    
    

	
}
