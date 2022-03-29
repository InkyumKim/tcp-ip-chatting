import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * TCP Ŭ���̾�Ʈ ���α׷�
 */

public class TcpClient {

	public static void main(String[] args) {
		String serverIp = "127.0.0.1";  //����ǻ���� ip �ּ�
		System.out.println("������ �������Դϴ�. ����ip: " +serverIp);
		
		//������ ���� ��û: ������ ip�ּҿ� ��Ʈ��ȣ ����
		try {
			Socket socket = new Socket(serverIp, 49152);
			
			//�����͸� ������ �Է½�Ʈ���� ���´�.
			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			
			//�������� ���� �޽��� ����
			System.out.println("�������� ���� �޽���: " +dis.readUTF());
			dis.close();	//�Է� ��Ʈ�� close
			socket.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
