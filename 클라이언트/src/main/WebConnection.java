package main;

/*
 * ���̽�
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Scanner;
public class WebConnection{
	String fishname;
	   String result;
	   //Scanner sc = new Scanner(System.in);
	   public WebConnection(String fishname) throws Exception{
		   this.fishname = fishname;
		   Calendar cal =Calendar.getInstance();
			BufferedReader br=null;
			int year = cal.get(cal.YEAR);
			int month = cal.get(cal.MONTH)+1;
			int date = cal.get(cal.DATE)-1;
			System.out.println(year+"��"+month+"��"+date+"��");
			String dates="";
			if(date<10)
			{
				dates = "0"+String.valueOf(date);
			}
			else
			{
				dates = String.valueOf(date);
			}
			String years = String.valueOf(year);
			String months = String.valueOf(month);
			System.out.println("����� �̸� : ");
			//fishname = sc.nextLine();
			
			String encodeResult = URLEncoder.encode(fishname, "UTF-8");//url�� �̿��ϱ����� ������̸� ���ڵ�
			
			
			try {//url���� �õ�
				String urlstr="http://apis.data.go.kr/1192000/openapi/service/ManageAcst0120Service/getAcst0120List?ServiceKey=Aty4CxF5XK4Q2Q3iqEGjy2R0gTdhh247YIsi%2BM3WooM2phfygeccoX2gUgd8usuTQl1EfUnMnpte1JV93EQ92g%3D%3D&pageNo=1&numOfRows=1&type=json&baseDt="+years+months+dates+"&"+"mprcStdCodeNm="+encodeResult;
				//url>> �ּ�Ű+���α׷� ���� ���� ��¥ + �˻��� ���(���ڵ�)
				URL url = new URL(urlstr);
				HttpURLConnection urlconnection=(HttpURLConnection)url.openConnection();
				urlconnection.setRequestMethod("GET");
				br=new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"utf-8"));
				String line;
				while(((line)=br.readLine())!=null){
					result=line+"\n";
				}
			
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
	   }
	   
	}
