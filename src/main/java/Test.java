import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class Test {


	public static void main(String[] args) throws IOException {
	Random r = new Random();
	Qclogger qclogger = new Qclogger();

	for(int i=0; i<6; i++) {
		final int _i = i;

		new Thread(() -> {
			int cnt=0;

				while(true) {
					int t = r.nextInt(12000);
					try {

						Thread.sleep(t);
						qclogger.setError(_i, t);

					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}

				}


		}).start();

	}

	}



}
