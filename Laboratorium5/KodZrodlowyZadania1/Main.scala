import scala.annotation.tailrec

object Main extends App {
def compose[A, B, C](f: A => B)(g: B => C): A => C =
{
  a:A=>g(f(a))
}
def prod[A, B, C, D](f: A => C, g: B => D): (A, B) => (C, D) =
{
  (a:A,b:B)=>(f(a),g(b))
}
def lift[A, B, T](op: (T,T) => T)(f: A => T, g: B => T): (A,B) => T =
{
(a:A,b:B)=>op(f(a),g(b))
}
/*
def suma[A](a:A,b:A):(A,A)=>A=
{
  return a+b
}
*/
//val s=io.StdIn.readInt();
println(compose[Double,Int,String](_.toInt)(_.toString)(1.0))
println(prod[Double,Char,Int,String]( _.toInt, _.toString )(2.1,1))
println(lift[Double,Float,Int](_+_)(_.toInt,_.toInt)(2.1,1))
}