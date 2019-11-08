import java.util.Scanner;

class TestClass {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		while(T-->0) {
			int N=sc.nextInt();
			int arr[]=new int[N+1];
			for(int i=1;i<=N;i++)
				arr[i]=sc.nextInt();
			int pos=sc.nextInt();
			System.out.println(kthSmall(arr,1,N,pos));
		}
		sc.close();
	}
	public static int kthSmall(int arr[],int L,int R, int pos) {
		//print(arr);
		int pivot=findPivot(arr,L,R);
			if(pivot==pos)
				return arr[pivot];
			else if(pivot<pos)
				return kthSmall(arr,pivot+1,R,pos);
			else
				return kthSmall(arr,L,pivot-1,pos);	
	}
	public static int findPivot(int arr[],int L,int R) {
		int i=L;
		for(int j=L+1;j<=R;j++) {
			if(arr[j]<=arr[L]) {
				i++;
				swap(arr,i,j);
			}
		}
		swap(arr,L,i);
		return i;
	}
	public static void print(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public static void swap(int arr[],int x,int y) {
		int temp=arr[x];
		arr[x]=arr[y];
		arr[y]=temp;
	}
}