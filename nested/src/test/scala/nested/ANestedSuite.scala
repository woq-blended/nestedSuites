package nested

import org.scalatest.{Args, Status}
import org.scalatest.freespec.AnyFreeSpec

class ANestedSuite(dummy : Int) extends AnyFreeSpec {


  "The nested suites should" - {

    "also be exectuted" in {
      assert(true)
    }
  }

  override def run(testName: Option[String], args: Args): Status = {
    println(testName + "-" + testNames)
    super.run(testName, args)
  }
}
