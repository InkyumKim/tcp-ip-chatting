import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * TCP 서버 프로그램
 */

public class TcpServer2 {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(49152);//포트지정
			System.out.println(getTime()+": 서버가 준비되었습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} 	
		
		while(true) {
			try {
				System.out.println(getTime() + "연결 요청을 기다립니다. ");
				
				//연결 요청 수락
				Socket socket = serverSocket.accept();
				System.out.println(getTime() + socket.getInetAddress() + "로부터 연결요청이 들어왔습니다."); //상대 주소 볼 수 있음
				System.out.println("통신 포트: " + socket.getPort());
				
				//데이터를 송신하기 위한 출력스트림을 얻어온다.
				OutputStream out = socket.getOutputStream();
				//출력스트림을 글자단위 전송 스트림으로 전환
				DataOutputStream dos = new DataOutputStream(out);
				
				dos.writeUTF("[알림]서버에서 응답메시지가 전송되었습니다.");
				System.out.println(getTime() + ": 데이터를 전송하였습니다.");
				
				dos.close();  //출력 스트림 close
				socket.close(); //통신 연결 해제
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    
		}
	}
	
	/*
	 * 현재 시각을 출력하는 메소드
	 */
	
	public static String getTime() {
		//출력할 시간 포맷 생성
		SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss] ");
		
		return sdf.format(new Date());
	}

}
