package utility;


public class SquareRoot2 {

            public static void main(String[] args) {
                int[] array = {30, 2, 10, 4, 6};
                int length = array.length;


                int step = length/ 2;//инициализируем шаг.
                while (step > 0)//пока шаг не 0
                {
                    for (int i = 0; i < (length - step); i++)
                    {
                        int j = i;
                        //будем идти начиная с i-го элемента
                        while (j >= 0 && array[j] > array[j + step])
                        //пока не пришли к началу массива
                        //и пока рассматриваемый элемент больше
                        //чем элемент находящийся на расстоянии шага
                        {
                            //меняем их местами
                            int temp = array[j];
                            array[j] = array[j + step];
                            array[j + step] = temp;
                            j--;
                        }
                    }
                    step = step / 2;//уменьшаем шаг
                }
                // Выводим отсортированный массив
                for (int i = 0; i < length; i++) {
                    System.out.print(array[i] + " ");
                }
            }
        }



