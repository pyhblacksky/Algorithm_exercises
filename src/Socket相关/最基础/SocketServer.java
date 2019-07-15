package Socket相关.最基础;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: pyh
 * @Date: 2019/7/15 9:55
 * @Version: 1.0
 * @Function:
 * @Description:
 */
public class SocketServer {

    //服务端
    public static void main(String[] args) throws Exception{

        int port = 55555;
        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("server 等待连接");
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        StringBuilder sb = new StringBuilder();
        while((len = inputStream.read(bytes)) != -1){
            sb.append(new String(bytes, 0, len, "UTF-8"));
        }

        System.out.println("get message from client : " + sb);

        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
