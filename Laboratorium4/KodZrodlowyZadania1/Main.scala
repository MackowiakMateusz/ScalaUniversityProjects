import scala.annotation.tailrec

object Main extends App {
def sumuj(l: List[Option[Double]]): Option[Double] = {
  @tailrec
  def helper(l:List[Option[Double]],suma:Option[Double],iterator:Int,dlugoscListy:Int): Option[Double] = {
    if(iterator==dlugoscListy)
    {
      return suma
    }
    else
    {
      l.head match {
        case None => {
          return helper(l.tail,suma,iterator+1,dlugoscListy)
        }
        case _ =>{
          if(l.head==None)
          {
            return helper(l.tail,suma,iterator+1,dlugoscListy)
          }
          else if(l.head.get<=0)
          {
            return helper(l.tail,suma,iterator+1,dlugoscListy)
          }
          else
          {
            return helper(l.tail,Some(suma.get+l.head.get),iterator+1,dlugoscListy)
          }
        }
      }
    }
  }
  return helper(l,Some(0),0,l.length)
}
//val s=io.StdIn.readInt();
println(sumuj(List(Some(2.0), Some(4.0), Some(-3.0), None, Some(-3.0), None, Some(1.0))))

}