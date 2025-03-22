import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class communication {
    private ObjectInputStream input;
    private static ObjectOutputStream output;
    
        public communication(Socket socket){
            try {
                output = new  ObjectOutputStream(socket.getOutputStream());
                input = new ObjectInputStream(socket.getInputStream());
            } catch (Exception e) {
                System.out.println("Erro criar obj: "+e.getMessage());
            }
        }
        public static Object enviar(Object object){
            try {
                output.writeObject(object);
        } catch (Exception e) {
            System.out.println("Erro enviar obj: "+e.getMessage());
        }
                return object;
    }
    public Object receber(){
        try {
            return input.readObject();
        } catch (Exception e) {
            System.out.println("Erro receber obj: "+e.getMessage());
            return null;
        }
    }
    public void fechar(){
        try {
            input.close();
            output.close();
        } catch (Exception e) {
            System.out.println("Erro fechar: "+e.getMessage());
        }
    }
}
