object Main extends App {

def jestLiczbaPierwsza(s1:Int):Boolean = {
  def helper(s:Int,liczba:Int):Boolean=
  {
    if(liczba<=1)
    {
      return false
    }
    if (liczba == 2) 
    {
      return true
    }
    if(s==1)
    {
      return true
    }
    if(liczba!=s)
    {
      if(liczba%s==0)
      {
        return false
      }
    }
    
    helper(s-1,liczba)
  }
  return helper(s1,s1)
}
val s=io.StdIn.readInt();
println(jestLiczbaPierwsza(s))

}