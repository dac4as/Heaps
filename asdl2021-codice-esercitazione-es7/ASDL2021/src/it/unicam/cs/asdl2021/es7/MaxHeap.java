package it.unicam.cs.asdl2021.es7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * Classe che implementa uno heap binario che può contenere elementi non nulli
 * possibilmente ripetuti.
 * 
 * @author Template: Luca Tesei, Implementation: collettiva
 *
 * @param <E>
 *                il tipo degli elementi dello heap, che devono avere un
 *                ordinamento naturale.
 */
public class MaxHeap<E extends Comparable<E>> {

    /*
     * L'array che serve come base per lo heap
     */
    private ArrayList<E> heap;

    /**
     * Costruisce uno heap vuoto.
     */
    public MaxHeap() {
        this.heap = new ArrayList<E>();
    }

    /**
     * Restituisce il numero di elementi nello heap.
     *
     * @return il numero di elementi nello heap
     */
    public int size() {
        return this.heap.size();
    }

    /**
     * Determina se lo heap è vuoto.
     *
     * @return true se lo heap è vuoto.
     */
    public boolean isEmpty() {
        return this.heap.isEmpty();
    }

    /**
     * Costruisce uno heap a partire da una lista di elementi.
     *
     * @param list lista di elementi
     */
    public MaxHeap(List<E> list) {
        if (list == null)
            throw new NullPointerException();
        list.addAll(heap);
        heapify(0);
    }

    /**
     * Inserisce un elemento nello heap
     *
     * @param el l'elemento da inserire
     * @throws NullPointerException se l'elemento è null
     */
    public void insert(E el) {
        if (el == null)
            throw new NullPointerException();
        heap.add(el);//aggiungo l'elemento infondo alla lista
        heapify(parentIndex(heap.indexOf(el)));//riordina l'albero partendo dal padre dell'elemento aggiunto
    }

    /*
     * Funzione di comodo per calcolare l'indice del figlio sinistro del nodo in
     * posizione i. Si noti che la posizione 0 è significativa e contiene sempre
     * la radice dello heap.
     */
    private int leftIndex(int i) {
        return (2 * i) + 1;
    }

    /*
     * Funzione di comodo per calcolare l'indice del figlio destro del nodo in
     * posizione i. Si noti che la posizione 0 è significativa e contiene sempre
     * la radice dello heap.
     */
    private int rightIndex(int i) {
        return (2 * i) + 2;
    }

    /*
     * Funzione di comodo per calcolare l'indice del genitore del nodo in
     * posizione i. Si noti che la posizione 0 è significativa e contiene sempre
     * la radice dello heap.
     */
    private int parentIndex(int i) {
        return (i - 1) / 2;
    }

    /**
     * Ritorna l'elemento massimo senza toglierlo.
     *
     * @return l'elemento massimo dello heap oppure null se lo heap è vuoto
     */
    public E getMax() {
        return heap.get(0);
    }

    /**
     * Estrae l'elemento massimo dallo heap. Dopo la chiamata tale elemento non
     * è più presente nello heap.
     *
     * @return l'elemento massimo di questo heap.
     */
    public E extractMax() {
        swap(0,heap.size( )-1);
        E max=heap.get(size()-1);
        heap.remove(size()-1);
        heapify(0);
        return max;
    }

    /*
     * Ricostituisce uno heap a partire dal nodo in posizione i assumendo che i
     * suoi sottoalberi sinistro e destro (se esistono) siano heap.
     */
    private void heapify(int i) {
        int max = i; // per adesso largest è la root
        int left = leftIndex(i);
        int right = rightIndex(i);

        // se elemento di left index è maggiore del root
        if (left < heap.size() && heap.get(left).compareTo(heap.get(max)) > 0)
            max = leftIndex(i);//lo metto su largest

        // se elemento di right index è il più lungo fino ad ora
        if (right < size() && heap.get(right).compareTo(heap.get(max)) < 0)
            max = rightIndex(i);//metto su largest

        // se largest non ha root
        if (max != i) {
            swap(i,max);
            // ricorsione
            heapify(max);
        }
    }
        private void swap ( int root, int index){
            E iElement=heap.get(index);
            E rElement=heap.get(root);
            heap.set(root,iElement);
            heap.set(index,rElement);
        }
    }

