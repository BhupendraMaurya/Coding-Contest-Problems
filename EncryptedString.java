public class EncryptedString {
    
    public String getEncryptedString(String s, int k) {
        //Brute force Approach
        
        //finding the index of encrypted index,

        //making StringBuilder to store the encrypted string

        StringBuilder encryptedString = new StringBuilder();

        int n = s.length();

        for(int i=0;i<s.length();i++){
            
            //finding the current character
            char currentChar = s.charAt(i);

            //finding the index to encrypted string to find the char of entrypted string
            int newCharIndex = (i+k)%n;

            //finding the character to append in encrypted string

            char replacedChar = s.charAt(newCharIndex);

            // adding in encrypted string
            encryptedString.append(replacedChar);
        }

        return encryptedString.toString();
    }

    public static String encryptedString2(String s, int k){
        // Second Approach
        String ans = "";

        int n = s.length();
// finding the index k, if k is greater than k, bacause index could go   till n-1 only.

        k = k%n;

        // just start from k and go till n-1 and append the charaters in ans string( )
        for(int i=k;i<n;i++){
            ans += s.charAt(i);
        }

// start from 0 and go till k-1 and append all charactyers in ans string
        for(int i=0;i<k;i++){
            ans += s.charAt(i);
        }

        return ans;
    }
}
