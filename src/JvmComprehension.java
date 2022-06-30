public class JvmComprehension { //Подсистема загрузчиков классов подгружает в Метаспейс классы JVMComprehension и Object.
    // Класс Object подгружается из Bootstrap Classloader'а, а класс JVMComprehension подгружается из Application ClassLoader'a.

    public static void main(String[] args) {//создается фрейм в Стек Мемори
        int i = 1;                      // 1 во фрейме main создается переменная i
        Object o = new Object();        // 2 в хипе выделяется память под создание объекта o класса Object, создается объект, во фрейме мейн появляется ссылка на объект
        Integer ii = 2;                 // 3 во фрейме мейн создается переменная ii
        printAll(o, i, ii);             // 4 в Стек Мемори создается фрейм printAll, в котором записываются переменные i, ii и ссылка на объект o.
        System.out.println("finished"); // 7 в Стек Мемори создается фрейм println, в который передается ссылка на строку "finished", созданную в хипе.
    }

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // 5 во фрейме printAll записывается ссылка на объект Integer uselessVar, созданный в хипе. Этот объект будет удален сборщиком мусора, так как на него нигде нет ссылок и он вне ветви приложения
        System.out.println(o.toString() + i + ii);  // 6 в Стек Мемори создается фрейм println с записанными переменными i, ii и строковым выражением объекта o.
        // Для получения строкового выражения объекта о в Стек Мемори также создается фрейм.
    }
}