/*
Question:
Given two strings, write a method to decide if one is a permutation of the other.
*/

//bitmap
public boolean isPermutation(String s1, String s2){
	int bitmap[]=new int[128];

	//store each s1 characters' info in the bitmap
	for(int i=0;i<s1.length();i++){
		int index=s1.charAt(i);
		bitmap[index]++;
	}

	//if a character in s2 shows up, minus one in the bitmap
	for(int i=0;i<s2.length();i++){
		int index=s2.charAt(i);
		bitmap[index]--;
	}

	//if it's permutation, then the sum should be zero.
	int sum=0;
	for(int i=0;i<bitmap.length;i++){
		sum+=bitmap[i];
	}
	if(sum==0){
		return true;
	}
	else{
		return false;
	}

}