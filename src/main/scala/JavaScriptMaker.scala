object JavaScriptMaker {
  def main(s: Array[String]): Unit = { 
    println("miura")
  }

  trait JavaScript 

  def randomName = "I"+Math.abs((new java.util.Random).nextLong)

  var callbacks: Map[String, () => JavaScript] = Map()

  def register(f: () => JavaScript) = {
    val name = randomName
    callbacks += name -> f
    <button onclick={"invokeServeCall('"+name+"')"}>ClickMe</button>
  }

/* 未完成。動きません。
  def handleAjax(guid: String): HttpResponse = 
    functionMap.get(guid).map(f => f()) match {
      case Some(javaScript) => JavaScriptResponse(javaScript)
      case _ => Http404Response()

    }
*/
}

