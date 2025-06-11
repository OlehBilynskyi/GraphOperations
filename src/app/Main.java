package app;

public class Main {

    public static void main(String[] args) {
        //Створюємо новий об'єкт графа
        Graph graph = new Graph();

//Додаємо вершини до графа
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
//Додаємо ребра між вершинами
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

//Виводимо граф у консоль, щоб побачити вершини та ребра
        System.out.println("Граф після додавання вершин та ребер:");
        graph.printGraph();

//Перевіряємо наявність вершин
        System.out.println("Has vertex 1? " + graph.hasVertex(1));
        System.out.println("Has vertex 4? " + graph.hasVertex(4));
//Перевіряємо наявність ребер
        System.out.println("Has edge 1->2? " + graph.hasEdge(1, 2));
        System.out.println("Has edge 3->1? " + graph.hasEdge(3, 1));
//Видаляємо ребро між вершинами
        graph.removeEdge(1, 2); //Видаляємо ребро від вершини 1 до 2
        System.out.println("Has edge 1->2 after removal? " + graph.hasEdge(1, 2));
//Видаляємо вершину 3
        graph.removeVertex(3);
        System.out.println("Has vertex 3 after removal? " + graph.hasVertex(3));

//Виводимо граф після видалення вершин та ребер
        System.out.println("Граф після видалення вершин та ребер:");
        graph.printGraph();
    }
}
