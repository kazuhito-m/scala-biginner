package samples

import org.specs2.mutable.Specification
import org.mockito.Matchers
import java.io.{IOException, FileNotFoundException, File}
import org.specs2.io.FileReader
import java.io
import java.net.{MalformedURLException, URL}

// 組み込み制御構造
class BuiltinControlStructuresTest extends Specification {

  "条件if式(7.1の内容)" should {

    "命令型スタイルと関数型スタイル" in {
      val args: Array[String] = Array()
      // 命令形スタイル
      var filename1 = "default.txt"
      if (!args.isEmpty)
        filename1 = args(0)
      // 関数型スタイル
      val filename2 = if (!args.isEmpty) args(0) else "default.txt"
      // 等式推論例
      println(if (!args.isEmpty) args(0) else "default.txt")
      // 書き方違えど双方結果は同じ
      filename1 must equalTo(filename2)
    }

  }

  "whileループ(7.2の内容)" should {

    "命令型と関数型で関数定義しループを書いてみる" in {

      // 命令型スタイルの最大公約数計算
      def gcdLoop(x: Long, y: Long): Long = {
        var a = x
        var b = y
        while (a != 0) {
          val temp = a
          a = b % a
          b = temp
        }
        b
      }

      // 関数型スタイルの最大公約数計算
      def gcd(x: Long, y: Long): Long = {
        if (y == 0) x else gcd(y, x % y)
      }

      val i = 9
      val j = 6

      gcdLoop(i, j) must equalTo(gcd(i, j))

    }

  }

  "for式(7.3の内容)" should {

    "for式でディレクトリ内のファイルリストを表示" in {
      var c1 = 0
      val filesHere = (new File(".")).listFiles()
      for (file <- filesHere) {
        println(file)
        c1 += 1
      }
      // Scalaではあまり一般的でないコード
      var c2 = 0
      for (i <- 0 to filesHere.length - 1) {
        println(filesHere(i))
        c2 += 1
      }
      c1 must equalTo(c2)
    }

    "scala式インクリメント処理" in {
      // 指定数値を含む範囲型
      var a = 0
      for (i <- 1 to 4) {
        println("Interation " + i)
        a = a + 1
      }
      // 指定数値を含まない範囲型
      var b = 0
      for (j <- 1 until 4) {
        println("Interation " + j)
        b = b + 1
      }

      // 確認
      (a - 1) must equalTo(b)
    }

    "フィルタリング" in {
      var c1 = 0
      val filesHere = (new File(".")).listFiles()
      for (file <- filesHere if file.getName.endsWith(".scala")) {
        println(file)
        c1 += 1
      }
      // IF文を利用しての同処理
      var c2 = 0
      for (file <- filesHere) {
        if (file.getName.endsWith(".scala")) {
          println(file)
          c2 += 1
        }
      }
      c1 must equalTo(c2)
    }

    "複数のフィルタリングを使用する" in {
      var c = 0

      val filesHere = (new File(".")).listFiles()
      for (
        file <- filesHere
        if file.isFile;
        if file.getName.endsWith(".gitignore")
      ) {
        println(file); c += 1
      }
      c must equalTo(1)
    }

    "入れ子の反復処理" in {

      val filesHere = (new File(".")).listFiles()
      var c = 0

      def fileLines(file: File) = scala.io.Source.fromFile(file).getLines.toList

      def grep(pattern: String) =
        for (
          file <- filesHere
          if file.getName.endsWith(".gitignore");
          line <- fileLines(file)
          if line.trim.matches(pattern)
        ) {
          println(file + ": " + line.trim)
          c += 1
        }

      grep(".*project.*")

      c must equalTo(2)

    }

    "変数への中間結果の束縛" in {

      val filesHere = (new File(".")).listFiles()
      var c = 0

      def fileLines(file: File) = scala.io.Source.fromFile(file).getLines.toList

      def grep(pattern: String) =
        for (
          file <- filesHere
          if file.getName.endsWith(".gitignore");
          line <- fileLines(file); // ここ、教科書とちょっと違うけど、コロンが無ければコンパイルエラーになるから…
          trimmed = line.trim
          if trimmed.matches(pattern)
        ) {
          println(file + ": " + line.trim)
          c += 1
        }

      grep(".*project.*")

      c must equalTo(2)

    }

    "新しいコレクションの作成" in {

      def grepFiles(filesHere: Array[File], extension: String) =
        for {
          file <- filesHere
          if file.getName.endsWith(extension)
        } yield file

      val actual = grepFiles((new File(".")).listFiles(), ".gitignore")

      actual.length must equalTo(1)

    }

    "for式でFileのArrayからIntのArrayを作成する" in {
      val filesHere = (new File(".")).listFiles()
      def fileLines(file: File) = scala.io.Source.fromFile(file).getLines.toList
      val forLineLengths =
        for (
          file <- filesHere
          if file.getName.endsWith(".gitignore");
          line <- fileLines(file);
          trimmed = line.trim
          if trimmed.matches(".*project.*")
        ) yield trimmed.length

      forLineLengths must equalTo(Array(15, 16))
    }

  }

