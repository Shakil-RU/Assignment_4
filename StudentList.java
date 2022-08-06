import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {
//		Check arguments
		char check = args[0].substring(0).charAt(0);
		if(args[0].length() >1 && (check == 'a' || check == 'r' || check == 'c')){
			System.out.println(Constant.valid_Text2);
			return;
		}
		if(check!='a' && check!= 'r' && check!= 'c' && check!='?' && check!='+'){
			System.out.println(Constant.valid_Text);
			return;
		}
		if(args[0].equals("a")) {
			System.out.println(Constant.loading_Text);
			try {
				String Students_info[] = getBufferedReader().readLine().split(", ");
				for(String student : Students_info) {
					System.out.println(student);
				}
			}
			catch (Exception e){

			}
			System.out.println(Constant.data_Loaded);
		}
		else if(args[0].equals("r")) {
			System.out.println(Constant.loading_Text);
			try {
				String Students_info[] = getBufferedReader().readLine().split(", ");
				int index = new Random().nextInt(Students_info.length);
				System.out.println(Students_info[index]);
			}
			catch (Exception e){
				System.out.println(Constant.data_Not_Found);
			}
			System.out.println(Constant.data_Loaded);
		}
		else if(args[0].contains("+")){
			System.out.println(Constant.loading_Text);
			try {
				BufferedWriter bufferedWriter = new BufferedWriter(
						new FileWriter(Constant.text_File, true));
				String line = getBufferedReader().readLine();
				extracted();
				String newLine = line;
				String given = args[0].substring(1);
				newLine+=", ";
				newLine+=given;
				String formatedDate= new SimpleDateFormat("dd/mm/yyyy-hh:mm:ss a").format(new Date());
				bufferedWriter.write(newLine + "\nList newLine updated on " +formatedDate);
				bufferedWriter.close();
			}
			catch (Exception e){

			}
			System.out.println(Constant.data_Loaded);
		}
		else if(args[0].contains("?")) {
			System.out.println(Constant.loading_Text);
			try {
				String Students[] = getBufferedReader().readLine().split(", ");
				int index;
				for( index = 0; index<Students.length; index++) {
					if(Students[index].trim().equals(args[0].substring(1).trim())) {
						System.out.println(Constant.data_Found);
						break;
					}
				}
				if(index>=Students.length){
					System.out.println("The word you are searching for "+ "( " + args[0].substring(1).trim() + " )" + " is not found!");
				}
			}
			catch (Exception e){

			}
			System.out.println(Constant.data_Loaded);
		}
		else if(args[0].contains("c")) {
			System.out.println(Constant.loading_Text);
			try {
				String StudentCharArray[] = getBufferedReader().readLine().split(", ");
				System.out.println(StudentCharArray.length +" word(s) found ");
			}
			catch (Exception e){

			}
			System.out.println(Constant.data_Loaded);
		}
	}

	private static void extracted() throws IOException {
		PrintWriter printWriter = new PrintWriter(new FileWriter(Constant.text_File, false), false);
		printWriter.flush();
		printWriter.close();
	}
	private static BufferedReader getBufferedReader() throws FileNotFoundException {
		return new BufferedReader(
				new InputStreamReader(
						new FileInputStream(Constant.text_File)));
	}
}