package source;

import source.EmptyQueueException;
import source.NodeQueue;
import source.Queue;

public class Josephus {
	/** Solução para o problema de Josephus usando uma fila
	 * @throws EmptyQueueException */
	public static <E> E Josephus(Queue<E> Q, int k) throws EmptyQueueException {
		if (Q.isEmpty()) return null;
		while (Q.size() > 1) {
			System.out.println(" Queue: " + Q + " k = " + k);
			for (int i = 0; i < k; i++) Q.enqueue(Q.dequeue()); // move o elemento do início para o fim
			E e = Q.dequeue(); // remove o elemento da frente da coleção
			System.out.println(" " + e + " is out");
		}
		return Q.dequeue(); // o vencedor }
	}
	/** Cria uma fila a partir de um arranjo de objetos */
	public static <E> Queue<E> buildQueue(E a[]) {
		Queue<E> Q = new NodeQueue<E>();
		for (int i = 0; i < a.length; i++) Q.enqueue(a[i]);
		return Q;
	}
	/** Método de teste 
	 * @throws EmptyQueueException */
	public static void main(String[] args) throws EmptyQueueException {
		String[] a1 = { "Alice", "Bob", "Cindy", "Doug", "Ed", "Fred" };
		String[] a2 = { "Gene", "Hope", "Irene", "Jack", "Kim", "Lance" };
		String[] a3 = { "Mike", "Roberto" };
		System.out.println("First winner is " + Josephus(buildQueue(a1), 3));
		System.out.println("Second winner is " + Josephus(buildQueue(a2), 10));
		System.out.println("Third winner is " + Josephus(buildQueue(a3), 7));
	}
}

