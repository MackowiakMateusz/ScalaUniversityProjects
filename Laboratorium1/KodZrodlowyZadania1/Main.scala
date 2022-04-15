object Main extends App {
  def obramuj(napis: String): String =
  {
    var dlugosc:Int = 0;
    var tablica:Array[String] = napis.split('\n');
    var NajdluzszaDlugosc:Int = 0;
    for( i <- 0 to tablica.length-1)
    {
      if(NajdluzszaDlugosc<tablica(i).length)
      {
        NajdluzszaDlugosc=tablica(i).length;
      }
    }
    //rysowanie pierwszej lini ramki
    for( i <- 1 to NajdluzszaDlugosc+4)
      {
        print("*");
      }
    println("");
    //petla ktora kazde slowo oddzielane znakiem konca lini wypisuj
    for( i <- 0 to tablica.length-1)
    {
      print("* ");
      print(tablica(i));
      for( i <- 0 to NajdluzszaDlugosc-tablica(i).length)//ta petla wypisuje space
      {
        print(" ");
      }
      println("*");
    }
    //rysowanie ostatniej lini ramki
    for( i <- 1 to NajdluzszaDlugosc+4)
      {
        print("*");
      }
    return "";
  }
  obramuj("Napis\nNapisik\nNapisek\nNapisiuniek\nNapisus");
}

