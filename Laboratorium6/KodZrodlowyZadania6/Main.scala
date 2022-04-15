import scala.annotation.tailrec

object Main extends App {
/*
//Korzystając z metod sliding, map, foldLeft/foldRight zdefiniuj funkcję:
def isOrdered[A](seq: Seq[A])(leq:(A, A) => Boolean): Boolean = 
{
  
  if(seq==Seq())
  {
    return false
  }
  for (element <- seq.sliding(2).toList){ if(leq(element(0),element(1))==false){return false}}
  return true
  
}
println(isOrdered[Int](Seq(1, 2, 2, 4))(_ < _))
println(isOrdered[Int](Seq(1, 2, 2, 4))(_ <= _))
//która zwróci informację czy wszystkie sąsiednie elementy w seq, są zgodne z predykatem leq.
//Przykłady:
//Dla seq = Seq(1, 2, 2, 4) i (_ < _) funkcja powinna zwrócić false.
//Dla seq = Seq(1, 2, 2, 4) i (_ <= _) funkcja powinna zwrócić true.
*/

//Korzystając z metod oferowanych przez kolekcje iterowalne (Iterable[A]) napisz funkcję
def countChars(str: String): Int =
{
  return str.toList.distinct.length
}
print(countChars("AABBCC"))//roznych znaków, czyli w tym przypadku A,B,C czyli 3 rozne znaki
//która wylicza ile różnych znaków, użyto w napisie str.
//Podpowiedź: pomyśl o wykorzystaniu jednej z metod konwersji.

}