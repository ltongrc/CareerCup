/*
Question:

Implement a method to perform basic string compression using the counts of repeated characters.
For example, the string aabcccccaaa would become a2b1c5a3. 
If the "compressed" string would not become smaller than the original string,
your method should return the original string.
*/

public StringBuffer stringCompression(String s){
	//append a space in the char array for future operation purpose
	char[] org= (s+" ").toCharArray();
	StringBuffer buffer=new StringBuffer();
	int charCount=1;
	//traverse the whole char array
	for(int i=0;i<org.length-1;i++){
		//if current character equals to next character,
		//plus the charCount
		if(org[i]==org[i+1]){
			charCount++;
		}
		//if two characters are different,
		//append the current character and the count to the StringBuffer.
		//(use of the space in the end of the char array)	
		else{
			buffer.append(org[i]);
			buffer.append(charCount);
			charCount=1;
		}
	}
	//return the shortest StringBuffer
	if(buffer.length()<s.length())
		return buffer;
	else
		return new StringBuffer(s);
}