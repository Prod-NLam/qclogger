
import java.io.*;
import java.util.ArrayList;


public class Qclogger {

	String path = "/Users/msh114901/Desktop/test.txt";
	long time = System.currentTimeMillis();

	public Qclogger() {
	}



	public synchronized void setError(int error, int t) throws IOException {

		String line = readLineOne(error);
		String[] lineperiod = line.split(",");
		int period = calcPeriodBetween10sec();
//		int period = calcPeriodBetween10min();
		int lineEdited = addErrorAtTime(period);
		System.out.println("====lineEdited===="+lineEdited);
		System.out.println("====lineperiod===="+lineperiod[lineEdited]);
		updateErr(lineEdited, lineperiod);
		String updatedValue = updateErr(lineEdited, lineperiod);
		System.out.println("====updatedValue===="+updatedValue);
		replaceFile(path, error, updatedValue, lineEdited);

//		readFile();
//		 TODO Auto-generated method stub

		System.out.println("[Error]code(" + error + ")responsed " + "(" + period + "s)");
	}

	private void replaceFile(String path, int error, String updatedValue, int lineEdited) throws IOException {
		File file = new File(path);
		FileReader filereader = new FileReader(file);
		BufferedReader bfreader = new BufferedReader(filereader);
		int i = 0;
		String thisLine;
		String[] iWantLine = new String[7];
		while ((thisLine = bfreader.readLine()) != null) {
			iWantLine[i] = thisLine;
			i++;
		}
		bfreader.mark(0);
		bfreader.reset();
		bfreader.close();
		filereader.close();
		String oneLine = iWantLine[error];
		System.out.println("====oneLine===="+oneLine);

		String[] onLineEdited = oneLine.split(",");

		onLineEdited[lineEdited] = updatedValue;

		String lastEdited = String.join(",", onLineEdited);
		for (int a =0; a<onLineEdited.length; a++){
			System.out.println("====oneLineEdited===="+onLineEdited[a]);
		}
		System.out.println("====lastEdtied===="+lastEdited);

		iWantLine[error] = lastEdited;
		System.out.println("====oneLine2===="+iWantLine[error]);
		File file2 = new File(path);
		FileReader fr = new FileReader(file2);
		BufferedReader bfr = new BufferedReader(fr);

		FileWriter filewriter = new FileWriter(file2);
		BufferedWriter bfwriter = new BufferedWriter(filewriter);
		int b = 0;
		System.out.println("********READER AND WRITER IS OPENED NOW*********");
		String thatLine;
		while ((thatLine = bfr.readLine()) != null){
			if(b == error){
				System.out.println("I'm here");
				bfwriter.write(lastEdited);
				b++;
			}else{
				System.out.println("kida here");
				bfwriter.write(thatLine);
			System.out.println(thatLine);
			b++;
			}
		}
		bfwriter.close();
		filewriter.close();
		bfr.close();
		fr.close();
	}

	private int calcPeriodBetween10sec() {
		long rntime = System.currentTimeMillis();
		int period = (int)((rntime - time )/1000);
		System.out.println("====calc10sec===="+period);
		return period;
	}

	private String updateErr(int lineEdited, String[] lineperiod) {
		int updated = Integer.parseInt(lineperiod[lineEdited]);
		if(updated == -1){
			updated = 0;
			updated += 1;
		}else {
			updated += 1;
		}
		System.out.println("====updated===="+updated);
		String updatedValue =  String.valueOf(updated);
		return updatedValue;
	}


	public String readLineOne(int error) throws IOException {
		File file = new File(path);
		FileReader filereader = new FileReader(file);
		BufferedReader bfreader = new BufferedReader(filereader);
		int i = 0;
		String thisLine;
		String[] iWantLine = new String[7];
		while ((thisLine = bfreader.readLine()) != null) {
			iWantLine[i] = thisLine;
			i++;
		}
		String oneLine = iWantLine[error];
		return oneLine;
	}


	private int addErrorAtTime(int period){
		System.out.println("====period===="+period);

		if(period <= 10){
			return 0;
		}else if(10 < period && period <= 20){
			return 1;
		}else if(20 < period && period <= 30){
			return 2;
		}else if(30 < period && period <= 40){
			return 3;
		}else if(40 < period && period <= 50){
			return 4;
		}else if(50 < period && period <= 60){
			return 5;
		}else if(60 < period && period <= 70){
			return 6;
		}else if(70 < period && period <= 80){
			return 7;
		}else if(80 < period && period <= 90){
			return 8;
		}else if(90 < period && period <= 100){
			return 9;
		}else if(100 < period && period <= 110){
			return 10;
		}else if(110 < period && period <= 120){
			return 11;
		}

		return 12;

	}


//	public  void readFile() throws IOException {
//		int[] nums = new int[12];
//		String logfile = "/Users/msh114901/Desktop/test.txt";
//
//		File file = new File(logfile);
//
//		FileReader filereader = new FileReader(file);
//
//		BufferedReader bufReader = new BufferedReader(filereader);
//		String line;
//		while((line = bufReader.readLine()) != null) {
//			System.out.println(line);
//			nums = Pattern.compile(",").splitAsStream(line).mapToInt(Integer::valueOf).toArray();
//		}
//		bufReader.close();
//		for(int i=0; i<nums.length;i++){
//			System.out.println(nums[i]);
//		}
//	}

	public boolean makeFile()




	{

		boolean isOK;

		try

		{

			String logfile = "/Users/msh114901/Desktop/test.txt";
			ArrayList<String> al = new ArrayList<String>();

//			for (int i=0; i<6; i++){
				al.add("11,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1");
				al.add("22,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1");
				al.add("33,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1");
				al.add("44,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1");
				al.add("55,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1");
//			}

			FileWriter fw=new FileWriter(logfile, true);

			BufferedWriter bw=new BufferedWriter(fw);



			String strContent;



			for(int i=0; i<al.size(); i++){

				strContent = al.get(i);



				bw.write(strContent);

				bw.newLine();

			}

			bw.flush();

			bw.close();

			fw.close();



			isOK= true;

		}

		catch (Exception e)

		{

			e.printStackTrace();

			isOK = false;

		}

		return isOK;

	}


	
}