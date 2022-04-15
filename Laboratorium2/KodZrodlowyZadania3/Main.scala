object Main extends App {
  def jestLiczbaPierwsza(s1:Int):Boolean = {
  def helper(s:Int,liczba:Int):Boolean=
  {
    if(liczba<=0)
    {
      return false
    }
    if(liczba==1)
    {
      return true
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
//Goldbach uznawał 1 za liczbę pierwszą
def daSię(n:Int):Boolean=
{
  def helper(n:Int,a:Int,b:Int):Boolean=
  {
    if(n<2)
    {
      return false
    }
    if(n==2)
    {
      println(1+"+"+1+"="+2)
      return true
    }
    if(jestLiczbaPierwsza(a)==true && jestLiczbaPierwsza(b)==true && a+b==n)
    {
      println(a+"+"+b+"="+n)
    }
    if(a==n)
    {
      return helper(n-1,0,n-1)
    }
    return helper(n,a+1,b-1)
  }
  return helper(n,0,n)
}
println(daSię(4))
}