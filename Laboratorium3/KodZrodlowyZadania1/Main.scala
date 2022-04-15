object Main extends App {
  def reverse(s:String):String = {
    def helper(s1:String,acc:String):String={
      if (s1 == "") 
      {
        return acc
      }
      else 
      {
        return helper(s1.tail, s1.head + acc)
      }
    }
  helper(s,acc = "")
}
println(reverse("kot"))
}