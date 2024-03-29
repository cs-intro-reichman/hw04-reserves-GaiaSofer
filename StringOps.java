public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        System.out.println(capVowelsLowRest("Hello World"));        // "hEllO wOrld"
        System.out.println(capVowelsLowRest("One two tHRee world")); // "OnE twO thrEE wOrld"
        System.out.println(capVowelsLowRest("vowels are fun"));       // "vOwEls ArE fUn"
        System.out.println(capVowelsLowRest("intro"));               // "IntrO"
        System.out.println(capVowelsLowRest("yellow"));              // "yEllOw"
        System.out.println(camelCase("Hello World"));                // "helloWorld"
        System.out.println(camelCase("HELLO world"));                // "helloWorld"
        System.out.println(camelCase(" tWo      wordS"));             // "twoWords"
        System.out.println(camelCase("world"));                      // "world"
        System.out.println(allIndexOf("Hello world",'l'));       // Output: {2, 3, 9}
        System.out.println(allIndexOf("Hello world",' '));       // output: {5}
        System.out.println(allIndexOf("Hello world",'o'));        // output: {4, 7}
        System.out.println(allIndexOf("MMMM",'M'));              // output: {0, 1, 2, 3}
        System.out.println(allIndexOf("Hello worLd",'l'));       // output: {2, 3}
    }

    public static String capVowelsLowRest (String string) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);

            if (isVowel(ch)) {
                result.append(Character.toUpperCase(ch));
            } else {
                result.append(Character.toLowerCase(ch));
            }
        }

        return result.toString();
    }

    private static boolean isVowel(char ch) {
        char lowerCh = Character.toLowerCase(ch);
        return lowerCh == 'a' || lowerCh == 'e' || lowerCh == 'i' || lowerCh == 'o' || lowerCh == 'u';
    }


    public static String camelCase (String string) {
            string = string.trim();
            StringBuilder newString = new StringBuilder();
            boolean capitalizeNext = false;
        
            for (int i = 0; i < string.length(); i++) {
                char currentChar = string.charAt(i);
        
                if (currentChar == ' ') {
                    capitalizeNext = true;
                } else {
                    if (capitalizeNext) {
                        newString.append(Character.toUpperCase(currentChar));
                        capitalizeNext = false;
                    } else {
                        newString.append(Character.toLowerCase(currentChar));
                    }
                }
            }
        
            return newString.toString();
    }


    public static int[] allIndexOf (String string, char chr) {
        int count = 0;

        //determine the size of the result
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == chr) {
                count++;
            }
        }

        //the result
        int[] result = new int[count];
        int resultIndex = 0;

        //indexes
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == chr) {
                result[resultIndex] = i;
                resultIndex++;
            }
        }

        return result;
    }}