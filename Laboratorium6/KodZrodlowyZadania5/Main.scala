import scala.annotation.tailrec

object Main extends App {

/*
//Korzystając z metod filter, map i zipWithIndex zdefiniuj funkcję:
def remElems[A](seq: Seq[A], k: Int): Seq[A] =
{
  if(seq==Seq())
  {
    return seq
  }
  if(k>seq.length)//gdyby index byl wiekszy niz dlugosc listy
  {
    return seq
  }
  seq.filter(_!=seq(k))
}
//println(Seq(1, 2, 3, 4, 3, 2, 5, 6).zipWithIndex)
println(remElems[Int](Seq(0, 1, 2, 3, 4, 5, 6, 7),2))
//val cos:Seq[Int]=Seq(2,4,5)
//która usunie k-ty element sekwencji seq.
*/
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
}