package models;

import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class URLExtraction {
	
	public static ArrayList<Passenger> pasgnrList;
	public static Train train;
	
	public static ArrayList<Passenger> getPasgnrList() {
		return pasgnrList;
	}

	public static void setPasgnrList(ArrayList<Passenger> pasgnrList) {
		URLExtraction.pasgnrList = pasgnrList;
	}

	public static Train getTrain() {
		return train;
	}

	public static void setTrain(Train train) {
		URLExtraction.train = train;
	}

	public static ArrayList<Passenger> dumpData(String url) throws Exception {
		
		// Parse the URL
		String str = "http://localhost:8080/getResult?";
		URL parsedUrl = new URL(str+url);
		String queryString = parsedUrl.getQuery();

		String[] params = queryString.split("&");

		Map<String, String> paramMap = new HashMap<>();

		for (String param : params) {
			String[] keyValue = param.split("=");
			String paramName = URLDecoder.decode(keyValue[0], "UTF-8");
			String paramValue = URLDecoder.decode(keyValue[1], "UTF-8");
			paramMap.put(paramName, paramValue);
		}

		// Print the extracted parameters and their values
		// paramMap.forEach((param, value) -> System.out.println(param + ": " + value));

		String from = paramMap.get("from");
		String to = paramMap.get("to");
		String trainName = paramMap.get("trainslist");
		String classs = paramMap.get("class");
		String date = paramMap.get("date");
		paramMap.remove("from");
		paramMap.remove("to");
		paramMap.remove("trainslist");
		paramMap.remove("class");
		
		// converting train details into objects
		train  = new Train(from, to, trainName, date, classs);
		
		
		// converting passengers into objects
		for (int i = 1; i <= 6; i++) {
			String namev = null, genderv = null, agev = null;
			
			String namek = "P" + i + "name";
			String genderk = "P" + i + "gender";
			String agek = "P" + i + "age";
			for(String s : paramMap.keySet()) {
				if(namek.equals(s)) {
					namev = paramMap.get(s);
				}
				if(genderk.equals(s)) {
					genderv = paramMap.get(s);
				}
				if(agek.equals(s)) {
					agev = paramMap.get(s);
				}
			}
			if(namev == null || genderv == null || agev == null)
				continue;
			else
				PassengerList.addPassenger(new Passenger(namev, genderv, agev));
		}
		
		pasgnrList = PassengerList.getData();
		
		return PassengerList.getData();
	}
//	public static void main(String[] args) throws Exception {
//		String url = "http://localhost:8080/getResult?from=TPTY+-+Tirupati+Main&to=CCT+-+Kakinada+Town+Junction&trainslist=Tiruchchirappalli+SF+Express&class=3A&date=2023-08-22&P1name=mohan&P1gender=male&P1age=22&P2name=chinnu&P2gender=female&P2age=22";
//		ArrayList<Passenger> A = dumpData(url);
//		System.out.println();
//		
//		for(Passenger p : A) {
//			System.out.println(p);
//		}
//	}
}