  "try式による例外処理(7.4の内容)" should {

    "trycatchを使った処理" in {

      def fileLoad(path: String): Int = try {
        val f = new io.FileReader(path)
        val res = f.read()
        f.close()
        res
      } catch {
        case ex: FileNotFoundException => 9999
        case ex: IOException => 1111
      }

      val actual = fileLoad(".gitignore")
      actual must equalTo(47)

      val actual2 = fileLoad("notfound.txt")
      actual2 must equalTo(9999)

    }

    "finally節" in {

      def fileLoad(path: String): Int = {
        var f: io.FileReader = null
        try {
          f = new io.FileReader(path)
          f.read()
        } catch {
          case ex: FileNotFoundException => 9999
        } finally {
          if (f != null) f.close()
        }
      }

      val actual = fileLoad(".gitignore")
      actual must equalTo(47)

      val actual2 = fileLoad("notfound.txt")
      actual2 must equalTo(9999)

    }

    "値を生成するcatch句" in {
      def urlFor(path: String) =
        try {
          new URL(path)
        } catch {
          case e: MalformedURLException =>
            new URL("http://www.scala-lang.org")
        }

      val actual = urlFor("http://google.com")
      actual.toString must equalTo("http://google.com")

      val actual2 = urlFor("murimuri")
      actual2.toString must equalTo("http://www.scala-lang.org")

    }

  }

  "match式(7.5の内容)" should {

    "結果値を生成するmatch式" in {

      def friendMatch(arg: String) =
        arg match {
          case "salt" => "pepper"
          case "chips" => "salsa"
          case "eggs" => "bacon"
          case _ => "huh?"
        }

      friendMatch("salt") must equalTo("pepper")
      friendMatch("chips") must equalTo("salsa")
      friendMatch("当たらん場合") must equalTo("huh?")

    }

  }

  "breakとcontinueを使わずに済ませる(7.6の内容)" should {

    "breakやcontinueを使わないループ" in {

      val args = Array("-2.scala", "Test.scala")

      var i = 0
      var foundIt = false

      while (i < args.length && !foundIt) {
        if (!args(i).startsWith("-")) {
          if (args(i).endsWith(".scala")) {
            foundIt = true
          }
        }
        i = i + 1
      }

      foundIt must equalTo(true)

    }

    "var付きのループの代わりに再帰を使ったループ" in {

      def searchFrom(i: Int, args: Array[String]): Int =
        if (i >= args.length) -1
        else if (args(i).startsWith("-")) searchFrom(i + 1, args)
        else if (args(i).endsWith(".scala")) i
        else searchFrom(i + 1, args)

      val actual = searchFrom(0, Array("-2.scala", "Test.scala"))

      actual must equalTo(1)

    }

  }

  "変数のスコープ(7.7の内容)" should {

    "掛け算と変数スコープ(命令形で表すと)" in {

      def makeStringMultiTable(): String = {
        var res = ""
        var i = 1
        // ここではiだけがスコープに入ってる
        while (i <= 10) {
          var j = 1
          // ここではiとjがスコープに入っている
          while (j <= 10) {
            val prod = (i * j).toString
            // ここでは、i,j,prodがスコープに入っている。
            var k = prod.length
            // ここではi,j,k,prodがスコープに入っている
            while (k < 4) {
              res += " "
              k += 1
            }
            res += prod
            j += 1
          }
          //iとjはまだスコープに入っている。prodとkはスコープから外れている。
          res += "\n"
          i += 1
        }
        // iはまだスコープに入っている。j,prod,kはスコープから外れている
        res
      }

      val actual = makeStringMultiTable()

      actual must not beNull

    }

  }


}