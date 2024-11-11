import java.io.*;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        String challengeOneTwo = "inputOneTwo.txt";
        String challengeThreeFour = "inputThreeFour.txt";
        writeFileAllAnswers("AdventureTime", challengeOne(challengeOneTwo), challengeTwo(challengeOneTwo), challengeThree(challengeThreeFour), challengeFour(challengeThreeFour));

    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        int challengeOneAnswer = 0;
        int[] a = new int[countLinesInFile(fileName)];
        a = readFile(fileName);
        for(int i=0; i<a.length-1; i++){
            if(a[i+1]-a[i] > 0){
                challengeOneAnswer++;
            }
            else{
                challengeOneAnswer=challengeOneAnswer;
            }
        }
        return challengeOneAnswer;
    }


    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int challengeTwoAnswer = 0;
        int[] b = new int[countLinesInFile(fileName)];
        b = readFile(fileName);
        for(int i=0; i<b.length-3; i++){
            if((b[i+1]+b[i+2]+b[i+3])-(b[i]+b[i]+b[i])>0){
                challengeTwoAnswer ++;
            }
            else{
                challengeTwoAnswer = challengeTwoAnswer;
            }
        }
        return challengeTwoAnswer;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        int depth = 0;
        int horizontal = 0;
        String[] c = new String[countLinesInFile(fileName)];
        c = readFileTwo(fileName);
        for (int i=0; i<c.length;i++){
            if(c[i].substring(0,2).equals("up")){
                depth = depth-(Integer.parseInt(c[i].substring(3,c[i].length())));
            }
            else if(c[i].substring(0,4).equals("down")){
                depth = depth+(Integer.parseInt(c[i].substring(5,c[i].length())));
            }
            else if(c[i].substring(0,7).equals("forward")){
                horizontal = horizontal+(Integer.parseInt(c[i].substring(8,c[i].length())));
            }
        }
        int challengeThreeAnswer = horizontal*depth;
        return challengeThreeAnswer;
    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param fileName
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String fileName) throws FileNotFoundException {
        String[] d = new String[countLinesInFile(fileName)];
        d = readFileTwo(fileName);
        int horizontal = 0;
        int aim = 0;
        int depth = 0;
        for(int i=0; i<d.length; i++){
            if(d[i].substring(0,2).equals("up")){
                aim = aim-(Integer.parseInt(d[i].substring(3,d[i].length())));
            }
            else if(d[i].substring(0,4).equals("down")){
                aim = aim+(Integer.parseInt(d[i].substring(5,d[i].length())));
            }
            else if(d[i].substring(0,7).equals("forward")){
                horizontal = horizontal+(Integer.parseInt(d[i].substring(8,d[i].length())));
                depth = depth+aim*(Integer.parseInt(d[i].substring(8,d[i].length())));
            }
        }
        int challengeFourAnswer = horizontal*depth;
        return challengeFourAnswer;
    }


//OTHER METHODS
    private static String[] readFileTwo(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        String[] data = new String[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextLine();
        }
        scanner.close();
        return data;
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }
}
