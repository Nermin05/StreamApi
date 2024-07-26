import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Assignment {
    public List<Employee> first() {
     return Data.datas().stream().filter(employee->employee.getAge()>30).toList();
    }
    public List<String> second() {
        return Data.datas().stream().map(Employee::getName).toList();
    }
    public Optional<Employee> third() {
        return Data.datas().stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).findFirst();
    }
    public OptionalDouble fourth() {
        return Data.datas().stream().mapToDouble(Employee::getSalary).average();
    }
    public List<Employee> fifth() {
        return Data.datas().stream().sorted(Comparator.comparing(Employee::getSurname)).toList();
    }
    public boolean sixth() {
        return Data.datas().stream().allMatch(employee->employee.getAge()>25);
    }
    public List<Employee> seventh() {
        return Data.datas().stream().filter(employee -> employee.getDepartment().equals(Department.IT)).toList();
    }
    public Map<Department,List<Employee>> eighth() {
        return Data.datas().stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }
    public Map<Department, Long> nineth() {
       // int count=1;
        return Data.datas().stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
    }
    public Map<Department, Double> tenth() {
        return Data.datas().stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.averagingInt(Employee::getAge)));
    }
    public Map<Boolean, List<Employee>> eleventh() {
        return Data.datas().stream().collect(Collectors.groupingBy(Employee::isEmployer));
    }
    public double twelfth() {
        return Data.datas().stream().mapToDouble(Employee::getSalary).sum();
    }
    public Optional<Employee> thirteenth() {
        return Data.datas().stream().sorted(Comparator.comparingDouble(Employee::getSalary)).findFirst();
    }
//    public List<Employee> fourteenth() {
//        return Data.datas().stream().;
//    }
public Map<Double, List<String>> fiftenth() {
    return Data.datas().stream().collect(Collectors.groupingBy(Employee::getSalary, Collectors.mapping(Employee::getName,
            Collectors.toList())
           ));
}
    public List<Employee> sixteenth() {
        return Data.datas().stream().filter(employee -> !employee.isEmployer()).toList();
    }

    public List<String> seventeenth() {
        return Data.datas().stream().map(employee -> employee.getName()+" "+employee.getSurname()).toList();
    }
    public List<Double> eighteenth() {
        return Data.datas().stream().mapToDouble(employee-> employee.getSalary()*1.10).boxed().toList();
    }
    public double nineteenth() {
        return Data.datas().stream().filter(employee -> employee.getDepartment().equals(Department.IT))
                .mapToDouble(Employee::getSalary).sum();
    }
    public Map<Department, Double> twenty() {
        return Data.datas().stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.summingDouble(Employee::getSalary)));
    }
    public List<Employee> twentyOne() {
        OptionalDouble toplam=Data.datas().stream().mapToDouble(Employee::getSalary).average();
        return Data.datas().stream().filter(employee -> employee.getSalary()>toplam.getAsDouble()).toList();
    }
    public Map<Integer,Employee> twentyTwo() {
        return Data.datas().stream().collect(Collectors.toMap(Employee::getId,employee -> employee));
    }
    public List<Employee> twentyThree() {
        return Data.datas().stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).toList();
    }

    public Optional<Employee> twentyFour() {
        return Data.datas().stream().sorted(Comparator.comparingInt(Employee::getAge).reversed()).findFirst();
    }
    public List<String> twentyFive() {
        return Data.datas().stream().map(employee -> employee.getName()+" "+employee.getSurname()).toList();
    }
    public List<Long> twentySeven() {
        return Data.datas().stream().map(employee -> (long) ((LocalDate.now().getYear()-employee.getStartDate().getYear()))).toList();
    }
    public Optional<Employee> twentyEight() {
        return Data.datas().stream().max(Comparator.comparingLong((employee->
                LocalDate.now().getYear()-employee.getStartDate().getYear())));
    }
public Map<Position, Long> thirty() {
    return Data.datas().stream().collect(Collectors.groupingBy(Employee::getPosition, Collectors.counting()));
}

}
