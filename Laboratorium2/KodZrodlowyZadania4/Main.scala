object Main extends App {
  // n to kolumna, m to rzad
def wydrukujSpace(n:Int):Unit=
{
  def helper(n:Int,i:Int):Unit=
  {
    if(i>n)
    {
      return ()
    }
    print(" ")
    return helper(n,i+1)
  }
  return helper(n,0)
}
def zwrocLiczbe(n:Int,m:Int):Int={
  if(n==1||n==m)
  {
    return 1
  }
  else
  {
    return zwrocLiczbe(n-1,m-1)+zwrocLiczbe(n,m-1)
  }
}
def trójkąt(wys:Int):Unit=
{
  def helper(wys:Int,rzad:Int,kolumna:Int):Unit=
  {
    if(rzad==1)//drukowanie spacji na pierwszej linijce
    {
      wydrukujSpace(wys-rzad)
      print(" ")
    }
    if(rzad>wys)
    {
      return ()
    }
    print(zwrocLiczbe(kolumna,rzad)+" ")
    if(kolumna!=rzad)
    {
      return helper(wys,rzad,kolumna+1)
    }
    else
    {
      println()
      wydrukujSpace(wys-rzad)
      return helper(wys,rzad+1,1)
    }
  }
  return helper(wys,1,1)
}
println(trójkąt(6))
}