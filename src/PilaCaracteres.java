import java.util.Stack;
public class PilaCaracteres {
    private Stack <Character> pila;

    public PilaCaracteres (){
        pila = new Stack<Character>();
    }

    public boolean estaVacia(){
        return pila.empty();
    }

    public Character    primerElemento(){
        if (pila.empty())
            throw new NullPointerException();
        else
            return pila.firstElement();

    }
    public Character mirarElemento(){
        if (pila.empty())
            throw new NullPointerException("no existen elementos");
        else
            return pila.peek();

    }
    public Character quitarElemento() throws Exception{
        if (pila.empty())
            throw new NullPointerException();
        else
            return pila.pop();

    }

    public Character apilarElemento(Character elemento){
        return pila.push(elemento);
    }

    public int buscarElemento(Character elemento){
        if(pila.empty())
            throw  new NullPointerException("Pila vacía");
        else
            return pila.search(elemento);
    }

    public int tamanio(){
        return pila.size();
    }

    @Override
    public String toString() {
        String mensaje = "";
        for (int i = pila.size() - 1; i >= 0; i--) { // Corregir la condición y el decremento de i
            mensaje = mensaje + pila.get(i).toString() + "\n";
        }
        return mensaje;
    }

}
