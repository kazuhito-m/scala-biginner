package samples

import java.io.File

object FileMatcher {

  private def filesHere = (new File(".")).listFiles

  def filesMatching(query: String, matcher: (String) => Boolean) = {
    for (file <- filesHere; if matcher(file.getName))
      yield file
  }

  def fileEnding(query: String) = filesMatching(query, _.endsWith(query))

  def filesContaining(query: String) = filesMatching(query , _.contains(query))

  def filesRegex(query: String) = filesMatching(query, _.matches(query))

}

