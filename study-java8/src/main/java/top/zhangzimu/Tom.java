package top.zhangzimu;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Tom {
    public static void tomSay(Person p){
        String helloJerry = p.say("hello jerry");
        System.out.println(helloJerry);

    }
    public static void main(String[] args) {
//        Tom.tomSay((msg)-> "你好：" + msg);

        List<Integer> list = Arrays.asList(13, 2, 26, 19, 7, 556, 684, 184, 124);
        // 对list进行排序 正序
        list.sort(Comparator.comparingInt(Integer::intValue));
        // 倒序
        list.sort(Comparator.comparingInt(Integer-> -Integer));

        // 遍历打印list
        list.stream().forEach(System.out::println);
        // 将list中的所有数据*10后打印
        list.stream()
                .map(item -> item * 10) // 所有项*10
                .filter(item -> item > 40) // 返回大于40的数
                .sorted((num1, num2) -> num1 - num2) // 排序：正序、(num1 - num2) 倒序、（num2 - num1）
                .distinct() // 去重
//                .reduce((num1, num2) -> num1 + num2) // 累加
                .limit(5) // 保留5条数据
//                .allMatch(item -> item > 50)  // 是否所有的元素都大于50
                .forEach(item -> System.out.println(item));


        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock.getZone()); // 获取时区

        LocalDateTime localDate = LocalDateTime.now();
        System.out.println(localDate);  // 获取带时间的当前日期

        // 时间格式化
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String format = localDate.format(dateTimeFormatter);
        System.out.println(format);
    }

}
