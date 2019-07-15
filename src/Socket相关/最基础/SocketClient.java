package Socket相关.最基础;

import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author: pyh
 * @Date: 2019/7/15 10:11
 * @Version: 1.0
 * @Function:
 * @Description:
 */
public class SocketClient {

    public static void main(String[] args) throws Exception{
        String host = "127.0.0.1";
        int port = 55555;

        Socket socket = new Socket(host, port);

        OutputStream outputStream = socket.getOutputStream();
        String message = "hello world";
        socket.getOutputStream().write(message.getBytes("UTF-8"));

        outputStream.close();
        socket.close();
    }

}
