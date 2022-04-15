import scala.annotation.tailrec

object Main extends App {
def tasuj(l1: List[Int], l2: List[Int]): List[Int] = {
  @tailrec
  def helper(l1: List[Int], l2: List[Int],listaWynik: List[Int]): List[Int] = {
    (l1,l2,listaWynik.reverse) match{
      case (List(),List(),_)=>return listaWynik.reverse
      case (List(),l2h::l2t,_)=>{
        return helper(l1,l2t,l2h::listaWynik)
      }
      case (l1h::l1t,List(),_)=>{
        return helper(l1t,l2,l1h::listaWynik)
      }
      case (l1h::l1t,l2h::l2t,lwh::lwt)=>{
        if(l1h!=lwh && l2h!=lwh)
        {
          return helper(l1t,l2t,l2h::l1h::listaWynik)
        }
        else if(l1h!=lwh)
        {
          return helper(l1t,l2t,l1h::listaWynik)
        }
        else if(l2h!=lwh)
        {
          return helper(l1t,l2t,l2h::listaWynik)
        }
        else
        {
          return helper(l1t,l2t,listaWynik)
        }
      }
      case (l1h::l1t,l2h::l2t,List())=>{
        if(l1h!=l2h)
        {
          return helper(l1t,l2t,l2h::l1h::listaWynik)
        }
        else
        {
          return helper(l1t,l2t,l1h::listaWynik)
        }
      }
    }
  }
  return helper(l1,l2,List[Int]())
}
//val s=io.StdIn.readInt();
println(tasuj(List(2, 4, 3, 5), List(1, 2, 2, 3, 1, 5)))
// okey, zrobilem tak ze elementy nie powtarzaja sie zaraz po sobie, a 
//ostatni element listy jest >= od wszystkich przed nim, czyli porzadek rosnacy
}