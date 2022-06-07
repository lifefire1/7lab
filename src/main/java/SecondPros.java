import java.io.*;
import java.net.Socket;

public class SecondPros {
    private static Socket clientSocket;
    private static BufferedReader reader;
    private static BufferedReader in;
    private static BufferedWriter out;
    private static int [][] matrix;
    public static void main(String[] args) {
        matrix = new int[][] {
                {2,4,3},
                {5,7,8},
                {6,9,1},
        };
        try {
            try {
                clientSocket = new Socket("localhost", 5000);
                reader = new BufferedReader(new InputStreamReader(System.in));
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                String th = in.readLine();
                System.out.println(th);
                String[] det1 = th.split(" ");
                String thisDet = determine2(Integer.parseInt(det1[0]), Integer.parseInt(det1[1]), Integer.parseInt(det1[2]), Integer.parseInt(det1[3])).toString();
                System.out.println("det = " + thisDet);
                clientSocket.close();
                Thread.sleep(2850);
                Socket send = new Socket("localhost", 5000);
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(send.getOutputStream()));
                writer.write(thisDet);
                writer.flush();
                send.close();
                writer.close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Client has been closed");
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }

    }
    static Integer determine2(int a, int b, int c, int d){
        return a * d - b * c;
    }
}
