import java.io.IOException; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 
import java.io.BufferedReader; 
import java.io.InputStreamReader; 
 
public class UdpServer { 
    public static void main(String[] args) throws IOException { 
        DatagramSocket datagramSocket = new DatagramSocket(4000); 
        System.out.println("Server ready for connection:"); 
        System.out.println("Waiting for the message..."); 
        byte[] receiveData = new byte[1024]; 
        byte[] sendData = new byte[1024]; 
        while (true) { 
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); 
            datagramSocket.receive(receivePacket); 
            String data = new String(receivePacket.getData(), 0, receivePacket.getLength()); 
            System.out.println("Client data: " + data); 
            InetAddress clientIPAddress = receivePacket.getAddress(); 
            int port = receivePacket.getPort(); 
            System.out.println("Enter the data to send to client:"); 
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); 
            String dataToSend = input.readLine(); 
            sendData = dataToSend.getBytes(); 
            DatagramPacket toSendToClient = new DatagramPacket(sendData, sendData.length, 
clientIPAddress, port); 
            datagramSocket.send(toSendToClient); 
        } 
    } 
} 