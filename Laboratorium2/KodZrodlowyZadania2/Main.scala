object Main extends App {

def jestPalindromem(tab:Array[Int]):Boolean=
{
  def helper(tablica:Array[Int],i:Int):Boolean=
  {
    if(i>=tablica.size)
    {
      return true
    }
    if(tablica(i)!=tablica(tablica.size-i-1))
    {
      return false
    }
    
    return helper(tablica,i+1)
  }
  return helper(tab,0)
}
println(jestPalindromem(Array(1,2,3,2,1)))
}