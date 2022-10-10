package lab.greatlearning.test;
import java.util.Scanner;


public class TestTransaction {


	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		TestTransaction testTransaction = new TestTransaction();
		
		System.out.println("enter the size of transaction array");
		int size = sc.nextInt();
		
		int arr[] = new int[size];
		System.out.println("\nenter the values of array");
		
		for (int i = 0; i < size; i++)
			arr[i] = sc.nextInt();
		
		System.out.println("\nenter the total no of targets that needs to be achieved");
		int targetNo = sc.nextInt();
		
		while (targetNo-- != 0) {
			
			long target;
			System.out.println("\nenter the value of target");
			target = sc.nextInt();
			int result = testTransaction.findTarget(arr,target,size);
			
			if(result==-1) {
				System.out.println("\nTarget not achieved");
			}else {
				System.out.println("\nTarget achieved after "+(result + 1) + " transactions");
			}
		}
		
		sc.close();
		
	}
	
	private int findTarget(int[] arr,long target,int size) {
		
		long sum = 0;
		int achived = -1;
		
		for (int i = 0; i < size; i++) {
		
			sum += arr[i];
		
			if (sum >= target) {
				achived = i;
				break;
			}
		}
		
		return achived;
		
	}
	
}
