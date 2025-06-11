package app;
//Імпортуємо інтерфейс Map, який представляє відображення ключ -> значення

import java.util.Map;
//Імпортуємо клас HashMap - реалізацію Map, що забезпечує швидкий доступ до даних через хешування
import java.util.HashMap;
//Імпортуємо інтерфейс List - представляє впорядковану колекцію елементів
import java.util.List;
//Імпортуємо клас ArrayList - реалізацію List, що забезпечує динамічний масив
import java.util.ArrayList;

public class Graph {
    //Поле для зберігання списків суміжності
    private Map<Integer, List<Integer>> adjacencyList;

    //Конструктор класу
    public Graph() {
        //Ініціалізуємо порожню HashMap для списків сумісності
        adjacencyList = new HashMap<>();
    }

    //Метод для додавання вершин
    public void addVertex(int vertex) {
        //Якщо вершини ще немає в графі, додаємо її з порожнім списком суміжних вершин
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    //Метод для додавання ребра
    public void addEdge(int source, int destination) {
//Додаємо вершини
        addVertex(source);
        addVertex(destination);
//Додаємо ребро: додаємо destination до списку сусідів вершини source
        adjacencyList.get(source).add(destination);
    }

    //Метод для видалення вершин
    public void removeVertex(int vertex) {
//Видаляємо вершину зі списку суміжності
        adjacencyList.remove(vertex);
//Проходимо по всіх списках суміжності та видаляємо цю вершину зі списків
        for (List<Integer> neighbors : adjacencyList.values()) {
            neighbors.remove(Integer.valueOf(vertex));
        }
    }

    //Метод для видалення ребра
    public void removeEdge(int source, int destination) {
//Отримуємо список сусідів вершини source
        List<Integer> neighbors = adjacencyList.get(source);
        if (neighbors != null) {
            //Видаляємо destination зі списку
            neighbors.remove(Integer.valueOf(destination));
        }
    }

    //Метод для перевірки наявності вершин
    public boolean hasVertex(int vertex) {
        //Повертає true, якщо вершина існує в мапі
        return adjacencyList.containsKey(vertex);
    }

    //Метод для перевірки наявності ребра
    public boolean hasEdge(int source, int destination) {
        //Отримуємо список сусідів вершини source
        List<Integer> neighbors = adjacencyList.get(source);
        //Повертаємо true, якщо список не порожній і містить destination
        return neighbors != null && neighbors.contains(destination);
    }

    //Виводимо граф у консоль у форматі "вершина -> список суміжних вершин"
    public void printGraph() {
        //Проходимо по всіх парах ключ-значення у мапі adjacencyList
        //Ключ - вершина графа (тип int), значення - список суміжних вершин (List<Integer)
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            //Отримуємо вершину (ключ з мапи)
            int vertex = entry.getKey();
            //Отримуємо список сусідів (вершин, з якими є ребро від vertex)
            List<Integer> neighbors = entry.getValue();
            //Виводимо номер вершин і стрілку для наочного зв'язку
            System.out.print(vertex + " -> ");
            //Проходимо по списку сусідніх вершин
            for (int neighbor : neighbors) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

}