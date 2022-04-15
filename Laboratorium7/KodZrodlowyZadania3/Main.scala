import scala.annotation.tailrec

object Main extends App {
//Korzystając z metod oferowanych przez kolekcje zdefiniuj funkcję:
def minNotContained(set: Set[Int]): Int =
{
    if(set==Set())
    {
        return 0
    }
    //println(set.filter(_>=0).toList.sorted.sliding(2).toList.map(x=>if(x(1)-x(0)>1){x(0)+1}else{-1}).max)
    return set.filter(_>=0).toList.sorted.sliding(2).toList.map(x=>if(x(1)-x(0)>1){x(0)+1}else{-1}).max
}
println(minNotContained(Set(-3, 0, 1, 2, 5, 6)))
//która zwróci najmniejszą nieujemną liczbę całkowitą, która nie występuje w zbiorze set.
//Przykład:
//Dla: set = Set(-3, 0, 1, 2, 5, 6), funkcja powinna zwrócić: 3.
}