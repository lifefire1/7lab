import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MainDet {
    private static Socket clientSocket;
    private static Socket secondClientSocket;
    private static Socket thirdClientSocket;
    private static Socket clientSocketOut;
    private static Socket secondClientSocketOut;
    private static Socket thirdClientSocketOut;
    private static ServerSocket server;
    private static BufferedReader in1;
    private static BufferedWriter out1;
    private static BufferedReader in2;
    private static BufferedWriter out2;
    private static BufferedReader in3;
    private static BufferedWriter out3;
    private static int[][] matrix;

    public static void main(String[] args) throws IOException {
        matrix = new int[][]{
                {2, 4, 3},
                {5, 7, 8},
                {6, 9, 1},
        };
        /*
         * найти определитель матрицы
         * каждый из трех частей отправить на отдельный процессор
         * */
        try {
            try {
                server = new ServerSocket(5000);
                System.out.println("server is enable");
                clientSocket = server.accept();
                System.out.println(clientSocket.getInetAddress());
                secondClientSocket = server.accept();
                System.out.println(secondClientSocket.getInetAddress());
                thirdClientSocket = server.accept();
                System.out.println(thirdClientSocket.getInetAddress());

                try {
                    in1 = new BufferedReader(new InputStreamReader(
                            clientSocket.getInputStream()));
                    out1 = new BufferedWriter(new OutputStreamWriter(
                            clientSocket.getOutputStream()
                    ));
                    in2 = new BufferedReader(new InputStreamReader(
                            secondClientSocket.getInputStream()));
                    out2 = new BufferedWriter(new OutputStreamWriter(
                            secondClientSocket.getOutputStream()));
                    in3 = new BufferedReader(new InputStreamReader(
                            thirdClientSocket.getInputStream()));
                    out3 = new BufferedWriter(new OutputStreamWriter(
                            thirdClientSocket.getOutputStream()));


                    String det1 = matrix[1][1] + " " + matrix[1][2] + " " + matrix[2][1] + " " + matrix[2][2];
                    String det2 = matrix[0][1] + " " + matrix[2][1] + " " + matrix[0][2] + " " + matrix[2][2];
                    String det3 = matrix[0][1] + " " + matrix[1][1] + " " + matrix[0][2] + " " + matrix[1][2];
                    out1.write(det1);
                    System.out.println("determine send to first client");
                    out2.write(det2);
                    System.out.println("determine send to second client");
                    out3.write(det3);
                    System.out.println("determine send to third client");
                    out1.flush();
                    out2.flush();
                    out3.flush();
                    clientSocket.close();
                    secondClientSocket.close();
                    thirdClientSocket.close();
                    clientSocketOut = server.accept();
                    System.out.println(clientSocketOut.getInetAddress());
                    secondClientSocketOut = server.accept();
                    System.out.println(secondClientSocketOut.getInetAddress());
                    thirdClientSocketOut = server.accept();
                    System.out.println(thirdClientSocketOut.getInetAddress());
                    BufferedReader first = new BufferedReader(new InputStreamReader(clientSocketOut.getInputStream()));
                    BufferedReader second = new BufferedReader(new InputStreamReader(secondClientSocketOut.getInputStream()));
                    BufferedReader third = new BufferedReader(new InputStreamReader(thirdClientSocketOut.getInputStream()));
                    String clientDet1 = first.readLine();
                    String clientDet2 = second.readLine();
                    String clientDet3 = third.readLine();
                    int det1res = Integer.parseInt(clientDet1);
                    int det2res = Integer.parseInt(clientDet2);
                    int det3res = Integer.parseInt(clientDet3);
                    System.out.println("det 1 is " + det1res +
                            "\ndet 2 is " + det2res +
                            "\ndet 3 is " + det3res);
                    double result = 2 * det1res - 5 * det2res + 6 * det3res;
                    System.out.println(result);
                    }
                    finally {
                        clientSocket.close();
                        in1.close();
                        out1.close();
                        secondClientSocket.close();
                        in2.close();
                        out2.close();
                        thirdClientSocket.close();
                        in3.close();
                        out3.close();
                    }

                } finally {
                    System.out.println("server has been closed");
                    server.close();
                }
            } catch (IOException exception) {
                System.out.println(exception.getMessage());
            }
        }
        private void run(){
            System.out.println("Hello world");
            cicle:{
                System.out.println();
            }

            http://www.java-point.ru
            return;
        }
    }
