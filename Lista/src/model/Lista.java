package model;
/**
 * <h1>Lista de Tipo de Dado Generico</h1>
 * Esta lista aloca dados de qualquer tipo definido pelo programador
 * @author Vinicius S. Barbosa
 * 
 * @since 09.10.23
 *
 * @param <T> tipo de valores que serao alocados na lista
 */
public class Lista<T>{
	
	No<T> primeiro;
	
	public Lista() {
		primeiro = null;
	}
	/**
	 * Este metodo e utilizado para verificar se a lista esta vazia
	 * @return boolean retorna <b>true</b> se a lista for vazia e <b>false</b> caso contrario 
	 */
	public boolean isEmpty() {
		if (primeiro == null) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Realiza a contagem de itens inseridos na lista
	 * @return int retorna a quantidade de itens na lista
	 */
	public int size() {
		int cont = 0;
		if (!isEmpty()) {
			No<T> auxiliar = primeiro;
			while (auxiliar != null) {
				cont++;
				auxiliar = auxiliar.proximo;
			}
		}
		return cont;
	}
	/**
	 * Realiza a busca de um valor presente na lista, esse valor esta sendo apontado pelo obejto No
	 * @param posicao que esta localizado o valor procurado
	 * @return objeto No que contem o valor procurado 
	 * @throws Exception Mensagem de excecao personalizada caso a lista esteja vazia ou receba uma posicao invalida como parametro 
	 */
	private No<T> getNo(int posicao) throws Exception{
		if (isEmpty()) {
			throw new Exception("Lista Vazia!");
		}
		int tamanho = size();
		if (posicao < 0 || posicao > tamanho-1) {
			throw new Exception("Posicao Invalida!");
		}
		int cont = 0;
		No<T> auxiliar = primeiro;
		while (cont < posicao) {
			auxiliar = auxiliar.proximo;
			cont++;
		}
		return auxiliar;
	}
	/**
	 * Adiciona um valor para a primeira posicao da lista
	 * @param valor e o dado que sera inserido na lista
	 */
	public void addFirst(T valor) {
		No<T> elemento = new No<>();
		elemento.dado = valor;
		elemento.proximo = primeiro;
		primeiro = elemento;
	}
	/**
	 * Adiciona um valor para a ultima posicao da lista
	 * <p>Caso nao haja dados na lista, o metodo para adicionar a primeira posicao e chamado 
	 * @param valor é o dado que sera inserido na lista
	 */
	public void addLast(T valor) throws Exception {
		if (isEmpty()) {
			addFirst(valor);
		}
		int tamanho = size();
		No<T> elemento = new No<>();
		elemento.dado = valor;
		elemento.proximo = null;
		
		No<T> ultimo = getNo(tamanho-1);
		ultimo.proximo = elemento;
	}
	/**
	 * Adiciona um valor em uma posicao especifica da lista
	 * @param valor que sera inserido na lista
	 * @param posicao que o valor sera inserido
	 * @throws Exception Posicao Invalida passada como parametro
	 */
	public void add(T valor, int posicao) throws Exception {
		int tamanho = size();
		if (posicao < 0 || posicao > tamanho) {
			throw new Exception("Posicao Invalida!");
		}
		if (posicao == 0) {
			addFirst(valor);
		} else if (posicao == tamanho) {
			addLast(valor);
		} else {
			No<T> anterior = getNo(posicao-1);
			No<T> elemento = new No<>();
			elemento.dado = valor;
			elemento.proximo = anterior.proximo;
			anterior.proximo = elemento;
		}
		
	}
	/**
	 * Remove o dado alocado na primeira posicao da lista
	 * @throws Exception Caso a lista esteja vazia
	 */
	public void removeFirst() throws Exception{
		if (isEmpty()) {
			throw new Exception("Lista Vazia!");
		}
		primeiro = primeiro.proximo;
	}
	/**
	 * Remove o dado da ultima posicao da lista
	 * @throws Exception Caso a lista esteja vazia
	 */
	public void removeLast() throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista Vazia!");
		}
		int tamanho = size();
		if (tamanho == 1) {
			removeFirst();
		} else {
			No<T> penultimo = getNo(tamanho-2);
			penultimo.proximo = null;
		}
	}
	/**
	 * Remove um dado de uma posicao especifica da lista
	 * @param posicao do dado que sera removido da lista
	 * @throws Exception Caso a lista esteja vazia ou a posicao do dado a ser removido seja invalida
	 */
	public void remove(int posicao) throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista Vazia!");
		}
		int tamanho = size();
		if (posicao < 0 || posicao > tamanho-1) {
			throw new Exception("Posicao Invalida!");
		}
		if (posicao == 0) {
			removeFirst();
		} else if (posicao == tamanho-1) {
			removeLast();
		} else {
			No<T> anterior = getNo(posicao-1);
			No<T> atual = getNo(posicao);
			anterior.proximo = atual.proximo;
		}
	}
	/**
	 * Procura e retorna um dado de uma posicao especifica da lista
	 * @param posicao que esta o dado 
	 * @return Valor generico que a lista esta armazenando
	 * @throws Exception - Caso a lista esteja vazia ou a posicao do dado buscado seja invalida
	 */
	public T get(int posicao) throws Exception{
		if (isEmpty()) {
			throw new Exception("Lista Vazia!");
		}
		int tamanho = size();
		if (posicao < 0 || posicao > tamanho-1) {
			throw new Exception("Posicao Invalida!");
		}
		No<T> elemento = getNo(posicao);
		return elemento.dado;
	}
}
