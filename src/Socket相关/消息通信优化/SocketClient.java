package Socket相关.消息通信优化;


import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author: pyh
 * @Date: 2019/7/15 10:23
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
        outputStream.write("hello, I'm client !".getBytes("UTF-8"));

        socket.shutdownOutput();//已经发送完数据，现在只接收数据

        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();
        while((len = inputStream.read(bytes)) != -1){
            sb.append(new String(bytes, 0, len, "UTF-8"));
        }
        System.out.println("receive " + sb);

        outputStream.close();
        inputStream.close();
        socket.close();
    }

}
