import scala.annotation.tailrec

object Main extends App {
def maksimum(l1: List[Double], l2: List[Double]): List[Double] = {
  @tailrec
  def helper(l1: List[Double], l2: List[Double],listaWynikowa: List[Double],iterator:Int,dlugoscListy:Int): List[Double]=
  {
    if(iterator==dlugoscListy)
    {
      return listaWynikowa.reverse;
    }
    else
    {
      if(l1.isEmpty & l2.isEmpty)
      {
        return helper(l1,l2,listaWynikowa,iterator+1,dlugoscListy);
      }
      else if(l1.isEmpty)
      {
        return helper(l1,l2.tail,l2.head::listaWynikowa,iterator+1,dlugoscListy);
      }
      else if(l2.isEmpty)
      {
        return helper(l1.tail,l2,l1.head::listaWynikowa,iterator+1,dlugoscListy);
      }
      else if(l2.head>=l1.head)
      {
        return helper(l1.tail,l2.tail,l2.head::listaWynikowa,iterator+1,dlugoscListy);
      }
      else
      {
        return helper(l1.tail,l2.tail,l1.head::listaWynikowa,iterator+1,dlugoscListy);
      }
      
    }
  }
  if(l1.length>=l2.length)
  {
    return helper(l1,l2,List(),0,l1.length)
  }
  else
  {
    return helper(l1,l2,List(),0,l2.length)
  }
}
//val s=io.StdIn.readInt();
println(maksimum(List(2.0, -1.6, 3.2, 5.4, -8.4), List(3.3, -3.1, 3.2, -4.1, -0.4, 5.5)))

}