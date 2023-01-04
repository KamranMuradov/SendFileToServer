package TCP;

import lombok.SneakyThrows;
import util.FileUtility;
import util.InputUtil;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    @SneakyThrows
    public static void sendAsBytes() {
        String name = InputUtil.requireText("Enter name:");
        String surname = InputUtil.requireText("Enter surname:");
        System.out.println("Welcome " + name + " " + surname);

        String fileLocation = InputUtil.requireText(
                "Please enter the location of the file you want to send:"
        );
        String serverDestination = InputUtil.requireText("" +
                "Please enter IP and port of server you want to send file:"
        );
        String[] arr = serverDestination.split(":");
        String ip = arr[0];
        int port = Integer.parseInt(arr[1]);

        Socket socket = new Socket(ip, port);
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        byte[] fileBytes = FileUtility.readBytes(fileLocation);
        dataOutputStream.writeInt(fileBytes.length);
        dataOutputStream.write(fileBytes);
        socket.close();
        System.out.println("Operation completed successfully");
    }
}
