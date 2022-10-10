package lab.greatlearning.test;

import java.util.Scanner;

public class TestNotes{

	public static void main(String[] args) {
	    TestNotes testNotes = new TestNotes();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter the size of currency denominations");
		int size = sc.nextInt();
		
		int arr[] = new int[size];
		System.out.println("\nenter the size of currency denominations");
		
		for (int i = 0; i < size; i++)
			arr[i] = sc.nextInt();
		
		System.out.println("\nenter the amount you want to pay");
		int amount = sc.nextInt();
		testNotes.mergeSort(arr,0,arr.length-1);
		testNotes.notesIdentifier(arr, amount);

		sc.close();
		
	}

	private void notesIdentifier(int[] arr, int amount) {
		
		int[] notesCount = new int[arr.length];
		try {
			for (int i = 0; i < arr.length; i++) {
				if (amount >= arr[i]) {
					notesCount[i] = amount / arr[i];
					amount = amount - notesCount[i] * arr[i];
				}
			}
			if(amount > 0) {
				System.out.println("Exact amount cannot be given");	
			}else {
				System.out.println("Your payment approach in order to give min no of notes ");
       
				for (int i = 0; i < arr.length; i++) {
					if (notesCount[i] != 0) {
						System.out.println(arr[i] + " : " + notesCount[i]);
					}
				}
			}
		
		} catch(ArithmeticException e) {
			System.out.println(e+ "Notes of denomination is invalid");
		}
		
	}
	
	public void mergeSort(int[] notes, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(notes, left, mid);
			mergeSort(notes, mid + 1, right);
			merge(notes, left, mid, right);
		}
	}
	
	void merge(int arr[], int left, int mid, int right) {

		int n1 = mid - left + 1;
		int n2 = right - mid;

		int leftArray[] = new int[n1];
		int rightArray[] = new int[n2];

		for (int i = 0; i < n1; ++i)
			leftArray[i] = arr[left + i];
		for (int j = 0; j < n2; ++j)
			rightArray[j] = arr[mid + 1 + j];

		int i = 0, j = 0;
		int k = left;
		while (i < n1 && j < n2) {
			if (leftArray[i] >= rightArray[j]) {
				arr[k] = leftArray[i];
				i++;
			} else {
				arr[k] = rightArray[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = leftArray[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = rightArray[j];
			j++;
			k++;
		}
	}
	
}
