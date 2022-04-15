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

//Korzystając z metod oferowanych przez kolekcje zdefiniuj funkcję:
def swap[A](seq: Seq[A]): Seq[A] =
{
  
  if(seq.length<2)
  {
    return seq
  }
  else
  {
    def helper[A](seq: Seq[A],newSeq:Seq[A]): Seq[A] = 
    {
      if(seq==Seq())
      {
        return newSeq
      }
      else
      {
        
        if(seq.length>=2)
        {
          helper(seq.tail.tail,newSeq :+ seq.tail.head :+ seq.head)
        }
        else
        {
          return newSeq :+ seq.head
        }
        
        
      }
    }
    return helper(seq,Seq())
  }
  
}
println(swap[Int](Seq(1, 2, 3, 4, 5)))
//która zamieni kolejnością wartości znajdujących się na parzystych i nieparzystych indeksach.
//Przykład:
//Dla: seq = Seq(1, 2, 3, 4, 5), Seq(2, 1, 4, 3, 5).

}