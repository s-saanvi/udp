import java.io.IOException; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 
import java.io.BufferedReader; 
import java.io.InputStreamReader; 
 
public class UdpClient { 
    public static void main(String[] args) throws IOException { 
        byte[] sendData = new byte[1024]; 
        byte[] receiveData = new byte[1024]; 
        while (true) { 
            DatagramSocket mySocket = new DatagramSocket(); 
            System.out.println("Enter the data:"); 
            BufferedReader inputFromUser = new BufferedReader(new 
            InputStreamReader(System.in)); 
            InetAddress myIP = InetAddress.getByName("localhost"); 
            String data = inputFromUser.readLine(); 
            sendData = data.getBytes(); 
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, myIP, 4000); 
            mySocket.send(sendPacket); 
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); 
            mySocket.receive(receivePacket); 
            String dataToDisplay = new String(receivePacket.getData(), 0, receivePacket.getLength()); 
            System.out.println("From server: " + dataToDisplay); 
            mySocket.close(); 
        } 
    }
}