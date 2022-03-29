import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * TCP ���� ���α׷�
 */

public class TcpServer2 {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(49152);//��Ʈ����
			System.out.println(getTime()+": ������ �غ�Ǿ����ϴ�.");
		} catch (IOException e) {
			e.printStackTrace();
		} 	
		
		while(true) {
			try {
				System.out.println(getTime() + "���� ��û�� ��ٸ��ϴ�. ");
				
				//���� ��û ����
				Socket socket = serverSocket.accept();
				System.out.println(getTime() + socket.getInetAddress() + "�κ��� �����û�� ���Խ��ϴ�."); //��� �ּ� �� �� ����
				System.out.println("��� ��Ʈ: " + socket.getPort());
				
				//�����͸� �۽��ϱ� ���� ��½�Ʈ���� ���´�.
				OutputStream out = socket.getOutputStream();
				//��½�Ʈ���� ���ڴ��� ���� ��Ʈ������ ��ȯ
				DataOutputStream dos = new DataOutputStream(out);
				
				dos.writeUTF("[�˸�]�������� ����޽����� ���۵Ǿ����ϴ�.");
				System.out.println(getTime() + ": �����͸� �����Ͽ����ϴ�.");
				
				dos.close();  //��� ��Ʈ�� close
				socket.close(); //��� ���� ����
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    
		}
	}
	
	/*
	 * ���� �ð��� ����ϴ� �޼ҵ�
	 */
	
	public static String getTime() {
		//����� �ð� ���� ����
		SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss] ");
		
		return sdf.format(new Date());
	}

}
