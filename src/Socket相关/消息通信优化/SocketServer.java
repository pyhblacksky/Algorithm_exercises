package Socket相关.消息通信优化;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: pyh
 * @Date: 2019/7/15 10:19
 * @Version: 1.0
 * @Function:
 * @Description:
 */
public class SocketServer {

    public static void main(String[] args) throws Exception{

        int port = 55555;
        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("server 开始监听");
        Socket socket = serverSocket.accept();

        InputStream  inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();
        while((len = inputStream.read(bytes)) != -1){
            sb.append(new String(bytes, 0, len, "UTF-8"));
        }

        System.out.println("收到消息 : " + sb);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello this is Server !".getBytes("UTF-8"));

        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();

    }

}
