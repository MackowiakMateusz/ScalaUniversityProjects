import scala.annotation.tailrec

object Main extends App {
def ciag(n:Int):Int = {
  @tailrec
  def helper(poprzedniejszy:Int,poprzedni:Int,suma:Int,n:Int,iterator:Int):Int=
  {
    if(iterator==n)
    {
        return poprzedni+poprzedniejszy
    }
    else if(iterator>1)
    {
      return helper(poprzedni,suma,poprzedni+suma,n,iterator+1)
    }
    else
    {
      return helper(poprzedniejszy,poprzedni,suma,n,iterator+1)
    }
  }
  return helper(1,1,2,n,0)
}
//val s=io.StdIn.readInt();
println(ciag(3))//fibonnaciego

}