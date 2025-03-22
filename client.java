import java.io.ObjectInputFilter;
import java.net.*;
import java.util.Scanner;
public class client {
    public static void main(String[] args) {
        Socket socket;
        String nomeServer = "192.168.0.1";
        final int PORT = 0000;
        Scanner sc = new Scanner(System.in);

        try {
            socket = new Socket(nomeServer, PORT);
            communication cm = new communication(socket);

            System.out.println("Conectado!");
            System.out.println("Digite a senha...");
            String senha = sc.next();
            System.out.println("Digite seu RA");
            String ra = sc.next();

            Request rq = new Request(senha, ra);
            cm.enviar(rq);

            Response resposta = (Response) cm.receber();

                System.out.println(resposta.getCod());
                System.out.println(resposta.getMessage());

            cm.fechar();
            socket.close();
        } catch (Exception e) {
            System.out.println("Erro na classe client: "+e.getMessage());
        }
    }
}
    
