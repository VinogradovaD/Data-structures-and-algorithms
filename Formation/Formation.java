package com.company;

public class Formation {

    public static void main(String[] args) {
        int dataArray[] = {20, 18, 19, 15, 17, 16, 3, 25, 22, 27, 26, 28, 21, 23};
        Node root = null;

        Node z = new Node();
        z.key = dataArray[0];
        z.parent = null;
        root = insert(z, root);
        for (int i = 1; i < dataArray.length; i++) {
            z = new Node();
            z.key = dataArray[i];
            insert(z, root);
        }

        Node t = new Node();

        for (int i = 1; i < dataArray.length; i++) {
            t = search(root, dataArray[i]);

            try {
                System.out.println("Значение баланса узла: " + getBalance(t));
            } catch (Balance_Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("корень поддерева: " + t.key);
            System.out.println("родитель: " + (t.parent != null ? t.parent.key : "null"));
            System.out.println("левый потомок: " + (t.left != null ? t.left.key : "null"));
            System.out.println("правый потомок: " + (t.right != null ? t.right.key : "null"));
            System.out.println("*************************************************************");
        }


        //ArithmeticException
        try {
            int a = dataArray[3];
            int b = 0;
            int c = a / b;
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e + ". Делить на ноль нельзя!:(");
        }

        //IndexOutOfBoundException
        try {
            int a = dataArray[-1];
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ошибка: " + e + ". Вы вышли за пределы массива.");
        }

        //NullPointerException
        try {
            String str = null;
            System.out.println(str.hashCode());
        } catch (NullPointerException e) {
            System.out.println("Ошибка: " + e + ". Пустая строка !");
        }

        //NumberFormatException
        try {
            String str = "world";
            int s = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: " + e + ". Неверное преобразование текстовой строки в числовой формат.");
        }

        //IllegalArgumentException
        try {
            throwOne();
        } catch (IllegalAccessException e) {
            System.out.println("Ошибка: " + e + ". Недопустимые значения аргументов в методе");
        }

    }

    static void throwOne() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    public static Node insert(Node z, Node x) {
        if (x == null) {
            x = z;
        } else if (z.key < x.key) {
            x.left = insert(z, x.left);
            x.left.parent = x;
        } else {
            x.right = insert(z, x.right);
            x.right.parent = x;
        }
        return x;
    }

    public static Node search(Node x, int k) {
        if ((x == null) || (k == x.key))
            return x;
        if (k < x.key)
            return search(x.left, k);
        else
            return search(x.right, k);
    }


    public static int h(Node x) {
        if (x == null)
            return -1;
        else return Math.max(h(x.left), h(x.right)) + 1;
    }

    public static int getBalance(Node t) throws Balance_Exception {

        int result = h(t.left) - h(t.right);// формула для высчитывания баланса
        if (result > 1) throw new Balance_Exception("Число больше 1 , оно равно " + result, result);

        return result;
    }
}