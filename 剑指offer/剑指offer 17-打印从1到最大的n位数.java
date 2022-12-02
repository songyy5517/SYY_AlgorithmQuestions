public class JZ17_sol1 {
    public static void main(String[] args) {
        print1ToMaxN(3);
    }

    public static void print1ToMaxN(int n){
        // 0. 处理异常输入
        if (n<=0){
            System.out.println("Invalid input!");
            return;
        }

        // 0. 初始化
        char[] number = new char[n];
        for (int i = 0; i < n; i++) {
            number[i] = '0';
        }

//        System.out.println(number);

        // 1. 在字符串上模拟数字加法：从0逐步加1直到最大n位数
        // 2. 打印字符串表达的数字
        while(!addone(number)){
            printNum(number);
        }
    }

    public static boolean addone(char[] number){
        int n = number.length;
        boolean overflow = false;  // 判断最高位是否溢出
        int add_to_next = 0;  // 来自上一位的进位值
        int cur_num = 0;  // 第i位上的值

        // 低位 -> 高位
        for (int i = n-1; i >= 0 ; i--) {
            // 1.1 计算第i位的值 (char转换成int)
            cur_num = number[i] - '0' + add_to_next;

            // 1.2 最低位加1
            if (i == n-1)
                cur_num ++;

            // 1.3 判断第i位是否产生进位
            // 1.3.1 产生了进位
            if (cur_num >= 10){
                // 最高位进位
                if (i == 0)
                    overflow = true;

                // 其他位进位
                else {
                    cur_num -= 10;
                    add_to_next = 1;
                    number[i] = (char) (cur_num + '0');
                }
            }

            // 1.3.2 未产生进位
            else {
                add_to_next = 0;
                number[i] = (char) (cur_num + '0');
            }
        }
        return overflow;
    }

    public static void printNum(char[] number){
        boolean isStart = true;  // 判断'0'(当前数位)是否在数字内
        int n = number.length;

        // 高位 -> 低位
        for (int i = 0; i < n; i++) {
            // 2.1 遇到非0数字则将
            if (number[i] != '0')
                isStart = false;

            // 2.2 打印满足条件的数位 (不是补位的'0')
            if (!(isStart == true && number[i] == '0') )
                System.out.print(number[i]);
        }

        System.out.println("");
    }

}

