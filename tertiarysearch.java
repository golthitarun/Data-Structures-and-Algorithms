
public class tertiarysearch {

int tertiary(int n1,int n2,int i,int a[]){
	int mid1,mid2,len;
	len=(n2-n1)/3;
	mid1=n1+len;
	mid2=n2-len;
	if(n2>=n1){
	   if(a[mid1]==i){
		 return mid1;
	   }
	   if(a[mid2]==i){
		//System.out.println(mid2);
		 return mid2;
	   }
	   if(i>a[mid1]){
		  if(i<a[mid2]){
			return tertiary(mid1+1,mid2-1,i,a);
		  }
		  else{
			return tertiary(mid2+1,n2,i,a);
		  }
	   }
	   else if(a[mid1]>i){
		 return tertiary(n1,mid1-1,i,a);
	   }
	}
	return -1;
}
public static void main(String[] args){
	int a[]={1,10,23,45,53,67,78,83,90,100,110,115,113};
	tertiarysearch ts=new tertiarysearch();
	int len=a.length;
	int x=78;
	int ans=ts.tertiary(0,len-1,x,a);
	if(ans!=-1){
		System.out.println("The Element is at index:"+ans);
	}
	else{
	System.out.println("The Element is not present in the array.");
	}
}
}
