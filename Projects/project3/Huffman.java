public class Huffman {
    public static char lookupCode(String codeFilename, String target) {
        char asciiNum = (char)0;
        In inFile = new In(codeFilename);
        while (inFile.hasNextLine()) {
            String read = inFile.readString();
            if (read.equals(target)) {
                asciiNum = (char)inFile.readInt();
            } // end of 
            inFile.readLine();
        } // end of while loop
        inFile.close();
        return asciiNum;
    } // end of lookupCode

    public static int[] huffmanDecode(String inputFileName, String outputFileName) {
        In inFile = new In(inputFileName);
        Out outFile = new Out(outputFileName);
        String target = "";
        int amountBit = 0;
        int amountChar = 0;
        while (inFile.hasNextChar()) {
            char read = inFile.readChar();
            if (read == '0' || read == '1') {
                amountBit++;
                target = target + read;
                char lookup = lookupCode("code-table.txt", target);
                if (lookup != (char)0) {
                    outFile.print(lookup);
                    amountChar++;
                    target = "";
                } // end of if statement
            } // end of if statement
        } // end of while loop
        int[] data = new int[2];
        data[0] = amountBit;
        data[1] = amountChar;
        inFile.close();
        return data;
    } //end of huffmanDecode
} // end of class
